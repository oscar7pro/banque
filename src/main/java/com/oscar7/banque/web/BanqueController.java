package com.oscar7.banque.web;

import com.oscar7.banque.entities.Compte;
import com.oscar7.banque.entities.Operation;
import com.oscar7.banque.service.IBanqueService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BanqueController {
    @Autowired
    IBanqueService banqueMetier;

    @RequestMapping("/operations")
    public String index(){
        return "comptes";
    }

    @RequestMapping(value = "/consulterCompte", method = RequestMethod.GET)
    public String consulterCompte(final Model model, final String codeCompte,
                                  @RequestParam(name = "page", defaultValue = "0") final  int page,
                                  @RequestParam(name = "size", defaultValue = "3") final int size){
        model.addAttribute("codeCompte", codeCompte);
        try{
            Compte compte = banqueMetier.consulterCompte(codeCompte);
            Page<Operation> operationPages = banqueMetier.listOperation(codeCompte,page,size);
            model.addAttribute("listeOperations", operationPages.getContent());
            int [] pages = new int [operationPages.getTotalPages()];
            model.addAttribute("pages", pages);
            model.addAttribute("compte", compte);

        } catch (Exception e) {
            model.addAttribute("exception", e);
        }
        return "comptes";
    }

    @RequestMapping(value = "/enregistrerOperation", method = RequestMethod.POST)
    public String EnregistrerOperation(final Model model, final String typeOperation, final String codeCompte, final double montant, final String  codeCompte2) {
        try{
            if(typeOperation.equals("VERS")) {
                banqueMetier.verser(codeCompte, montant);
            }
            if(typeOperation.equals("RET")) {
                banqueMetier.retirer(codeCompte, montant);
            }
            if(typeOperation.equals("VIR")) {
                banqueMetier.virement(codeCompte, codeCompte2, montant);
            }

        }catch (Exception e) {
            model.addAttribute("error", e);
            return "redirect:consulterCompte?codeCompte="+codeCompte+"&error="+e.getMessage();
        }
        return "redirect:consulterCompte?codeCompte="+codeCompte;
    }

}

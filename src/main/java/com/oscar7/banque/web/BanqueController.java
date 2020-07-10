package com.oscar7.banque.web;

import com.oscar7.banque.entities.Compte;
import com.oscar7.banque.metier.IBanqueMetier;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BanqueController {
    @Autowired
    IBanqueMetier banqueMetier;

    @RequestMapping("/operations")
    public String index(){
        return "comptes";
    }

    @RequestMapping(value = "/consulterCompte", method = RequestMethod.GET)
    public String consulterCompte(final Model model, String codeCompte){
        try{
            Compte compte = banqueMetier.consulterCompte(codeCompte);
            model.addAttribute("compte", compte);

        } catch (Exception e) {
            model.addAttribute("exception", e);
        }
        return "comptes";
    }

}

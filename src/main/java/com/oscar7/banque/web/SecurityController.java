package com.oscar7.banque.web;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {
  /*  @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }*/

    @RequestMapping(value = "/")
    public String homepage() {
        return "redirect:operations";
    }

    @RequestMapping(value = "/403")
    public String accessDeniedPage() {
        return "403";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("redirect:403");
        }
        return new ModelAndView("login");
    }
}

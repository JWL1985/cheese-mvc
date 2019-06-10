package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value= "/cheese")
public class cheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();

    @RequestMapping(value= "")
    public String index(Model model) {


        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "/cheese/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "/cheese/add";

    }
    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        cheeses.put(cheeseName, cheeseDescription);
        return "redirect:";
    }

    @RequestMapping(value="remove", method = RequestMethod.GET)
    public String removeCheese(Model model) {
        model.addAttribute("cheeses", cheeses);
        return "/cheese/remove";
    }

    @RequestMapping(value="remove", method = RequestMethod.POST)
    public String processRemoveCheese(@RequestParam ArrayList<String> cheese) {
        for(int i = 0; i < cheese.size(); i++) {
            cheeses.remove(cheese.get(i));
        }
        return "/cheese/remove";
    }


}

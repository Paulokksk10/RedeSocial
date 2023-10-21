package com.zuiter.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.zuiter.model.RedeSocial;
import com.zuiter.repository.RedeSocialRepository;


@Controller
@RequestMapping("/redesocial")
public class RedeSocialController {

    @Autowired
    private RedeSocialRepository repository;

    @GetMapping("/home")
    public String mostrarFormularioCriar(Long id, Model model) {
        if (id != null) {
            RedeSocial a1 = repository.getReferenceById(id);
            model.addAttribute("evento", a1);
        }
        return "redesocial/home";
    }
}

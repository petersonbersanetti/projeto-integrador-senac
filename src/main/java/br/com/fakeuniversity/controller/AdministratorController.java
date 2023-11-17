package br.com.fakeuniversity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministratorController {

    @GetMapping("/administrator")
    public String index(){
        return "administrator/index";
    }
}

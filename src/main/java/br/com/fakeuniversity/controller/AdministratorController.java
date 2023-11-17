package br.com.fakeuniversity.controller;


import br.com.fakeuniversity.models.User;
import br.com.fakeuniversity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class AdministratorController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/administrator")
    public String index(Model model){
        List<User> users = (List<User>)userRepository.findAll();
        model.addAttribute("user", users);
        return "administrator/index";
    }

    @GetMapping("/administrator/novo")
    public String novo() {
        return "administrator/novo";
    }

    @PostMapping("/administrator/criar")
    public String novo(User user) {
        userRepository.save(user);
        return "redirect:/administrator";
    }

    @GetMapping("/administrator/{id}")
    public String busca(@PathVariable long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        try {
            model.addAttribute("user", user.get());
        } catch (Exception exception) {

            return "redirect:/administrator";
        }
        return "administrator/editar";
    }

    @PostMapping("/administrator/{id}/atualizar")
    public String atualizar(@PathVariable long id, User user) {
        if(!userRepository.existsById(id)){
            return "redirect:/administrator";
        }
        userRepository.save(user);
        return "redirect:/administrator";
    }

    @GetMapping("/administrator/{id}/excluir")
    public String excluir(@PathVariable long id) {
        userRepository.deleteById(id);
        return "redirect:/administrator";
    }
}

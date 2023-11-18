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

public class ProfessorController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/adiciona_nota")
    public String nota(User nota) {
        userRepository.save(nota);
        return "redirect:/professor";
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
        if (!userRepository.existsById(id)) {
            return "redirect:/administrator";
        }
        userRepository.save(user);
        return "redirect:/administrator";
    }
}

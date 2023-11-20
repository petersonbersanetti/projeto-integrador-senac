package br.com.fakeuniversity.controller;

import br.com.fakeuniversity.models.Aluno;
import br.com.fakeuniversity.models.Fornecedor;
import br.com.fakeuniversity.models.Professor;
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

    // INDEX PF
    @GetMapping("/pf/index")
    public String pf() {
        return "pf/index";
    }

    //ALUNO

    @GetMapping("/pf/aluno/novoaluno")
    public String aluno() {
        return "pf/aluno/novoaluno";
    }

    @PostMapping("/pf/aluno/criar")
    public String novoAluno(Aluno aluno) {
        userRepository.save(aluno);
        return "redirect:/administrator";

    }

    //PROFESSOR

    @GetMapping("/pf/professor/novoprofessor")
    public String professor() {
        return "pf/professor/novoprofessor";
    }

    @PostMapping("/pf/professor/criar")
    public String novoProfessor(Professor professor) {
        userRepository.save(professor);
        return "redirect:/administrator";
    }

    //FORNECEDOR
    @GetMapping("/pj/novofornecedor")
    public String fornecedor() {
        return "pj/novofornecedor";
    }

    @PostMapping("/pj/fornecedor/criar")
    public String novo(Fornecedor fornecedor) {
        userRepository.save(fornecedor);
        return "redirect:/administrator";
    }

    ///////////////////////////////////////////////////////////////


    @GetMapping("/administrator")
    public String index(Model model) {
        List<User> users = (List<User>) userRepository.findAll();
        model.addAttribute("user", users);
        return "administrator/index";
    }

    @GetMapping("/administrator/{id}")
    public String busca(@PathVariable long id, Model model) {
        Optional<User> userOptional = userRepository.findById(id);
        try {
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                model.addAttribute("user", user);

                String funcao = user.getTxFuncao();

                if ("Professor".equalsIgnoreCase(funcao) || "Aluno".equalsIgnoreCase(funcao)) {
                    return "pf/editarpf";
                } else if ("Fornecedor".equalsIgnoreCase(funcao)) {
                    return "pj/editarpj";
                }
            } else {
                return "redirect:/administrator";
            }

        } catch (Exception exception) {
            return "redirect:/administrator";
        }
        return "redirect:/administrator";
    }



        @PostMapping("/administrator/{id}/atualizar")
        public String atualizar (@PathVariable long id, User user){
            if (!userRepository.existsById(id)) {
                return "redirect:/administrator";
            }
            userRepository.save(user);
            return "redirect:/administrator";
        }


        @GetMapping("/administrator/{id}/excluir")
        public String excluir (@PathVariable long id){
            userRepository.deleteById(id);
            return "redirect:/administrator";
        }
}


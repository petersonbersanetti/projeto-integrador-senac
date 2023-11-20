package br.com.fakeuniversity.controller;

import br.com.fakeuniversity.model.Aluno;
import br.com.fakeuniversity.model.Fornecedor;
import br.com.fakeuniversity.model.Professor;
import br.com.fakeuniversity.repository.AlunoRepository;
import br.com.fakeuniversity.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    //PROFESSOR

    @GetMapping("/pf/professor/novoprofessor")
    public String professor() {
        return "pf/professor/novoprofessor";
    }

    @PostMapping("/pf/professor/criar")
    public String novoProfessor(Professor professor) {
        professorRepository.save(professor);
        return "redirect:/administrator";
    }
}
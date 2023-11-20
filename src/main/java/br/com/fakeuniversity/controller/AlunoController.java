package br.com.fakeuniversity.controller;

import br.com.fakeuniversity.model.Aluno;
import br.com.fakeuniversity.model.Fornecedor;
import br.com.fakeuniversity.model.Professor;
import br.com.fakeuniversity.repository.AlunoRepository;
import com.fasterxml.jackson.databind.node.ValueNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    //ALUNO

    @GetMapping("/pf/aluno/novoaluno")
    public String aluno() {
        return "pf/aluno/novoaluno";
    }

    @PostMapping("/pf/aluno/criar")
    public String novoAluno(Aluno aluno) {
        alunoRepository.save(aluno);
        return "redirect:/administrator";

    }

    @PostMapping("/aluno/{id}/atualizar")
    public String atualizarAluno(@PathVariable Long id, Aluno aluno){
        if(!alunoRepository.existsById(id)){
            return "redirect:/administradores";
        }
        alunoRepository.save(aluno);
        return "redirect:/administradores";
    }



}
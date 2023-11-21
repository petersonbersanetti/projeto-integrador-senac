package br.com.fakeuniversity.controller;

import br.com.fakeuniversity.model.Administrador;
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

import java.util.List;
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

    @GetMapping("/pf/professor")
    public String painel() {
        return "pf/professor";
    }

    @GetMapping("/pf/professor/index")
    public String index(Model model) {
        List<Aluno> alunos = (List<Aluno>) alunoRepository.findAll();
        model.addAttribute("alunos", alunos);
        return "pf/professor/index";
    }

    @PostMapping("/pf/professor/criar")
    public String novoProfessor(Professor professor) {
        professorRepository.save(professor);
        return "redirect:/administrator";
    }

    @PostMapping("/professor/{id}/atualizar")
    public String atualizarProfessor(@PathVariable Long id, Professor professor){
        if(!professorRepository.existsById(id)){
            return "redirect:/administrator";
        }
        professorRepository.save(professor);
        return "redirect:/administrator";
    }

    @GetMapping("/professor/{id}/excluir")
    public String atualizar(@PathVariable Long id){
        professorRepository.deleteById(id);
        return"redirect:/administrator";
    }

    @GetMapping("/professor/{id}")
    public String buscaProfessor(@PathVariable Long id, Model model){
        Optional<Professor> professor = professorRepository.findById(id);
        try{
            model.addAttribute("professor", professor.get());
        }
        catch(Exception err){
            return "redirect:/administrator";
        }
        return "/pf/professor/editarprofessor";
    }


    @GetMapping("/aluno/{id}")
    public String buscaAluno(@PathVariable Long id, Model model){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        try{
            model.addAttribute("aluno", aluno.get());
        }
        catch(Exception err){
            return "redirect:/administrator";
        }
        return "/pf/aluno/editarnotaaluno";
    }



}

package br.com.fakeuniversity.controller;

import br.com.fakeuniversity.model.Administrador;
import br.com.fakeuniversity.model.Aluno;
import br.com.fakeuniversity.model.Fornecedor;
import br.com.fakeuniversity.model.Professor;
import br.com.fakeuniversity.repository.AdminRepository;
import br.com.fakeuniversity.repository.AlunoRepository;
import br.com.fakeuniversity.repository.FornecedorRepository;
import br.com.fakeuniversity.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class AdministratorController {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private AdminRepository adminRepository;

    // INDEX PF
    @GetMapping("/pf/index")
    public String pf() {
        return "pf/index";
    }

    @GetMapping("/administrator")
    public String index(Model model) {
        List<Aluno> alunos = (List<Aluno>) alunoRepository.findAll();
        model.addAttribute("alunos", alunos);
        List<Professor> professores = (List<Professor>) professorRepository.findAll();
        model.addAttribute("professores", professores);
        List<Fornecedor> fornecedores = (List<Fornecedor>) fornecedorRepository.findAll();
        model.addAttribute("fornecedores", fornecedores);
        List<Administrador> administradores = (List<Administrador>) adminRepository.findAll();
        model.addAttribute("administradores", administradores);
        return "administrator/index";
    }
}


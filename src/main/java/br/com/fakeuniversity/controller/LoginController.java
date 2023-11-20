package br.com.fakeuniversity.controller;


import br.com.fakeuniversity.model.Administrador;
import br.com.fakeuniversity.model.Aluno;
import br.com.fakeuniversity.model.Fornecedor;
import br.com.fakeuniversity.model.Professor;
import br.com.fakeuniversity.repository.AdminRepository;
import br.com.fakeuniversity.repository.AlunoRepository;
import br.com.fakeuniversity.repository.FornecedorRepository;
import br.com.fakeuniversity.repository.ProfessorRepository;
import br.com.fakeuniversity.service.CookieService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private AdminRepository adminRepository;


    @GetMapping("/login")
    public String index() {
        return "login/index";
    }

    @GetMapping("/sair")
    public String sair (HttpServletResponse response) throws IOException{
        CookieService.setCookie(response, "userId", "", 0);
        return "redirect:login/index";
    }

    //////////////////////////////////////RESQUEST DE LOGIN ADMIN
    // RESQUEST PARA LOGIN ADMIN
    @GetMapping("/login/admin")
    public String logarAdmin() {
        return "login/admin";
    }

    @PostMapping("/login/admin")
    public String logarAdmin(Model model, Administrador admParam, String lembrar, HttpServletResponse response) throws IOException {
        Administrador adm = this.adminRepository.Loguin(admParam.getTxEmailAdmin(), admParam.getTxSenhaAdmin());
        if(adm != null){
            int tempoLogado = (10*60); // 10 minutos de cookie
            if(lembrar != null) tempoLogado = (60*60*24); // 1 dia de cookie
            CookieService.setCookie(response, "usuarioId", String.valueOf(adm.getIdAdmin()), tempoLogado);
            return "redirect:/administrator";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login/admin";
    }

    //////////////////////////////////////FIM RESQUEST DE LOGIN ADMIN


    // RESQUEST PARA LOGIN ALUNO
    @GetMapping("/login/aluno")
    public String logarAluno() {
        return "login/aluno";
    }

    @PostMapping("/login/aluno")
    public String logarAluno(Model model, Aluno alunoParam, String lembrar, HttpServletResponse response) throws IOException {
        Aluno aluno = this.alunoRepository.Loguin(alunoParam.getTxEmailAluno(), alunoParam.getTxSenhaAluno());
        if(aluno != null){
            int tempoLogado = (10*60); // 10 minutos de cookie
            if(lembrar != null) tempoLogado = (60*60*24); // 1 dia de cookie
            CookieService.setCookie(response, "usuarioId", String.valueOf(aluno.getIdAluno()), tempoLogado);
            return "redirect:/pf/aluno";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login/aluno";
    }

    //////////////////////////////////////FIM RESQUEST DE LOGIN ALUNO

    // RESQUEST PARA LOGIN PROFESSOR
    @GetMapping("/login/professor")
    public String logarProfessor() {
        return "login/professor";
    }

    @PostMapping("/login/professor")
    public String logarProfessor(Model model, Professor professorParam, String lembrar, HttpServletResponse response) throws IOException {
        Professor professor = this.professorRepository.Loguin(professorParam.getTxEmailProfessor(), professorParam.getTxSenhaProfessor());
        if(professor != null){
            int tempoLogado = (10*60); // 10 minutos de cookie
            if(lembrar != null) tempoLogado = (60*60*24); // 1 dia de cookie
            CookieService.setCookie(response, "usuarioId", String.valueOf(professor.getIdProfessor()), tempoLogado);
            return "redirect:/pf/professor";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login/professor";
    }

    //////////////////////////////////////FIM RESQUEST DE LOGIN PROFESSOR


    // RESQUEST PARA LOGIN FORNECEDOR
    @GetMapping("/login/fornecedor")
    public String logarfornecedor() {
        return "login/fornecedor";
    }

    @PostMapping("/login/fornecedor")
    public String logarFornecedor(Model model, Fornecedor fornecedorParam, String lembrar, HttpServletResponse response) throws IOException {
        Fornecedor fornecedor = this.fornecedorRepository.Loguin(fornecedorParam.getTxEmailFornecedor(), fornecedorParam.getTxSenhaFornecedor());
        if(fornecedor != null){
            int tempoLogado = (10*60); // 10 minutos de cookie
            if(lembrar != null) tempoLogado = (60*60*24); // 1 dia de cookie
            CookieService.setCookie(response, "usuarioId", String.valueOf(fornecedor.getIdFornecedor()), tempoLogado);
            return "redirect:/pf/fornecedor";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login/fornecedor";
    }

    //////////////////////////////////////FIM RESQUEST DE LOGIN FORNECEDOR


}
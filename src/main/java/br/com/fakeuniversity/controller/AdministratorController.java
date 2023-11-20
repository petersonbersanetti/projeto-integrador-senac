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
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
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

    //BUSCA USUÁRIO PELO ID PARA ALTERAR O CADASTRO

    @GetMapping("/administrator/{id}")
    public String busca(@PathVariable long id, Model model) {
        try {
            Optional<Aluno> alunoOptional = alunoRepository.findById(id);
            Optional<Professor> professorOptional = professorRepository.findById(id);
            Optional<Fornecedor> fornecedorOptional = fornecedorRepository.findById(id);

            if (alunoOptional.isPresent()) {
                String funcaoA = alunoOptional.get().getTxFuncaoAluno();
                model.addAttribute("aluno", alunoOptional.get());
                return "pf/aluno/editaraluno";
            } else if (professorOptional.isPresent()) {
                String funcaoB = professorOptional.get().getTxFuncaoProfessor();
                model.addAttribute("professor", professorOptional.get());
                return "pf/professor/editarprofessor";
            } else if (fornecedorOptional.isPresent()) {
                String funcaoC = fornecedorOptional.get().getTxFuncaoFornecedor();
                model.addAttribute("fornecedor", fornecedorOptional.get());
                return "pj/editarfornecedor";
            }
        } catch (Exception exception) {
            return "redirect:/administrator";
        }

        return "redirect:/administrator";
    }


    @PostMapping("/administrator/{id}/atualizar")
    public String atualizar(@PathVariable Long id, Fornecedor fornecedor, Aluno aluno, Professor professor) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.save(aluno);
        } else if (professorRepository.existsById(id)) {
            professorRepository.save(professor);
        } else if (fornecedorRepository.existsById(id)) {
            fornecedorRepository.save(fornecedor);
        }
        return "redirect:/administrator";
    }


@GetMapping("/administrator/{id}/excluir")
public String excluirFornecedor(@PathVariable Long id){
        fornecedorRepository.deleteById(id);
        alunoRepository.deleteById(id);
        professorRepository.deleteById(id);
        return"redirect:/administrator";
        }

        }


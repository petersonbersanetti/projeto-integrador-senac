package br.com.fakeuniversity.controller;

import br.com.fakeuniversity.model.Aluno;
import br.com.fakeuniversity.model.Fornecedor;
import br.com.fakeuniversity.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class FornecedorController {


    @Autowired
    private FornecedorRepository fornecedorRepository;

    //FORNECEDOR
    @GetMapping("/pj/novofornecedor")
    public String fornecedor() {
        return "pj/novofornecedor";
    }

    @PostMapping("/pj/fornecedor/criar")
    public String novo(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
        return "redirect:/administrator";
    }


    @PostMapping("/fornecedor/{id}/atualizar")
    public String atualizarFornecedor(@PathVariable Long id, Fornecedor fornecedor){
        if(!fornecedorRepository.existsById(id)){
            return "redirect:/administrator";
        }
        fornecedorRepository.save(fornecedor);
        return "redirect:/administrator";
    }

    @GetMapping("/fornecedor/{id}/excluir")
    public String atualizar (@PathVariable Long id){
        fornecedorRepository.deleteById(id);
        return"redirect:/administrator";
    }

    @GetMapping("/fornecedor/{id}")
    public String buscaFornecedor(@PathVariable Long id, Model model){
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        try{
            model.addAttribute("fornecedor", fornecedor.get());
        }
        catch(Exception err){
            return "redirect:/administrator";
        }
        return "/pj/editarfornecedor";
    }


}


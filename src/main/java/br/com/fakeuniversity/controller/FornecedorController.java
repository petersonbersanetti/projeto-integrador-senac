package br.com.fakeuniversity.controller;

import br.com.fakeuniversity.model.Fornecedor;
import br.com.fakeuniversity.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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


}


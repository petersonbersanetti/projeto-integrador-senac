package br.com.fakeuniversity.controller;

import br.com.fakeuniversity.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("/pf/professor/cadastramaterial")
    public String professor() {
        return "/pf/professor/cadastramaterial";
    }

    @PostMapping("/pf/professor/cadastramaterial")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("materialNome") String materialNome) throws IOException {
        // Lógica para salvar o arquivo no banco de dados
        materialService.salvaMaterial(file, materialNome);

        return "redirect:/cadastromateria?success"; // Redirecione para a página de cadastro com uma mensagem de sucesso
    }

    // Outros métodos do controlador
}

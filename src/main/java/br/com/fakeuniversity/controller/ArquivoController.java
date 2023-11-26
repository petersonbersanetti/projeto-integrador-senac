package br.com.fakeuniversity.controller;

import br.com.fakeuniversity.exception.ArquivoNaoEncontradoException;
import br.com.fakeuniversity.model.Aluno;
import br.com.fakeuniversity.model.Arquivo;
import br.com.fakeuniversity.repository.ArquivoRepository;
import br.com.fakeuniversity.service.ArquivoService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Controller
public class ArquivoController {

    @Autowired
    private ArquivoService arquivoService;

    @Autowired
    private ArquivoRepository arquivoRepository;

    @GetMapping("/pf/professor/uploadarquivo")
    public String professor(Model model) {
        List<Arquivo> arquivos = arquivoRepository.findAll();
        model.addAttribute("arquivos", arquivos);
        return "/pf/professor/uploadarquivo";
    }

    @PostMapping("/pf/professor/uploadarquivo")
    public String upload(@RequestParam("arquivoNome") String nome, @RequestParam("dados") MultipartFile arquivo) throws IOException {
        arquivoService.salvarArquivo(nome, arquivo);
        return "redirect:/pf/professor/uploadarquivo";
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable Long id) {
        Arquivo arquivo = arquivoRepository.findById(id)
                .orElseThrow(() -> new ArquivoNaoEncontradoException("Arquivo não encontrado com o ID: " + id));

        if (arquivo.getDados() == null || arquivo.getDados().length == 0) {
            // Lida com a situação em que os dados do arquivo estão vazios
            throw new ArquivoNaoEncontradoException("Arquivo sem dados.");
        }

        // Adicione logs para depuração
        System.out.println("Nome do Arquivo: " + arquivo.getArquivoNome());
        System.out.println("Tipo de Conteúdo: " + arquivo.getTipoArquivo());

        ByteArrayResource resource = new ByteArrayResource(arquivo.getDados());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + arquivo.getArquivoNome())
                .header(HttpHeaders.CONTENT_TYPE, arquivo.getTipoArquivo())
                .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(arquivo.getDados().length))
                .body(resource);
    }


    @GetMapping("/download/{id}/excluir")
    public String excluir(@PathVariable Long id){
        arquivoRepository.deleteById(id);
        return "redirect:/pf/professor/uploadarquivo";
    }

}
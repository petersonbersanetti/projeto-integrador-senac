package br.com.fakeuniversity.service;

import br.com.fakeuniversity.exception.ArquivoNaoEncontradoException;
import br.com.fakeuniversity.model.Arquivo;
import br.com.fakeuniversity.repository.ArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ArquivoService {

    @Autowired
    private ArquivoRepository arquivoRepository;

    public void salvarArquivo(String nome, MultipartFile arquivo) throws IOException {
        Arquivo novoArquivo = new Arquivo();
        novoArquivo.setArquivoNome(nome);
        novoArquivo.setDados(arquivo.getBytes());
        novoArquivo.setTipoArquivo(arquivo.getContentType());
        arquivoRepository.save(novoArquivo);
    }

    public ResponseEntity<Resource> baixarArquivo(Long id) {
        Arquivo arquivo = arquivoRepository.findById(id)
                .orElseThrow(() -> new ArquivoNaoEncontradoException("Arquivo não encontrado com o ID: " + id));

        ByteArrayResource resource = new ByteArrayResource(arquivo.getDados());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + arquivo.getArquivoNome())
                .header(HttpHeaders.CONTENT_TYPE, arquivo.getTipoArquivo())
                .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(arquivo.getDados().length))
                .body(resource);
    }
}

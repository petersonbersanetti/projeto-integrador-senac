package br.com.fakeuniversity.exception;

import br.com.fakeuniversity.model.Arquivo;
import br.com.fakeuniversity.repository.ArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public class ArquivoNaoEncontradoException extends RuntimeException {

    public ArquivoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}


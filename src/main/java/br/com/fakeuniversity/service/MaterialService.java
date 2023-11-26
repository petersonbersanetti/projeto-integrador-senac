package br.com.fakeuniversity.service;

import br.com.fakeuniversity.model.Material;
import br.com.fakeuniversity.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public void salvaMaterial(MultipartFile file, String materialNome) throws IOException {
        // Lógica para salvar o arquivo no banco de dados
        Material material = new Material();
        material.setMaterialNome(materialNome);
        material.setConteudo(file.getBytes()); // Salve os bytes do arquivo no banco de dados

        materialRepository.save(material);
    }
}
package br.com.fakeuniversity.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "materials")
@Data
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material_professor")
    private Long id;

    @Column(name = "tx_material_nome")
    private String materialNome;

    @Lob
    @Column(name = "doc_conteudo")
    private byte[] conteudo; // Armazene o conteúdo do arquivo como bytes
}

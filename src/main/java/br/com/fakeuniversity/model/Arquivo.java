package br.com.fakeuniversity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "arquivos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arquivo_professor")
    private Long id;

    @Column(name = "tx_arquivo_nome")
    private String arquivoNome;

    @Column(name = "tx_tipo_arquivo")
    private String tipoArquivo; // Tipo de arquivo (content type)

    @Lob
    @Column(name = "dados", length = 1000)
    private byte[] dados; // Armazene o conteúdo do arquivo como bytes
}

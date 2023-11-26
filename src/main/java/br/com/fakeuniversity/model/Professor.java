package br.com.fakeuniversity.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "professores")
@Data
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private Long idProfessor;

    @Column(name = "tx_funcao_professor")
    private String txFuncaoProfessor;

    @Column(name = "tx_endereco_professor")
    private String txEnderecoProfessor;

    @Column(name = "tx_telefone_professor")
    private String txTelefoneProfessor;

    @Column(name = "tx_email_professor")
    private String txEmailProfessor;

    @Column(name = "tx_senha_professor")
    private String txSenhaProfessor;

    @Column(name = "tx_nome_professor")
    private String txNomeProfessor;

    @Column(name = "tx_cpf_professor")
    private String txCpfProfessor;

    @Lob
    @Column(name = "doc_arquivo")
    private byte[] docProfessor;

}







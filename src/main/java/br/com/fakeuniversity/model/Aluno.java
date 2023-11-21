package br.com.fakeuniversity.model;

import jakarta.persistence.*;

import lombok.Data;


@Entity
@Data
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro_aluno")
    private Long idAluno;

    @Column(name = "tx_funcao_aluno")
    private String txFuncaoAluno;

    @Column(name = "tx_endereco_aluno")
    private String txEnderecoAluno;

    @Column(name = "tx_telefone_aluno")
    private String txTelefoneAluno;

    @Column(name = "tx_email_aluno")
    private String txEmailAluno;

    @Column(name = "tx_senha_aluno")
    private String txSenhaAluno;

    @Column(name = "tx_nome_aluno")
    private String txNomeAluno;

    @Column(name = "tx_cpf_aluno")
    private String txCpfAluno;

    @Column(name = "tx_nota_aluno")
    private int txNotaAluno;

}






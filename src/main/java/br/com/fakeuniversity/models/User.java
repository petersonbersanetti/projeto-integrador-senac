package br.com.fakeuniversity.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private long id;

    @Column(name = "tx_funcao")
    private String txFuncao;

    @Column(name = "tx_endereco")
    private String txEndereco;

    @Column(name = "tx_telefone")
    private String txTelefone;

    @Column(name = "tx_email")
    private String txEmail;

    @Column(name = "tx_senha")
    private String txSenha;

}

package br.com.fakeuniversity.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private long id;

    @Column(name = "tx_nome_razao_social")
    private String idNome;

    @Column(name = "tx_cpf_cnpj")
    private String txCpfCnpj;

    @Column(name = "tx_endereco")
    private String txEndereco;

    @Column(name = "tx_telefone")
    private String txTelefone;

    @Column(name = "tx_email")
    private String txEmail;

    @Column(name = "tx_senha")
    private String txSenha;

}

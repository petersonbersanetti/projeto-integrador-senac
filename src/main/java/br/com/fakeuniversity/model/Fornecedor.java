package br.com.fakeuniversity.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fornecedores")
@Data

public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor")
    private Long idFornecedor;

    @Column(name = "tx_funcao_fornecedor")
    private String txFuncaoFornecedor;

    @Column(name = "tx_endereco_fornecedor")
    private String txEnderecoFornecedor;

    @Column(name = "tx_telefone_fornecedor")
    private String txTelefoneFornecedor;

    @Column(name = "tx_email_fornecedor")
    private String txEmailFornecedor;

    @Column(name = "tx_senha_fornecedor")
    private String txSenhaFornecedor;

    @Column(name = "tx_razao_fornecedor")
    private String txRazaoSocialFornecedor;

    @Column(name = "tx_cnpj_fornecedor")
    private String txCnpjFornecedor;

}







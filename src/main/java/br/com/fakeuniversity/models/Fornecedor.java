package br.com.fakeuniversity.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Fornecedor extends User{

    @Column(name = "tx_razao_social")
    private String txRazaoSocial;

    @Column(name = "tx_cnpj")
    private String txCnpj;

}






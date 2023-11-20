package br.com.fakeuniversity.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Professor extends User{

    @Column(name = "tx_nome")
    private String txNome;

    @Column(name = "tx_cpf")
    private String txCpf;

}






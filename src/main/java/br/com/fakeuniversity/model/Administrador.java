package br.com.fakeuniversity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admins")
@Data
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro_admin")
    private Long idAdmin;

    @Column(name = "tx_email_admin")
    private String txEmailAdmin;

    @Column(name = "tx_senha_admin")
    private String txSenhaAdmin;

    @Column(name = "tx_funcao_admin")
    private String txFuncaoAdmin;

}






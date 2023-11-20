package br.com.fakeuniversity.repository;

import br.com.fakeuniversity.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {


    @Query(value = "select * from fornecedores where tx_email_fornecedor = :tx_email_fornecedor and tx_senha_fornecedor = :tx_senha_fornecedor", nativeQuery = true)
    public Fornecedor Loguin(String tx_email_fornecedor, String tx_senha_fornecedor);
}

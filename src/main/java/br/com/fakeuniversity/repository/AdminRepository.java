package br.com.fakeuniversity.repository;

import br.com.fakeuniversity.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Administrador, Long> {


    @Query(value = "select * from admins where tx_email_admin = :tx_email_admin and tx_senha_admin = :tx_senha_admin", nativeQuery = true)
    public Administrador Loguin(String tx_email_admin, String tx_senha_admin);
}

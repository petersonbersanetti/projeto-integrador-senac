package br.com.fakeuniversity.repository;

import br.com.fakeuniversity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END from users where id = :id", nativeQuery = true)
    public boolean exist(long id);

    @Query(value="select * from users where tx_email = :tx_email and tx_senha = :tx_senha", nativeQuery = true)
    public User Loguin(String tx_email, String tx_senha);
}

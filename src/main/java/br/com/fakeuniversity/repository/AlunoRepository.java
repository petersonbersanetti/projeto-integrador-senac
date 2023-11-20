package br.com.fakeuniversity.repository;

import br.com.fakeuniversity.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {


    @Query(value = "select * from alunos where tx_email_aluno = :tx_email_aluno and tx_senha_aluno = :tx_senha_aluno", nativeQuery = true)
    public Aluno Loguin(String tx_email_aluno, String tx_senha_aluno);
}

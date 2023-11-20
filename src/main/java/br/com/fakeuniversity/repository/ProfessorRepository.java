package br.com.fakeuniversity.repository;

import br.com.fakeuniversity.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query(value = "select * from professores where tx_email_professor = :tx_email_professor and tx_senha_professor = :tx_senha_professor", nativeQuery = true)
    public Professor Loguin(String tx_email_professor, String tx_senha_professor);
}


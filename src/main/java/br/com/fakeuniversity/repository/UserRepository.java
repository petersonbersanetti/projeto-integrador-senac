package br.com.fakeuniversity.repository;

import br.com.fakeuniversity.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}

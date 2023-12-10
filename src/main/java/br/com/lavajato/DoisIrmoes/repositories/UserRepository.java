package br.com.lavajato.DoisIrmoes.repositories;

import br.com.lavajato.DoisIrmoes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}

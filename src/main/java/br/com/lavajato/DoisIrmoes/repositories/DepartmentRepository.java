package br.com.lavajato.DoisIrmoes.repositories;
import br.com.lavajato.DoisIrmoes.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}

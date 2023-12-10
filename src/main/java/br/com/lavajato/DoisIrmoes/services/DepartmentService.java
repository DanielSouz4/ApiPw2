package br.com.lavajato.DoisIrmoes.services;

import br.com.lavajato.DoisIrmoes.domain.Department;
import br.com.lavajato.DoisIrmoes.domain.User;
import br.com.lavajato.DoisIrmoes.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department getDepartment(Integer departmentId) {
        return departmentRepository.findById(departmentId).orElse(new Department());
    }
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

}

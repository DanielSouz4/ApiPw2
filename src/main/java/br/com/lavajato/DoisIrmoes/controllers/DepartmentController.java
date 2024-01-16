package br.com.lavajato.DoisIrmoes.controllers;

import br.com.lavajato.DoisIrmoes.repositories.UserRepository;
import br.com.lavajato.DoisIrmoes.controllers.request.DepartmentRequest;
import br.com.lavajato.DoisIrmoes.domain.Department;
import br.com.lavajato.DoisIrmoes.domain.User;
import br.com.lavajato.DoisIrmoes.repositories.DepartmentRepository;
import br.com.lavajato.DoisIrmoes.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<Department> saveDepartment(@RequestBody DepartmentRequest request) {
        Department department = new Department();
        department.setName(request.getName());
        department.setCod(request.getCod());
        departmentRepository.save(department);
        return new ResponseEntity<>(departmentRepository.save(department), HttpStatus.CREATED);
    }

    @PutMapping("/{departmentId}/add-user/{userId}")
    public ResponseEntity<Department> addUser(@PathVariable  Integer departmentId,@PathVariable Integer userId ){
        User user = userRepository.findById(userId).get();
        Department department = departmentRepository.findById(departmentId).get();
        department.userSave(user);
        return new ResponseEntity<>(departmentRepository.save(department), HttpStatus.OK);
    }

@GetMapping("/get/{departmentId}")
public ResponseEntity<Department> getDepartment(@PathVariable Integer departmentId) {
    Department department = departmentService.getDepartment(departmentId);
    return new ResponseEntity<>(department, HttpStatus.OK);
}
    @GetMapping("/get-all")
    public ResponseEntity<List<Department>> getAllUsers() {
        List<Department> departments = departmentService.getAll();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
    //@DeleteMapping("/delete/{departmentId}")
//    public void deleteDepartment(Integer departmentId) {
//        Department department = departmentRepository.findById(departmentId).orElse(new Department());
//        departmentRepository.delete(department);
//    }
    @DeleteMapping("/delete/{departmentId}")
    public ResponseEntity deleteDepartment(@PathVariable Integer departmentId) {
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}

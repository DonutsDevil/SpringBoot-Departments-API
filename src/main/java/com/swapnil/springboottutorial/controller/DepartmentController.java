package com.swapnil.springboottutorial.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.swapnil.springboottutorial.entity.Department;
import com.swapnil.springboottutorial.error.DepartmentNotFoundException;
import com.swapnil.springboottutorial.service.Interfaces.DepartmentService;
import jakarta.validation.Valid;

@RestController
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class); // this how we can add logs,  we use slf4j logger.

    @PostMapping(value = "/departments")
    public Department saveDepartment(@RequestBody Department department) {
        logger.info("saveDepartment: Inside Save Department of Deparment Controller");
        return departmentService.saveDepartment(department);
    }

    @PostMapping(value = "/departmentsList")
    public List<Department> saveDepartment(@Valid @RequestBody List<Department> departments) {
        return departmentService.saveDepartment(departments);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Sucessfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @Valid @RequestBody Department department) {

        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }
}

package com.swapnil.springboottutorial.service.Interfaces;

import java.util.List;
import com.swapnil.springboottutorial.entity.Department;
import com.swapnil.springboottutorial.error.DepartmentNotFoundException;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department>  saveDepartment(List<Department> departments);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
    
}

package com.swapnil.springboottutorial.service.InterfaceImplementation;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapnil.springboottutorial.entity.Department;
import com.swapnil.springboottutorial.error.DepartmentNotFoundException;
import com.swapnil.springboottutorial.repository.DepartmentRepository;
import com.swapnil.springboottutorial.service.Interfaces.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> saveDepartment(List<Department> departments) {
        return departmentRepository.saveAll(departments);
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
       Optional<Department> department = departmentRepository.findById(departmentId);
       if (!department.isPresent()) {
        throw new DepartmentNotFoundException("Department Not Available");
       }
       return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    // Saving all the non-null and non-empty value in the DB.
    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department departmentFromDb = departmentRepository.findById(departmentId).get();

        if ( Objects.nonNull(department.getDepartmentName() ) && !"".equalsIgnoreCase(department.getDepartmentName()) ) {
            departmentFromDb.setDepartmentName(department.getDepartmentName());
        }
        
        if ( Objects.nonNull(department.getDepartmentCode() ) && !"".equalsIgnoreCase(department.getDepartmentCode()) ) {
            departmentFromDb.setDepartmentCode(department.getDepartmentCode());
        }
        
        if ( Objects.nonNull(department.getDepartmentAddress() ) && !"".equalsIgnoreCase(department.getDepartmentAddress()) ) {
            departmentFromDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(departmentFromDb);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}

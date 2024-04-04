package System.employeeManagementSystem.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import System.employeeManagementSystem.Repository.EmployeeRepo;
import System.employeeManagementSystem.Entity.Employee;
import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
    
}

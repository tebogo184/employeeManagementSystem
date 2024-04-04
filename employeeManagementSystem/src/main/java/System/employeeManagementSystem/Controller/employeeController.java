package System.employeeManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import System.employeeManagementSystem.Entity.Employee;
import System.employeeManagementSystem.Service.EmployeeService;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class employeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/AllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    
    
}

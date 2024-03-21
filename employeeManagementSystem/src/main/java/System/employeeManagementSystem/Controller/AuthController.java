package System.employeeManagementSystem.Controller;

import System.employeeManagementSystem.Entity.Employee;
import System.employeeManagementSystem.Repository.EmployeeRepo;
import System.employeeManagementSystem.Service.AuthenticationResponse;
import System.employeeManagementSystem.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody Employee employee){
 System.out.println("I got here");
        return ResponseEntity.ok(authenticationService.register(employee));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody Employee employee){
        return ResponseEntity.ok(authenticationService.authentication(employee));
    }


}

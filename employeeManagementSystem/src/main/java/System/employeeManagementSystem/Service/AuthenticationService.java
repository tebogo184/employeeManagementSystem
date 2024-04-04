package System.employeeManagementSystem.Service;

import System.employeeManagementSystem.Entity.Employee;
import System.employeeManagementSystem.Entity.Manager;
import System.employeeManagementSystem.Entity.Role;
import System.employeeManagementSystem.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ManagerService managerService;

    //add new Employee
    public AuthenticationResponse register(Employee user){
        Employee employee=new Employee();
       
        employee.setUsername(user.getUsername());
        employee.setFullName(user.getFullName());
        
        employee.setAddress(user.getAddress());
        
        employee.setRole(Role.EMPLOYEE);
       
        employee.setEmailAddress(user.getEmailAddress());

        employee.setDateOfBirth(user.getDateOfBirth());
        employee.setPassword(passwordEncoder.encode(user.getPassword()));
       
        employee.setPhoneNumber(user.getPhoneNumber());
        employee.setDepartment(user.getDepartment());
       
        Manager manager=managerService.createManager(employee);
        
        employee.setManager(manager);
        
        manager.addEmployee(employee);
       


        employeeRepo.save(employee);
        
   String token= jwtService.generateToken(employee);
   return new AuthenticationResponse(token);

    }

    public AuthenticationResponse authentication(Employee user){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        Employee employee=employeeRepo.findByUsername(user.getUsername()).orElseThrow(()->new UsernameNotFoundException("Username can not be found"));
        String token= jwtService.generateToken(employee);
        return new AuthenticationResponse(token);
    }


}

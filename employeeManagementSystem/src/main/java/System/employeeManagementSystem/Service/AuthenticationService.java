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
        System.out.println("I got to the employee object ");
        employee.setUsername(user.getUsername());
        employee.setFullName(user.getFullName());
        System.out.println("I got to the fullname");
        employee.setAddress(user.getAddress());
        System.out.println("I got the address");
        employee.setRole(Role.EMPLOYEE);
        System.out.println("I got to the role  ");
        employee.setEmailAddress(user.getEmailAddress());

        employee.setDateOfBirth(user.getDateOfBirth());
        employee.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("I got the password ");
        employee.setPhoneNumber(user.getPhoneNumber());
        employee.setDepartment(user.getDepartment());
        System.out.println("I got to the department ");
        Manager manager=managerService.createManager(employee);
        System.out.println("I got to the manager ");
        employee.setManager(manager);
        System.out.println("I got to adding the manager ");
        manager.addEmployee(employee);
        System.out.println("I am adding the employee");


        employeeRepo.save(employee);
        System.out.println("I am saving the employee");
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

package System.employeeManagementSystem.Service;

import System.employeeManagementSystem.Entity.Employee;
import System.employeeManagementSystem.Entity.Manager;
import System.employeeManagementSystem.Entity.Role;
import System.employeeManagementSystem.Repository.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepo managerRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Manager createManager(Employee employee){
        List<Employee> list=new ArrayList<>();
        list.add(employee);
        Manager manager=new Manager(1L,"John Doe", "john.doe@example.com", "+1234567890",passwordEncoder.encode("johniw4335") , "johndoe123", Role.MANAGER,list);

        return managerRepo.save(manager);
    }

    public Manager findById(Long id){
        return managerRepo.findById(id).orElseThrow(()->new UsernameNotFoundException("Can not find the id "));
    }


}

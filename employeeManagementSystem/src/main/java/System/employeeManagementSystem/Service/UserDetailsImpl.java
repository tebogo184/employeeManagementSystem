package System.employeeManagementSystem.Service;

import System.employeeManagementSystem.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
   private  EmployeeRepo employeeRepo;

    @Override
    public UserDetails loadUserByUsername(String username){
        return employeeRepo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User can not be found"));
}}

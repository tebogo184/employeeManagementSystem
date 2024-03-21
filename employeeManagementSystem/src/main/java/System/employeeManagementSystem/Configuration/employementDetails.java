package System.employeeManagementSystem.Configuration;

import System.employeeManagementSystem.Entity.EmploymentInformation;
import System.employeeManagementSystem.Entity.Manager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class employementDetails {

    @Bean
    public EmploymentInformation employmentInformation(){
        return new EmploymentInformation(1L,"general Worker","Finance");

    }

   /* public Manager manager(){
        return new Manager(2L,"Tebogo","Tshukudu@gmail.com","012345689","Tebogo1","Tebza","MANAGER","Tebxaog","efeff");
    }*/

}

package System.employeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @GeneratedValue
    private Long employeeId;

    private String fullName;
    private String username;
    private String phoneNumber;
    private String dateOfBirth;
    private String emailAddress;
    private String Address;
    private String password;
    @Enumerated
    private Role role;

    //manager entity
    @OneToOne
    @JoinColumn(name="manager")
    private Manager manager;
    //employment entity
   @OneToOne
   @JoinColumn(name="employmentInformation")
   private EmploymentInformation employmentInformation;


}

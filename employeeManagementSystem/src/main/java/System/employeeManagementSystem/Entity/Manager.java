package System.employeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="manager")
public class Manager {

    @Id
    @GeneratedValue

    private Long managerId;
    private String fullName;
    private String emailAddress;
    private String phoneNumber;
    private String password;
    private String username;

    @Enumerated
    private Role role;

    //employee entity
    @OneToMany
    @JoinColumn(name="employee")
    private Employee employee;

    //employment entity
    @OneToOne
    @JoinColumn(name="employmentInformation")
    private EmploymentInformation employmentInformation;



}

package System.employeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employee")
public class Employee implements UserDetails {

    @Id
    @GeneratedValue
    private Long employeeId;

    private String fullName;
    private String username;
    private String phoneNumber;
    private String dateOfBirth;
    private String emailAddress;
    private String address;
    private String password;
    private String department;
    @Enumerated
    private Role role;

    //manager entity
    @ManyToOne
    @JoinColumn(name="manager")
    private Manager manager;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

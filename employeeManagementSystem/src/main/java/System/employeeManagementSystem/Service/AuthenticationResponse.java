package System.employeeManagementSystem.Service;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class AuthenticationResponse {

    private String token;
    public AuthenticationResponse (String token){
        this.token=token;
    }

}

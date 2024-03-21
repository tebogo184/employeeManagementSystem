package System.employeeManagementSystem.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


@Getter

public class AuthenticationResponse {


    private final String token;


    public AuthenticationResponse (String token){
        this.token=token;
    }

}

package System.employeeManagementSystem.Repository;

import System.employeeManagementSystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface EmployeeRepo extends JpaRepository<Long, Employee> {
    Optional<Employee> findByUsername(String username);
}

package System.employeeManagementSystem.Repository;

import System.employeeManagementSystem.Entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepo extends JpaRepository<Manager,Long> {
}

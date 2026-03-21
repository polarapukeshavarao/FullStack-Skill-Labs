package RestfulJPA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import RestfulJPA.Model.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee,Integer> {

}

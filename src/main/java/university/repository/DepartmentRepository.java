package university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import university.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query(value = "from departments d join fetch d.head join fetch d.lectors where d.name = ?1")
    Department getDepartmentByName(String departmentName);
}

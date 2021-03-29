package university.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import university.model.Lector;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query("from lectors l where l.firstName like %?1% or l.lastName like %?1%")
    List<Lector> findByTemplate(String template);
}

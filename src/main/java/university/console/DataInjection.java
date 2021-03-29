package university.console;

import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import university.model.Department;
import university.model.Lector;
import university.service.DepartmentService;
import university.service.LectorService;

@Component
@RequiredArgsConstructor
public class DataInjection {
    private final DepartmentService departmentService;
    private final LectorService lectorService;

    @PostConstruct
    public void injection() {
        Lector oliver = new Lector().setFirstName("Oliver")
                .setDegree(Lector.Degree.ASSISTANTS).setSalary(BigDecimal.valueOf(1000));
        Lector jacob = new Lector().setFirstName("Jacob")
                .setDegree(Lector.Degree.ASSISTANTS).setSalary(BigDecimal.valueOf(1000));
        Lector charlie = new Lector().setFirstName("Charlie")
                .setDegree(Lector.Degree.ASSOCIATE_PROFESSOR).setSalary(BigDecimal.valueOf(2000));
        Lector poppy = new Lector().setFirstName("Poppy")
                .setDegree(Lector.Degree.PROFESSOR).setSalary(BigDecimal.valueOf(2500));
        List.of(oliver, jacob, charlie, poppy).forEach(lector -> {
            lector.setLastName("last name");
            lectorService.save(lector);
        });

        Department math = new Department().setName("Math")
                .setHead(poppy).setLectors(List.of(poppy, charlie, jacob));
        Department programming = new Department()
                .setName("Programming").setHead(charlie).setLectors(List.of(oliver));
        departmentService.save(math);
        departmentService.save(programming);
    }
}

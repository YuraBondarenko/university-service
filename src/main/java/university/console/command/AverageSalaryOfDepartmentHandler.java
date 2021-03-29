package university.console.command;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import university.model.Lector;
import university.service.DepartmentService;

@Component
@RequiredArgsConstructor
public class AverageSalaryOfDepartmentHandler implements CommandHandler {
    private final DepartmentService departmentService;

    @Override
    public void handle(String command) {
        try {
            List<BigDecimal> salaries = departmentService.getDepartment(command).getLectors()
                    .stream()
                    .map(Lector::getSalary)
                    .collect(Collectors.toList());
            BigDecimal reduce = salaries.stream()
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            System.out.println("The average salary of " + command + " is " + reduce
                    .divide(BigDecimal.valueOf((salaries.size())), 2, RoundingMode.HALF_UP));
        } catch (Exception e) {
            System.out.println("There is no department named " + command + ". Please, try again.");
        }

    }
}

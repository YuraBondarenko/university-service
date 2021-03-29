package university.console.command;

import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import university.model.Lector;
import university.service.DepartmentService;

@RequiredArgsConstructor
@Component
public class DepartmentStatisticsHandler implements CommandHandler {
    private final DepartmentService departmentService;

    @Override
    public void handle(String command) {
        try {
            departmentService.getDepartment(command).getLectors().stream()
                    .map(Lector::getDegree)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .forEach((key, value) -> System.out.println(key.name() + " - " + value));
        } catch (Exception e) {
            System.out.println("There is no department named " + command + ". Please, try again.");
        }
    }
}

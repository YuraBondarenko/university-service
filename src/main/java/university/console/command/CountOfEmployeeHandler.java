package university.console.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import university.service.DepartmentService;

@RequiredArgsConstructor
@Component
public class CountOfEmployeeHandler implements CommandHandler {
    private final DepartmentService departmentService;

    @Override
    public void handle(String command) {
        try {
            System.out.println(departmentService.getDepartment(command).getLectors().size());
        } catch (Exception e) {
            System.out.println("There is no department named " + command + ". Please, try again.");
        }
    }
}

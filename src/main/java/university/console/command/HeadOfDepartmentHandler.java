package university.console.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import university.model.Lector;
import university.service.DepartmentService;

@Component
@RequiredArgsConstructor
public class HeadOfDepartmentHandler implements CommandHandler {
    private final DepartmentService departmentService;

    @Override
    public void handle(String command) {
        try {
            Lector head = departmentService.getDepartment(command).getHead();
            System.out.println("Head of department " + command + " department is "
                    + head.getFirstName() + " " + head.getLastName());
        } catch (Exception e) {
            System.out.println("There is no department named " + command + ". Please, try again.");
        }
    }
}

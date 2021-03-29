package university.console.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import university.service.LectorService;

@Component
@RequiredArgsConstructor
public class GlobalSearchHandler implements CommandHandler {
    private static final String DELIMITER = ", ";
    private final LectorService lectorService;

    @Override
    public void handle(String command) {
        try {
            lectorService.getByTemplate(command)
                    .forEach(s -> System.out.print(s.getFirstName()
                            + " " + s.getLastName() + DELIMITER));
            System.out.println();
        } catch (Exception e) {
            System.out.println("There is no lector named " + command + ". Please, try again.");
        }
    }
}

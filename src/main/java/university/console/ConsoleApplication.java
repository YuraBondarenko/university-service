package university.console;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import university.console.command.CommandHandler;
import university.console.command.IncorrectCommandHandler;

@Component
@RequiredArgsConstructor
public class ConsoleApplication {
    private final List<CommandHandler> commandsHandler;
    private final Map<String, CommandHandler> commands = new HashMap<>();

    @PostConstruct
    private void filling() {
        for (CommandHandler commandHandler : commandsHandler) {
            String className = commandHandler.getClass().getSimpleName().replaceAll("Handler", "");
            commands.put(className.equals("HeadOfDepartment") ? "Who is head of department (\\w+)"
                            : className.equals("AverageSalaryOfDepartment")
                            ? "Show the average salary for the department (\\w+)"
                            : className.equals("CountOfEmployee")
                            ? "Show count of employee for (\\w+)"
                            : className.equals("Exit") ? "(Exit)"
                            : className.equals("DepartmentStatistics") ? "Show (\\w+) statistics"
                            : className.equals("GlobalSearch") ? "Global search by (\\w+)"
                            : className.equals("Menu") ? "(Menu)"
                            : ("(\\w+)"),
                    commandHandler);
        }
    }

    public void start() {
        System.out.println("Welcome to the University Service");
        handleCommand();
    }

    private void handleCommand() {
        while (true) {
            System.out.println("To open the menu enter 'Menu'");
            System.out.println("Please, enter a command: ");
            String command = new Scanner(System.in).nextLine();
            try {
                String key = commands.keySet().stream()
                        .filter(command::matches)
                        .findFirst().get();
                commands.get(key).handle(command.replaceAll(key, "$1"));
            } catch (Exception e) {
                new IncorrectCommandHandler().handle(command);
            }
        }
    }
}

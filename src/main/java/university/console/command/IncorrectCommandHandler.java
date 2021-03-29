package university.console.command;

import org.springframework.stereotype.Component;

@Component
public class IncorrectCommandHandler implements CommandHandler {
    @Override
    public void handle(String command) {
        System.out.println("There is no such command like '" + command + "'. Please, try again.");
    }
}

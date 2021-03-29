package university.console.command;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExitHandler implements CommandHandler {
    private final ApplicationContext applicationContext;

    @Override
    public void handle(String command) {
        System.out.println("Thanks for using university service!");
        System.out.println("Have a good day!");

        SpringApplication.exit(applicationContext);
        System.exit(0);
    }
}

package university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import university.console.ConsoleApplication;

@SpringBootApplication
public class UniversityServiceApplication {
    private static ConsoleApplication consoleApplication;

    public UniversityServiceApplication(ConsoleApplication consoleApplication) {
        UniversityServiceApplication.consoleApplication = consoleApplication;
    }

    public static void main(String[] args) {
        SpringApplication.run(UniversityServiceApplication.class, args);
        consoleApplication.start();
    }
}

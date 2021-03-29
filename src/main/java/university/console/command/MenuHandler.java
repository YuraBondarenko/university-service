package university.console.command;

import org.springframework.stereotype.Component;

@Component
public class MenuHandler implements CommandHandler {
    @Override
    public void handle(String command) {
        System.out.println("'Command' - functionality");
        System.out.println("'Who is head of department {department_name}' "
                + "- get head of department");
        System.out.println("'Show {department_name} statistics' - to exit from the app");
        System.out.println("'Show the average salary for the department {department_name}' "
                + "- get average salary of department");
        System.out.println("'Show count of employee for {department_name}' "
                + "-  get number employees that work in the department");
        System.out.println("'Global search by {template}' - get lectors by a template");
        System.out.println("'Exit' - exit the program");
    }
}

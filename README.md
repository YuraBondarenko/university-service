# University service

## Functionality:
  * 'Menu' - get functionality;
  * 'Who is head of department {department_name}' - get head of department;
  * 'Show {department_name} statistics' - to exit from the app;
  * 'Show the average salary for the department {department_name}' - get average salary of department;
  * 'Show count of employee for {department_name}' -  get number employees that work in the department;
  * 'Global search by {template}' - get lectors by a template;
  * 'Exit' - exit the program.

## To run the project locally:
1. Create a schema in the PosgreSQL "university";
2. Update file "src/main/resources/application.properties":
* spring.datasource.username=root // type your role in the PosgreSQL
* spring.datasource.password=1234 // type your password.

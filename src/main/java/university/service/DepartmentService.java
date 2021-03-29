package university.service;

import university.model.Department;

public interface DepartmentService {
    Department save(Department department);

    Department getDepartment(String departmentName);
}

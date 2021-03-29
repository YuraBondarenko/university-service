package university.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import university.model.Department;
import university.repository.DepartmentRepository;
import university.service.DepartmentService;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartment(String departmentName) {
        return departmentRepository.getDepartmentByName(departmentName);
    }
}

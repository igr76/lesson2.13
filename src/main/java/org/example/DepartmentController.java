package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {

        this.departmentService = departmentService;
    }
    @GetMapping(path = "/max-salary")
    public Employee MaxSalaryFromDepartment(@RequestParam("departmentId") int department){
        return departmentService.departmentMax(department);
    }
    @GetMapping(path = "/min-salary")
    public Employee MinSalaryFromDepartment(@RequestParam("departmentId") int department){
        return departmentService.departmentMin(department);
    }
    @GetMapping(path = "/all", params = "departmentId")
    public Collection<Employee> AllSalaryFromDepartment(@RequestParam("departmentId") int department){
        return departmentService.departmentSumm(department);

    }
    @GetMapping(path = "/all", params = "departmentId")
    public Map<Integer, List<Employee>> AllFromDepartment(@RequestParam("departmentId") int department){
        return departmentService.allEmployeeOfDepartment();

    }



}


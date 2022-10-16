package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String Name,
                        @RequestParam int department, @RequestParam double salary) throws EmployeeAlreadyAddedException {
        if (employeeService.checkName(Name)){ throw new EmployeeNotFoundException("400 Bad Request.");

        }else  return employeeService.add(Name,department,salary);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String Name) throws EmployeeNotFoundException {
        if (employeeService.checkName(Name)) { throw new EmployeeNotFoundException("400 Bad Request.");
        }else return employeeService.find(Name);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam String Name,
                           @RequestParam  int department, @RequestParam double salary) throws EmployeeNotFoundException {
        if (employeeService.checkName(Name)) { throw new EmployeeNotFoundException("400 Bad Request.");
        }else return employeeService.remove(Name,department,salary);
    }

}


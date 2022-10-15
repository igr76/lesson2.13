package org.example;


//import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final EmployeeService employeeService;
    private final String swith = "QWERTYUIOPLKJHGFDSAZXCVBNMЙЦУКЕНГШЩЗХЭЖДЛОРПАВЫФЯЧСМИТЬБЮ";
    public static final Map<String, Employee> employees = new HashMap<>();

    public EmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeService() {

    }


    public Employee add(String Name, int department, double salary) {
        Employee employee = new Employee(Name, department,salary);
        if (employees.containsKey(Name)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.put(Name,employee);
            return  employee;
        }
        throw  new EmployeeStorageIsFullException();


    }
    public Employee remove(String Name, int department, double salary)  {
        Employee employee = new Employee(Name, department,salary);
        if (employees.containsKey(Name)) {
            return    employees.put(Name,employee);
        }
        throw new EmployeeAlreadyAddedException();
    }
    public Employee find(String Name) {
        if (employees.containsKey(Name)) {
            return employees.get(Name);
        } throw new EmployeeNotFoundException();


    }
    public List<Employee> getAll(){return  new ArrayList<>((employees.values()));    }

    public boolean checkName(String Name) {
        if  (!StringUtils.startsWith(swith, Name)) {
            System.out.println("Введите ФИО с заглавной буквы");
            return true;
        }else return false;

    }


}

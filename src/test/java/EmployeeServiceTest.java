import org.example.Employee;
import org.example.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import static org.apache.catalina.filters.ExpiresFilter.isNotEmpty;
import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeService();
@AfterEach
    public void afterEach() {
        employeeService.getAll().forEach(employee -> employeeService.remove(
                employee.getName(),employee.getDepartment(),employee.getSalary()));
    }

    @Test
    public void addTest() {
        Employee expected = new Employee("Name Surname",2,34543);
        assertThat(employeeService.getAll().isEmpty());
        employeeService.add(expected.getName(),expected.getDepartment(),expected.getSalary());
        assertThat(employeeService.getAll()))
                .isNotEmpty()
                .hasSize(1)
                .containsExactly(expected);

        assertThat(employeeService.find(expected.getName())).isEqualTo(expected);

    }

    private Employee addCheck(String name) {
    Employee expected = new Employee(name,1,35543);
    int sizeBefore = employeeService.getAll().size();
    employeeService.add(expected.getName(),expected.getDepartment(),expected.getSalary());
    assertThat(employeeService.getAll())
            .isNotEmpty()
            .hasSize(sizeBefore + 1)
            .contains(expected);
        assertThat(employeeService.find(expected.getName())).isEqualTo(expected);
        return expected;
    }

    @Test
    public void findTest() {
    Employee employee1 = addCheck("Name");
        Employee employee2 = addCheck("Kolya");
        assertThat(employeeService.find(employee1.getName())).isEqualTo(employee1);
        assertThat(employeeService.find(employee1.getName())).isEqualTo(employee1);
    }

    @Test
    public void removeTest() {
        Employee employee1 = addCheck("Nam1e");
        Employee employee2 = addCheck("Kolya1");
        employeeService.remove(employee1.getName(),employee1.getDepartment(),employee1.getSalary());
        assertThat(employeeService.getAll())
                .isNotEmpty()
                .hasSize(1)
                .containsExactly(employee2);
        employeeService.remove(employee2.getName(),employee2.getDepartment(),employee2.getSalary());
        assertThat(employeeService.getAll().isEmpty());


    }
}

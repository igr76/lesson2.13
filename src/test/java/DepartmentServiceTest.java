import org.example.DepartmentService;
import org.example.Employee;
import org.example.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;

public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;
     @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    public void beforeEach() {
        Arrays.asList(
                new Employee("Ivan",2,45364),
                new Employee("Ivan2",2,45364),
                new Employee("Ivan3",4,48764),
                new Employee("Ivan4",4,12364),
                new Employee("Ivan5",4,412364)
        );
    }
}

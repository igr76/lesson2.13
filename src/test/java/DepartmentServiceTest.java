import org.example.DepartmentService;
import org.example.Employee;
import org.example.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;
     @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    public void beforeEach() {
        Arrays.asList(
                new Employee("Ivan",2,45364),
                new Employee("Ivan2",2,15364),
                new Employee("Ivan3",4,48764),
                new Employee("Ivan4",4,12364),
                new Employee("Ivan5",4,22364)
        );
    }

    @ParameterizedTest
    @MethodSource("maxSalaryTest")
    public void maxSalaryTest(int department, Employee extected) {
        assertThat(departmentService.departmentMax(department)).isEqualTo(extected);
    }
    public  static Stream<Arguments> maxSalaryTestParams() {
        return Stream.of(
        Arguments.of(2, new Employee("Ivan",2,45364)),
        Arguments.of(4,  new Employee("Ivan3",4,48764)));
    }
    public void minSalaryTest(int department, Employee extected) {
        assertThat(departmentService.departmentMin(department)).isEqualTo(extected);
    }
    public  static Stream<Arguments> minSalaryTestParams() {
        return Stream.of(
                Arguments.of(2,  new Employee("Ivan2",2,15364)),
                Arguments.of(4,  new Employee("Ivan4",4,12364)));
    }

    @Test
    public void departmentSummTest(Collection<Employee> extected) {
        assertThat(departmentService.allEmployeeOfDepartment()).containsExactlyInAnyOrderEntriesOf(
                Map.of(2, List.of(
                        new Employee("Ivan",2,45364),
                        new Employee("Ivan2",2,15364),
                ),
                        4,List.of(
                                new Employee("Ivan3",4,48764),
                                new Employee("Ivan4",4,12364),
                                new Employee("Ivan5",4,22364)))
        );

    }
}

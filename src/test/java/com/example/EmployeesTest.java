package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeesTest {

    EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
    BankService bankServiceMock = Mockito.mock(BankService.class);

    Employees employees = new Employees(employeeRepository, bankServiceMock);

    private Employee employee1 = new Employee("1", 17000.0);
    private Employee employee2 = new Employee("2", 17000.0);

    @BeforeEach
    void initialize() {
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
    }

    @Test
    void payEmployeesShouldSetPaidToTrue() {
        assertThat(employees.payEmployees());
    }

    @Test
    void catchRuntimeExceptionWhenPayingEmployees() {
        Mockito.doThrow(RuntimeException.class).when(bankServiceMock).pay(employee1.getId(), employee1.getSalary());

        employees.payEmployees();

        assertFalse(employee1.isPaid());
    }
    @Test
    void whenCallingPayEmployeesShouldReturnPaidEmployee() {

        employees.payEmployees();

        assertTrue(employee1.isPaid());

    }
    @Test
    void whenNotPayingEmployeesShouldReturnUnpaidEmployee() {

        assertFalse(employee1.isPaid());

    }


}
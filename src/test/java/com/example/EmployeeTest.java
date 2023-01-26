package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee employee = new Employee("1",17000.0);

    @Test
    void callingGetIdShouldReturnId() {

        var result = employee.getId();

        assertEquals("1",result);
    }

    @Test
    void callingSetIdShouldSetId() {
        employee.setId("2");

        assertEquals("2",employee.getId());

    }

    @Test
    void callingGetSalaryShouldGetEmployeeSalary() {

        assertEquals(17000.0,employee.getSalary());
    }

    @Test
    void callingSetSalaryShouldSetSalary() {
        employee.setSalary(21000.0);

        assertEquals(21000.0,employee.getSalary());
    }

    @Test
    void callingIsPaidBeforeSetPaidShouldReturnFalse() {
        assertFalse(employee.isPaid());

    }
    @Test
    void callingIsPaidAfterSetPaidShouldReturnTrue() {
        employee.setPaid(true);

        assertTrue(employee.isPaid());

    }
    @Test
    void callingSetPaidShouldSetPaidToTrue() {
        employee.setPaid(true);

        assertTrue(employee.isPaid());
    }

    @Test
    void testToString() {
        String expected = "Employee [id=" + employee.getId() + ", salary=" + employee.getSalary() + "]";

        assertEquals(expected,employee.toString());

    }
}
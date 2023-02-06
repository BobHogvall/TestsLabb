package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

class EmployeesTest {

    BankService bankService = Mockito.mock(BankService.class);
    EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();

    Employees employeeList = new Employees(employeeRepository, bankService);
    Employee employeeOne = new Employee("1A", 10000.0);
    Employee employeeTwo = new Employee("2B", 20000.0);

    @BeforeEach
    void initializeTestsBySavingEmployees(){
        employeeRepository.save(employeeOne);
        employeeRepository.save(employeeTwo);
    }
    @Test
    void testThatTheAmountOfEmployeesIsCorrect() {
        assertThat(employeeList.payEmployees()).isEqualTo(2);
    }

    @Test
    void testThatEmployeeOneGetsPaid(){
        employeeList.payEmployees();
        assertTrue(employeeRepository.findAll().get(0).isPaid());
    }

    @Test
    void testThatEmployeeTwoGetsPaid(){
        employeeList.payEmployees();
        assertTrue(employeeRepository.findAll().get(1).isPaid());
    }


// två tester - en som testar att det lyckas, en som testar att det misslyckas.

    //misslyckas:
    @Test
    void makeMockThrowExceptionThenAssertItIsCorrectValue(){
        doThrow(RuntimeException.class).when(bankService).pay(employeeOne.getId(),employeeOne.getSalary());
        assertThat(employeeOne.isPaid()).isFalse();
    }

    @Test
    void testThatOnlyOneGetsPaid(){
        doThrow(RuntimeException.class).when(bankService).pay(employeeOne.getId(),employeeOne.getSalary());
        assertThat(employeeList.payEmployees()).isEqualTo(1);
    }

}



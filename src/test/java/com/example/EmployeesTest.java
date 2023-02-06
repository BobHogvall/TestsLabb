package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

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

// två tester - en som testar att det lyckas, en som testar att det misslyckas.
    @Test
    void testsThatExceptionIsThrown(){
        doThrow(RuntimeException.class).when(bankService).pay(employeeOne.getId(),employeeOne.getSalary());
        assertThat(employeeList.payEmployees()).isEqualTo(1);
    }

    //lyckas:
    @Test
    void testThatEveryoneGetsPaid(){
        assertThat(employeeList.payEmployees()).isEqualTo(2);
    }

    @Test
    void spyToSeeThatPayIsCalled(){
        bankService.pay(employeeOne.getId(), employeeOne.getSalary());
        verify(bankService).pay(employeeOne.getId(), employeeOne.getSalary());
    }

}



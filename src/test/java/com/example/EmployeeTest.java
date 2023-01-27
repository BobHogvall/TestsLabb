package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeTest {

    Employee testEmployee = new Employee("1A", 10000.0);                      //given

    @Test
    void testIfGetIdReturnsCorrectId() {
        assertThat(testEmployee.getId()).isEqualTo("1A");                    //when     then
    }

    @Test
    void testIfSetIdWorksByChangingCurrentIdToNewId() {
        var newId = "1B";                                                             //when
        testEmployee.setId("1B");

        assertThat(testEmployee.getId()).isEqualTo(newId);                            //then
    }

    @Test
    void testIfGetSalaryReturnsCorrectSalary() {
        assertThat(testEmployee.getSalary()).isEqualTo(10000.0);
    }

    @Test
    void testIfSetSalaryWorksByChangingCurrentSalaryToNewSalary() {
        testEmployee.setSalary(20000.0);
        assertThat(testEmployee.getSalary()).isEqualTo(20000.0);
    }

    @Test
    void testIfIsPaidReturnsFalse() {
        assertThat(testEmployee.isPaid()).isFalse();
    }

    @Test
    void testIfSetPaidWorksByChangingToTrue() {
        testEmployee.setPaid(true);
        assertThat(testEmployee.isPaid()).isTrue();
    }

    @Test
    void testIfToStringReturnsCorrectString() {
        assertThat(testEmployee.toString()).hasToString("Employee [id=" + "1A" + ", salary=" + 10000.0 + "]");                  //then
    }
}
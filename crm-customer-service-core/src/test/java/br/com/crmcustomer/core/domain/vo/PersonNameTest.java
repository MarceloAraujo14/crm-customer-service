package br.com.crmcustomer.core.domain.vo;

import br.com.crmcustomer.core.domain.exception.InvalidCustomerNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonNameTest {

    @Test
    void nameIsValid(){
        //given
        String name = "Jhonny Doe";
        //when
        //then
        Assertions.assertDoesNotThrow(() -> new PersonName(name));
    }
    @Test
    void shouldThrowWhenNameIsBlank(){
        //given
        String name = "";
        //when
        //then
        Assertions.assertThrows(InvalidCustomerNameException.class,
                () -> new PersonName(name), "The field name should be fill.");
    }
    @Test
    void shouldThrowWhenNameIsTooShort(){
        //given
        String name = "Jhon";
        //when
        //then
        Assertions.assertThrows(InvalidCustomerNameException.class,
                () -> new PersonName(name), "The field name should have length between 5 and 50.");
    }
    @Test
    void shouldThrowWhenFirtsOrLastNameIsNotProvided(){
        //given
        String name = "JhonDoe";
        //when
        //then
        Assertions.assertThrows(InvalidCustomerNameException.class,
                () -> new PersonName(name), "Name should have at least first and last name.");
    }
}
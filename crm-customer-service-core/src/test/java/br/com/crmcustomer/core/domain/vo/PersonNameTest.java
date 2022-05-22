package br.com.crmcustomer.core.domain.vo;

import br.com.crmcustomer.core.domain.exception.InvalidCustomerNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        String name = " ";
        String expectMessage = "The field name should be fill.";
        //when
        //then
        assertThatThrownBy(() -> new PersonName(name)).isInstanceOf(InvalidCustomerNameException.class)
                .hasMessageContaining(expectMessage);
    }
    @Test
    void shouldThrowWhenNameIsTooShort(){
        //given
        String name = "Jhon";
        String expectMessage = "The field name should have length between 5 and 50.";
        //when
        //then
        assertThatThrownBy(() -> new PersonName(name)).isInstanceOf(InvalidCustomerNameException.class)
                        .hasMessageContaining(expectMessage);
    }
    @Test
    void shouldThrowWhenFirtsOrLastNameIsNotProvided(){
        //given
        String name = "JhonDoe";
        String expectedMessage = "Name should have at least first and last name.";
        //when
        //then
        assertThatThrownBy(() -> new PersonName(name)).isInstanceOf(InvalidCustomerNameException.class)
                .hasMessageContaining(expectedMessage);
    }
}
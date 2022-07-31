package com.maraujo.crm.core.domain.vo;

import com.maraujo.crm.core.domain.enums.ContactType;
import com.maraujo.crm.core.domain.exception.InvalidEmailException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ContactTest {

    @Test
    void contactPhoneIsValid(){
       //given
        ContactType PHONE = ContactType.PHONE;
        String contactContent = "(21) 99999-99999";
       //when
       //then
        assertDoesNotThrow(() -> new Contact(contactContent));
    }
    @Test
    void contactEmailIsValid(){
        //given
        ContactType EMAIL = ContactType.EMAIL;
        String contactContent = "jhon.doe@gmail.com";
        //when
        //then
        assertDoesNotThrow(() -> new Contact(contactContent));
    }
    @Test
    void shouldThrowWhenEmailHasNotASymbol(){
        //given
        ContactType EMAIL = ContactType.EMAIL;
        String contactContent = "jhon.doegmail.com";
        String expectedMessage = "Invalid email format";
        //when
        //then
        assertThatThrownBy( () -> new Contact(contactContent)).isInstanceOf(InvalidEmailException.class)
                .hasMessageContaining(expectedMessage);
    }
    @Test
    void shouldThrowWhenEmailIsTooShort(){
        //given
        ContactType EMAIL = ContactType.EMAIL;
        String contactContent = "n@m.co";
        String expectedMessage = "Invalid email format";
        //when
        //then
        assertThatThrownBy(() -> new Contact(contactContent)).isInstanceOf(InvalidEmailException.class)
                .hasMessageContaining(expectedMessage);
    }

}
package br.com.crmcustomer.core.domain.vo;

import br.com.crmcustomer.core.domain.enums.ContactType;
import br.com.crmcustomer.core.domain.exception.InvalidEmailException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void contactPhoneIsValid(){
       //given
        ContactType PHONE = ContactType.PHONE;
        String contactContent = "(21) 99999-99999";
       //when
       //then
        assertDoesNotThrow(() -> new Contact(PHONE, contactContent));
    }
    @Test
    void contactEmailIsValid(){
        //given
        ContactType EMAIL = ContactType.EMAIL;
        String contactContent = "jhon.doe@gmail.com";
        //when
        //then
        assertDoesNotThrow(() -> new Contact(EMAIL, contactContent));
    }
    @Test
    void shouldThrowWhenEmailHasNotASymbol(){
        //given
        ContactType EMAIL = ContactType.EMAIL;
        String contactContent = "jhon.doegmail.com";
        //when
        //then
        assertThrows(InvalidEmailException.class,
                () -> new Contact(EMAIL, contactContent), "Invalid email format");
    }
    @Test
    void shouldThrowWhenEmailIsTooShort(){
        //given
        ContactType EMAIL = ContactType.EMAIL;
        String contactContent = "n@m.co";
        //when
        //then
        assertThrows(InvalidEmailException.class,
                () -> new Contact(EMAIL, contactContent), "Invalid email format");
    }

}
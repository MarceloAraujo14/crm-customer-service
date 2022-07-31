package com.maraujo.crm.core.domain.vo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AddressTest {

    @Test
    void addressIsValid(){
        //given
        String street = "Street A";
        String streetNumber = "35B";
        //when
        //then
        assertDoesNotThrow(() -> new Address(street, streetNumber));
    }

}
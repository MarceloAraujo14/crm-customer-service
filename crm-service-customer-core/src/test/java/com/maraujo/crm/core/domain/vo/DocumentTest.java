package com.maraujo.crm.core.domain.vo;

import com.maraujo.crm.core.domain.exception.InvalidDocumentException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DocumentTest {

    @Test
    void cpfIsValid(){
        //given
        String cpf = "01234567890";
        //when
        //then
        assertDoesNotThrow(() -> new Document(cpf));
    }
    @Test
    void rgIsValid(){
        //given
        String rg = "132465789";
        //when
        //then
        assertDoesNotThrow(() -> new Document(rg));
    }
    @ParameterizedTest
    @CsvSource(value = {
            "0123456789,Document have wrong number of digits",
            "'',Document have wrong number of digits", "0123456789, Document have wrong number of digits"}, delimiter = ',')
    void shouldThrowWhenDocumentHasError(String cpf, String expectedMessage){
        assertThatThrownBy(() -> new Document(cpf)).isInstanceOf(InvalidDocumentException.class)
                .hasMessageContaining(expectedMessage);
    }

}
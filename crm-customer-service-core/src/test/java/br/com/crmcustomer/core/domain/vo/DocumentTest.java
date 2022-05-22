package br.com.crmcustomer.core.domain.vo;

import br.com.crmcustomer.core.domain.enums.DocumentType;
import br.com.crmcustomer.core.domain.exception.InvalidDocumentException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
            "0123456789,CPF document must contain 11 digits.",
            "'',Document content can't be empty.", "0123456789, RG document must contain 9 digits."}, delimiter = ',')
    void shouldThrowWhenDocumentHasError(String cpf, String expectedMessage){
        assertThatThrownBy(() -> new Document(cpf)).isInstanceOf(InvalidDocumentException.class)
                .hasMessageContaining(expectedMessage);
    }

}
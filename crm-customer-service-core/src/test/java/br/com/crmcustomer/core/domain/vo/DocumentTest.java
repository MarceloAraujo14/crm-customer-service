package br.com.crmcustomer.core.domain.vo;

import br.com.crmcustomer.core.domain.enums.DocumentType;
import br.com.crmcustomer.core.domain.exception.InvalidDocumentException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DocumentTest {

    @Test
    void cpfIsValid(){
        //given
        String cpf = "01234567890";
        DocumentType CPF = DocumentType.CPF;
        //when
        //then
        assertDoesNotThrow(() -> new Document(CPF, cpf));
    }
    @Test
    void rgIsValid(){
        //given
        String rg = "132465789";
        DocumentType RG = DocumentType.RG;
        //when
        //then
        assertDoesNotThrow(() -> new Document(RG, rg));
    }
    @ParameterizedTest
    @CsvSource(value = {
            "0123456789,CPF document must contain 11 digits.",
            "'',Document content can't be empty."}, delimiter = ',')
    void shouldThrowWhenCPFHasError(String cpf, String message){
        DocumentType CPF = DocumentType.CPF;
        assertThrows(InvalidDocumentException.class,
                () -> new Document(CPF, cpf), message);
    }
    @Test
    void shouldThrowWhenRgDoesNotHaveNineDigits(){
        //given
        String rg = "0123456789";
        DocumentType CPF = DocumentType.CPF;
        //when
        //then
        assertThrows(InvalidDocumentException.class,
                () -> new Document(CPF, rg), "RG document must contain 9 digits.");
    }
}
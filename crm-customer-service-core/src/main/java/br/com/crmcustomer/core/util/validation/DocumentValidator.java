package br.com.crmcustomer.core.util.validation;

import br.com.crmcustomer.core.domain.enums.DocumentType;
import br.com.crmcustomer.core.domain.exception.InvalidDocumentException;

import static br.com.crmcustomer.core.domain.enums.DocumentType.CPF;
import static br.com.crmcustomer.core.domain.enums.DocumentType.RG;

public class DocumentValidator {

    public static void validateDocument(DocumentType documentType, String documentContent){
        if(documentContent.isBlank())
            throw new InvalidDocumentException("Document content can't be empty.");
        if(documentType.equals(CPF) && documentContent.length() != 11)
            throw new InvalidDocumentException("CPF document must contain 11 digits.");
        if(documentType.equals(RG) && documentContent.length() != 9)
            throw new InvalidDocumentException("RG document must contain 9 digits.");
    }
    private DocumentValidator() {
    }
}

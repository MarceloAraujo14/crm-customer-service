package br.com.crmcustomer.core.domain.vo;

import br.com.crmcustomer.core.domain.enums.DocumentType;
import br.com.crmcustomer.core.domain.exception.InvalidDocumentException;

import static br.com.crmcustomer.core.util.validation.DocumentValidator.validateDocument;

public class Document {

    private final DocumentType documentType;
    private final String documentContent;

    public Document(String documentContent) {
        DocumentType type = defineDocumentType(documentContent);
        validateDocument(type, documentContent);
        this.documentType = type;
        this.documentContent = documentContent;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public String getDocumentContent() {
        return documentContent;
    }

    @Override
    public String toString() {
        return  "documentType=" + documentType +
                ", documentContent='" + documentContent + '\'';
    }

    private DocumentType defineDocumentType(String documentContent){
        if(documentContent.length() == 11) return DocumentType.CPF;
        if(documentContent.length() == 9) return DocumentType.RG;
        throw new InvalidDocumentException("Document have wrong number of digits");
    }
}

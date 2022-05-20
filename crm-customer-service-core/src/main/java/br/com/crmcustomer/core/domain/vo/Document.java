package br.com.crmcustomer.core.domain.vo;

import br.com.crmcustomer.core.domain.enums.DocumentType;

import static br.com.crmcustomer.core.util.validation.DocumentValidator.validateDocument;

public class Document {

    private DocumentType documentType;
    private String documentContent;

    public Document(DocumentType documentType, String documentContent) {
        validateDocument(documentType, documentContent);
        this.documentType = documentType;
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
}

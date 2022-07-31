package com.maraujo.crm.core.domain.vo;

import com.maraujo.crm.core.domain.exception.InvalidDocumentException;
import com.maraujo.crm.core.util.validation.DocumentValidator;
import com.maraujo.crm.core.domain.enums.DocumentType;

import java.io.Serializable;

public class Document implements Serializable {

    private final DocumentType documentType;
    private final String documentContent;

    public Document(String documentContent) {
        DocumentType type = defineDocumentType(documentContent);
        DocumentValidator.validateDocument(type, documentContent);
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

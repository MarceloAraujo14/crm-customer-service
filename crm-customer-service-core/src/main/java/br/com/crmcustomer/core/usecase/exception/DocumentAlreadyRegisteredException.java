package br.com.crmcustomer.core.usecase.exception;

public class DocumentAlreadyRegisteredException extends RuntimeException {
    public DocumentAlreadyRegisteredException(String message) {
        super(message);
    }
}

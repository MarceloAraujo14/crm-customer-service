package br.com.crmcustomer.core.usecase.registercustomer.exception;

public class DocumentAlreadyRegisteredException extends RuntimeException {
    public DocumentAlreadyRegisteredException(String message) {
        super(message);
    }
}

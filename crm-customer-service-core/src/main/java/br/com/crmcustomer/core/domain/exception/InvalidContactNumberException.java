package br.com.crmcustomer.core.domain.exception;

public class InvalidContactNumberException extends RuntimeException {
    public InvalidContactNumberException(String message) {
        super(message);
    }
}

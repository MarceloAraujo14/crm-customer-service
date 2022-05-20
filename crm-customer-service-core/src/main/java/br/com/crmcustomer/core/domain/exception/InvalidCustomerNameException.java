package br.com.crmcustomer.core.domain.exception;

public class InvalidCustomerNameException extends RuntimeException {

    public InvalidCustomerNameException(String message) {
        super(message);
    }
}

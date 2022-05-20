package br.com.crmcustomer.core.util.validation;

import br.com.crmcustomer.core.domain.exception.InvalidEmailException;

public class EmailValidator {
    public static void validadeEmail(String email){
        if(email.isBlank())
            throw new InvalidEmailException("Email can't be empty.");
        if(!email.contains("@") || email.length() < 7 || !(email.contains(".com") || email.contains(".org")))
            throw new InvalidEmailException("Invalid email format");
    }
    private EmailValidator(){}
}

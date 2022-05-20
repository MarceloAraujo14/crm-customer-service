package br.com.crmcustomer.core.domain.vo;

import br.com.crmcustomer.core.domain.enums.ContactType;

import static br.com.crmcustomer.core.domain.enums.ContactType.EMAIL;
import static br.com.crmcustomer.core.domain.enums.ContactType.PHONE;
import static br.com.crmcustomer.core.util.format.Formatter.formatEmail;
import static br.com.crmcustomer.core.util.format.Formatter.formatPhone;
import static br.com.crmcustomer.core.util.validation.EmailValidator.validadeEmail;
import static br.com.crmcustomer.core.util.validation.PhoneNumberValidator.validadePhone;

public class Contact {

    private ContactType contactType;
    private String contactContent;

    public Contact(ContactType contactType, String contactContent) {
        if(contactType.equals(PHONE)) {
            contactContent = formatPhone(contactContent); validadePhone(contactContent);
        }
        if(contactType.equals(EMAIL)) {
            contactContent = formatEmail(contactContent); validadeEmail(contactContent);
        }
        this.contactType = contactType;
        this.contactContent = contactContent;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public String getContactContent() {
        return contactContent;
    }

    @Override
    public String toString() {
        return  "contactType=" + contactType +
                ", contactContent='" + contactContent + '\'';
    }
}

package com.maraujo.crm.core.domain.vo;

import com.maraujo.crm.core.util.format.Formatter;
import com.maraujo.crm.core.util.validation.EmailValidator;
import com.maraujo.crm.core.util.validation.PhoneNumberValidator;
import com.maraujo.crm.core.domain.enums.ContactType;

import java.io.Serializable;

import static com.maraujo.crm.core.domain.enums.ContactType.EMAIL;
import static com.maraujo.crm.core.domain.enums.ContactType.PHONE;

public class Contact implements Serializable {

    private final ContactType contactType;
    private final String contactContent;

    public Contact(String contactContent) {
        ContactType type = defineContactType(contactContent);
        if(type.equals(PHONE)) {
            contactContent = Formatter.formatPhone(contactContent); PhoneNumberValidator.validadePhone(contactContent);
        }
        if(type.equals(EMAIL)) {
            contactContent = Formatter.formatEmail(contactContent); EmailValidator.validadeEmail(contactContent);
        }
        this.contactType = type;
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

    private ContactType defineContactType(String contactContent){
        if(contactContent.contains("@") || contactContent.contains(".com")
                || contactContent.contains(".br") || contactContent.contains(".org")) return EMAIL;
        return PHONE;
    }
}

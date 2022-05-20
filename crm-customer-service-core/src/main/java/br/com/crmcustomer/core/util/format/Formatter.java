package br.com.crmcustomer.core.util.format;

public class Formatter {

    public static String formatEmail(String email){
        email = (email.contains(" ")) ? email.replace(" ", "") : email;
        return email.trim();
    }

    public static String formatPhone(String contactNumber){
        contactNumber = (contactNumber.contains("-"))? contactNumber.replace("-","") : contactNumber;
        contactNumber = (contactNumber.contains("("))? contactNumber.replace("(", "") : contactNumber;
        contactNumber = (contactNumber.contains(")"))? contactNumber.replace(")", "") : contactNumber;
        contactNumber = (contactNumber.contains(" "))? contactNumber.replace(" ", "") : contactNumber;
        return contactNumber.trim();
    }

    private Formatter() {
    }
}

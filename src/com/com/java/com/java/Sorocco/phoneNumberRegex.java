package com.com.java.com.java.Sorocco;

public class phoneNumberRegex {

    public static void main(String[] args) {

        String s ="999 - 999 - 9999";

        System.out.println(find_phone_number(s));
    }


    static String find_phone_number(String phoneNo) {
        if (phoneNo.matches("\\d{10}")) return "NONE";
            //validating phone number with -, . or spaces
        else if(phoneNo.matches("\\d{3}[-]\\d{3}[-]\\d{4}")) return phoneNo;
            //validating phone number where area code is in braces ()
        else if(phoneNo.matches("\\(\\d{3}\\)[\\s]\\d{3}-\\d{4}")) {
            return phoneNo;
        }
        else if(phoneNo.contains("(") && phoneNo.contains(")") && phoneNo.contains("-") && phoneNo.length()>12){

            try{
                phoneNo = phoneNo.substring(0, phoneNo.lastIndexOf("-")+5).trim();
            }catch(Exception e){
                return "NONE";
            }
            if(phoneNo.matches("\\(\\d{3}\\)[\\s]\\d{3}-\\d{4}")) {
                return phoneNo;
            }
        }
        else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")){
            return phoneNo;
        }
        else if(!phoneNo.contains("(") && !phoneNo.contains(")") && phoneNo.contains("-") && phoneNo.length()>12){

            phoneNo = phoneNo.substring(phoneNo.indexOf("-")-3 , phoneNo.length()).trim();
            // if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
            //     return phoneNo;
            //
            return phoneNo;
        }
        //validating phone number with extension length from 3 to 5
        else
            return "NONE";

        return "NONE";
    }

}




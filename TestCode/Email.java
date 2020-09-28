/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Email 
{ 
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email = null;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10; 
    private String alternate_email;
    private String companysuffix = "bracu.ac.bd";
    private String company_name = "";
    
    public Email(String first, String last, String company)
    {
        firstName = first;
        lastName = last;
        company_name = company;
    }
    public void setDepartment(String department)
    {
        this.department = department;

        this.password = generatePassword(defaultPasswordLength);
        System.out.println("\nYour password is: " + this.password);
    }
    
    public String generatePassword(int n)
    {
        StringBuilder st = new StringBuilder();
        password = "";
        while(st.length()<n)
        {
            int num = new Random().nextInt((122-65+1))+65;
            
            if((num>=65 && num<=90) || (num>=97 && num<=122))
            {
                st.append((char)num);
            }
        }
        
        password = st.toString();
        password = firstName.charAt(0) + password + lastName.charAt(0) + department.charAt(department.length()-1);
        return password;
    }
 
 public void setMailboxCapacity(int capacity) { this.mailboxCapacity = capacity; }
 
 
    public void setAlternateEmail(String altEmail) { this.alternate_email = altEmail; }


    public void changePassword(String password) { this.password = password; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() { return alternate_email; }
    public String getPassword() { return password; }

    public String showInfo() 
    {
        return "\nDisplay Name:" + firstName + " " + lastName +
          "\nCompany Email: " + email +
          "\nMailbox Capacity: " + mailboxCapacity + "mb\n";
    }

    public void generateEmail() {
        if (email == null) {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + company_name;
        }
    }
}

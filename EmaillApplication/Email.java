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
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10; 
    private String alternate_email;
    private String companysuffix = "bracu.ac.bd";
    private String company_name = "";
    
    public Email()  
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try 
        {
            System.out.println("Enter first name: ");
            this.firstName = reader.readLine();

            System.out.println("Enter last name: ");
            this.lastName = reader.readLine();
        }
        catch(IOException e)
        {
        }
        
        try 
        {
            System.out.println("Enter company name: ");
            this.company_name = reader.readLine();
        }
        catch(IOException e)
        {
        }
        this.department = setDepartment();
        this.password = generatePassword(defaultPasswordLength);
        System.out.println("\nYour password is: " + this.password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + company_name;
    }
    private String setDepartment() 
    {
        System.out.print("New Employee: " + firstName + 
             "\nDepartment Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter Department Code:");
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if (departmentChoice == 1) { return "Sales"; }
        else if (departmentChoice == 2) { return "Development"; }
        else if (departmentChoice == 3) { return "Accounting"; }
        else { return ""; }

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

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() { return alternate_email; }
    public String getPassword() { return password; }

    public String showInfo() 
    {
        return "\nDisplay Name:" + firstName + " " + lastName +
          "\nCompany Email: " + email +
          "\nMailbox Capacity: " + mailboxCapacity + "mb\n";
    }

}

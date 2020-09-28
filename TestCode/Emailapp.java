/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Emailapp {

    public static void main(String[] args) 
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstName = null;
        String lastName = null;
        String company_name = null;
        try
        {
            System.out.println("Enter first name: ");
            firstName = reader.readLine();

            System.out.println("Enter last name: ");
            lastName = reader.readLine();
        }
        catch(IOException e)
        {
        }

        try
        {
            System.out.println("Enter company name: ");
            company_name = reader.readLine();
        }
        catch(IOException e)
        {
        }

        Email em1 = new Email(firstName, lastName, company_name);

        System.out.print("New Employee: " + firstName +
                "\nDepartment Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter Department Code:");
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        String department = null;
        if (departmentChoice == 1) { department = "Sales"; }
        else if (departmentChoice == 2) { department = "Development"; }
        else if (departmentChoice == 3) { department = "Accounting"; }
        else { department = ""; }

        em1.setDepartment(department);

         em1.setAlternateEmail("asif.ayon@gmail.com");
         //System.out.println(em1.getAlternateEmail());

        em1.generateEmail();

        System.out.print(em1.showInfo());
    }

}

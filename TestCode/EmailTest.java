import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class EmailTest {

    private final String firstName = "fname";
    private final String lastName = "lname";
    private final String password = "password";
    private final String department = "department";
    private final int mailboxCapacity = 500;
    private final int defaultPasswordLength = 10;
    private final String alternate_email = "alt_mail";
    private final String companysuffix = "bracu.ac.bd";
    private final String company_name = "";
    private final String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + company_name;

    Email testMail;
    private String testInfo;

    @Before
    public void setup() {
        testMail = new Email(firstName, lastName, company_name);

        testMail.setDepartment(department);
        testMail.setMailboxCapacity(mailboxCapacity);
        testMail.setAlternateEmail(alternate_email);
        testMail.generateEmail();

        testInfo ="\nDisplay Name:" + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "mb\n";

    }

    @Test
    public void generatePasswordTest() {

        String password = testMail.generatePassword(defaultPasswordLength);

        Assert.assertEquals(defaultPasswordLength + 3, password.length());
    }

    @Test
    public void getMailboxCapacityTest() {

        int capacity = testMail.getMailboxCapacity();

        assertEquals(mailboxCapacity, capacity);
    }

    @Test
    public void getAlternateEmailTest() {

        String mail = testMail.getAlternateEmail();

        assertEquals(alternate_email, mail);
    }

    @Test
    public void getPasswordTest() {
        String password = testMail.getPassword();

        assertNotNull(password);
    }

    @Test
    public void showInfoTest() {

        String info = testMail.showInfo();

        assertEquals(testInfo, info);
    }
}
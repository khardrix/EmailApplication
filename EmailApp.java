package emailApp;

/*****************************************************************************************
 *****************************************************************************************
 *****                     *| Project 1: EmailApplication |*                         *****
 *****-------------------------------------------------------------------------------*****
 *****      Scenario: You are an IT Support Administrator Specialist and are         *****
 *****       charged with the task of creating email accounts for new hires.         *****
 *****                  Your application should do the following:                    *****
 ***** -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   - *****
 *****                 Generate an email with the following syntax:                *****
 *****                   firstname.lastname@department.company.com                   *****
 *****                                                                               *****
 *****                          Determine the department:                          *****
 *****            (sales, development, accounting), if none leave blank              *****
 *****                                                                               *****
 *****                 Generate a random String for a password                     *****
 *****                                                                               *****
 *****                 Have set methods to change the password,                    *****
 *****       set the mailbox capacity, and define an alternate email address         *****
 *****                                                                               *****
 *****      Have get methods to display the name, email, and mailbox capacity      *****
 *****_______________________________________________________________________________*****
 *****                               Client Class                                    *****
 *****************************************************************************************
 ****************************************************************************************/

// IMPORTS of needed tools and plug-ins.
import java.util.Scanner;


public class EmailApp {

    // CLASS VARIABLE(s) declaration(s).
    static Scanner input = new Scanner(System.in);
    static String firstName, lastName;


    public static void main(String[] args){

        // INSTANCE VARIABLE(s) declaration(s)


        Email person = generateEmailObject();
        person.showInfo();

        person.setMailboxCapacity(100);
        person.setEmailAlternate("testEmailAddress@randomWebsite.com");
        person.changePassword("iThinkNot!");
        person.changeDepartment();
        person.showInfo();
    }


    public static Email generateEmailObject(){

        firstName = getFirstName();
        lastName = getLastName();

        return new Email(firstName, lastName);
    }


    public static String getFirstName(){

        System.out.print("Please enter your first name: ");
        String firstName = input.nextLine();
        return firstName;
    }


    public static String getLastName(){

        System.out.print("Please enter your last name: ");
        String lastName = input.nextLine();
        return lastName;
    }
}

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
    public static void main(String[] args){

        // INSTANCE VARIABLE(s) declaration(s)
        String firstName;
        String lastName;

        System.out.print("Please enter your first name: ");
        firstName = input.nextLine();
        System.out.print("Please enter your last name: ");
        lastName = input.nextLine();
        Email person = new Email(firstName, lastName);


        person.showInfo();

        person.setMailboxCapacity(100);
        person.setEmailAlternate("testEmailAddress@randomWebsite.com");
        person.changePassword("iThinkNot!");
        person.changeDepartment();
        person.showInfo();
    }


    // I want to be able to use a method like this to be able to create
        // Email objects and have the reference variable name be whatever I pass into the parameter.
            // Example: I want to create an Email object "Bob".
            // I want to create that with: generateEmailObject(Bob);
            // Then I could use methods like: Bob.showInfo();
    public static void generateEmailObject(Email objectName){

        String firstName;
        String lastName;

        System.out.print("Please enter your first name: ");
        firstName = input.nextLine();
        System.out.print("Please enter your last name: ");
        lastName = input.nextLine();

        objectName = new Email(firstName, lastName);
    }
}

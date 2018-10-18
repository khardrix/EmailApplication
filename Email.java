package emailApp;

/*****************************************************************************************
 *****************************************************************************************
 *****                           *| Project 1: Email |*                              *****
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
 *****                               Object Class                                    *****
 *****************************************************************************************
 ****************************************************************************************/


/*
Project 1
Email Application
Scenario: You are an IT Support Administrator Specialist and are
charged with the task of creating email accounts for new hires.
Your application should do the following:
 Generate an email with the following syntax: firstname.lastname@department.company.com
 Determine the department (sales, development, accounting), if none leave blank
 Generate a random String for a password
 Have set methods to change the password, set the mailbox capacity, and define an alternate
email address
 Have get methods to display the name, email, and mailbox capacity
 */

// IMPORTS of needed tools and plug-ins.
import java.util.Random;
import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String department;
    private String[] password;
    private int mailboxCapacity;
    private String email;
    private String newPassword;
    private String emailAternate;
    private Random dice = new Random();
    private Scanner input = new Scanner(System.in);
    private String[] letterLow = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};         // 26
    private String[] letterUpper = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};         // 26
    private String[] numberArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};                 // 10
    private String[] symbols = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "=", "+"};    // 13
    private int textType;
    private int randomNumber;
    private int passwordMaxLength;
    private int passwordLength;
    private String currPassChar;


    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String generatePassword(){

        passwordMaxLength = 4 + dice.nextInt(21);
        for(int i = 0; i <= passwordMaxLength; i++){
            textType = dice.nextInt(4);
            password[i] = getCurrPassChar(textType);
        }
        return password.toString();
    }


    public String getCurrPassChar(int type){


        if(type == 0){
            randomNumber = dice.nextInt(26);
            currPassChar = letterLow[randomNumber];
        }else if(type == 1){
            randomNumber = dice.nextInt(26);
            currPassChar = letterUpper[randomNumber];
        }else if(type == 2){
            randomNumber = dice.nextInt(10);
            currPassChar = numberArr[randomNumber];
        }else if(type == 3){
            randomNumber = dice.nextInt(13);
            currPassChar = symbols[randomNumber];
        }
        return currPassChar;
    }

}

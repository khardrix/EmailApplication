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

// IMPORTS of needed tools and plug-ins.
import java.util.Random;
import java.util.Scanner;


public class Email {

    private String firstName;
    private String lastName;
    private String department;    // Sales, Development and Accounting.
    private String password;
    private int mailboxCapacity = 500;
    private String email;
    private String emailAlternate;


    public Email(String firstName, String lastName){

        this.firstName = firstName;
        this.lastName = lastName;
        this.password = generatePassword();
        this.department = setDepartment();
        this.email = setEmail();
    }


    private String setDepartment(){

        Scanner input = new Scanner(System.in);

        System.out.print("\n1 for Sales " +
                "\n2 for Development " +
                "\n3 for Accounting " +
                "\n0 for none " +
                "\nPlease enter the number that corresponds to your department: ");
        String departChoice = input.nextLine();
        System.out.println();

        while(!departChoice.matches("[0123]")){
            System.out.print("\nInvalid input! " +
                    "\n1 for Sales " +
                    "\n2 for Development " +
                    "\n3 for Accounting " +
                    "\n0 for none " +
                    "\nPlease enter the number that corresponds to your department: ");
            departChoice = input.nextLine();
            System.out.println();
        }

        if(departChoice.equals("1")){ return "Sales"; }
        else if(departChoice.equals("2")){ return "Development"; }
        else if(departChoice.equals("3")){ return "Accounting"; }
        else { return ""; }
    }


    public String generatePassword(){

        Random dice = new Random();
        int passwordMaxLength = 4 + dice.nextInt(21);
        StringBuilder randomPassword = new StringBuilder(passwordMaxLength);

        for(int i = 0; i < passwordMaxLength; i++){
            int textType = dice.nextInt(4);
            randomPassword.append(getCurrPassChar(textType));
        }
        return randomPassword.toString();
    }


    public String getCurrPassChar(int type){

        Random dice = new Random();
        int randomNumber;
        String currPassChar = "";
        String[] letterLow = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};         // 26
        String[] letterUpper = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};         // 26
        String[] numberArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};                 // 10
        String[] symbols = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "=", "+"};    // 13

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


    private String setEmail(){

        String companySuffix = "google.com";
        boolean hasDepartment = this.department.length() >= 1;
        if(hasDepartment)
            return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" +
                    department.toLowerCase() + "." + companySuffix;
        else
            return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + "." + companySuffix;
    }


    public void changePassword(String password){

        this.password = password;
    }


    public void changeDepartment(){

        Scanner input = new Scanner(System.in);

        System.out.print("\n1 for Sales " +
                "\n2 for Development " +
                "\n3 for Accounting " +
                "\n0 for none " +
                "\nPlease enter the number that corresponds to your department: ");
        String departChoice = input.nextLine();
        System.out.println();

        while(!departChoice.matches("[0123]")){
            System.out.print("\nInvalid input! " +
                    "\n1 for Sales " +
                    "\n2 for Development " +
                    "\n3 for Accounting " +
                    "\n0 for none " +
                    "\nPlease enter the number that corresponds to your department: ");
            departChoice = input.nextLine();
            System.out.println();
        }

        if(departChoice.equals("1")){ this.department = "Sales"; }
        else if(departChoice.equals("2")){ this.department = "Development"; }
        else if(departChoice.equals("3")){ this.department = "Accounting"; }
        else { this.department = ""; }

        this.email = setEmail();
    }


    public void setMailboxCapacity(int capacity){

        this.mailboxCapacity = capacity;
    }


    public void setEmailAlternate(String email){

        this.emailAlternate = email;
    }


    public String getName(){

        return firstName + " " + lastName;
    }


    public String getEmail(){

        return email;
    }


    public String getPassword(){

        return password;
    }


    public String getDepartment(){

        return department;
    }


    public int getMailboxCapacity(){

        return mailboxCapacity;
    }


    public String getEmailAlternate(){

        if(emailAlternate == null){ return "N / A"; }
        else{ return emailAlternate; }
    }


    public void showInfo(){

        System.out.println("Name: " + getName() +
                "\nDepartment: " + getDepartment() + "\nEmail: " + getEmail() +
                "\nAlternate Email: " + getEmailAlternate() + "\nPassword: " + getPassword() +
                "\nMailbox Capacity: " + getMailboxCapacity() + "\n");
    }
}

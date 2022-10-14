/*
 * Title: Project 1.3.8 Choose Your Path
 * 
 * Authors: Jaden Tagulinao and Jason Leung
 * Date: 12 October 2022
 * Course: APCSA, Tri 1
 * 
 * Description: Tells a story through a series of inputs from the user. The user can choose which path to take, and the code will run based on that choice.
 */

 // imports the necessary classes used in the code
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.ArrayList;

// class definition header
public class Main {

    // some variables waiting to be used
    public static String log = "";
    public static Scanner sc;
    
    // main storyline
    public static void main(String[] args) throws InterruptedException 
    {
        clearScreen();
        noise("AAAAAAAARRRRGGGGGHHHHHHHHHHH!!!!!!", 150, 5);
        waitContinue();

        int ans = promptUser("...What is going on?\nShould I (1) investigate or (2) go back to sleep?", 0, "the entity esaped.");
        if (ans == 1) // nested series of if, else ifs
        {
            ans = promptUser("I should probably go check that out. I haven't seen anybody else in years.\nShould I bring a (1) weapon or a (2) flashlight?", 0, "the entity escaped.");
            if (ans == 1) 
            {
                ans = promptUser("Having something to protect myself with is probably a good idea. I'm not sure what's even making that noise... would it be smart to go out there?\nShould I (1) step outside or (2) go back to sleep?", 0, "the entity escaped.");
                if (ans == 1) 
                {
                    // print statements scattered throughout the code
                    System.out.println("Eh, I'm big enough to defend myself.");

                    noise("\n*Step*", 50, 0);
                    noise("*Step*", 50, 0);
                    noise("*Step*", 50, 0);

                    noise("\n*Bushes Rustling*", 10, 0);
                    waitContinue();

                    ans = promptUser("\nShould I (1) investigate or (2) go back inside?", 15, "the entity esaped.");
                    if (ans == 1) 
                    {
                        System.out.println("What's making that annoying noise?");

                        noise("\n*Step*", 50, 0);
                        noise("*Step*", 100, 0);
                        noise("AAAAARRRRRRRRRG", 50, 0);
                        waitContinue();

                        ans = promptUser("*The monster leaps at me*\nShould I (1) dodge or (2) try to fight back?", 10, "the entity struck you... you didn't survive.");
                        if (ans == 1) 
                        {
                            noise("\n*WSHHH*", 50, 0);

                            ans = promptUser("That narrowly missed me... WHAT DO I DO NOW?\nShould I (1) raise my hands up or (2) run away?", 10, "the entity attacked again and didn't hesitate to end your life.");
                            if (ans == 1) 
                            {
                                System.out.println("I moved my hands up to block the hit.");
                                noise(".\n.\n.", 50, 1);
                                System.out.println("The monster punctured my hands, nothing come after...");
                            } 
                            else if (ans == 2)
                            {
                                System.out.println("I try to run away... but the monster was too fast and everything fades to black...");
                            }
                        } 
                        else if (ans == 2) 
                        {
                            System.out.println("\nI need to wait for an opening...");

                            noise("\nARRRRGGGH\n", 200, 0);

                            System.out.println("It worked! The monster's hurt!");
                            noise("...\n", 1000, 0);

                            System.out.println("I'm bleeding.");
                            noise("...\n", 1000, 0);

                            clearScreen();
                            System.out.println("Your vision starts to narrow... until everything fades to black.");
                            noise("\n\n...THE END...", 100, 0);
                        }
                    } 
                    else if (ans == 2) 
                    {
                        System.out.println("I quickly go back inside... but I got hit behind and everything fades to black...");
                    }
                } 
                else if (ans == 2) 
                {
                    System.out.println("Not sure what's out there. I'll just go back to sleep and hope it goes away.\n");

                    noise("*Zzz...*", 50, 100);

                    clearScreen();
                    System.out.println("You lie in your bed as the noise slowly fades away, until nothing is heard...");
                    noise("\n\n...THE END...", 100, 0);
                }

            } 
            else if (ans == 2) 
            {
                ans = promptUser("I grabbed my flashlight. Should I (1) look in the forest or (2) the basement?", 0, "");
                if (ans == 1) 
                {
                    System.out.println("Perhaps all this ruckus comes from that forest over there. I'll check it out... ");

                    noise("*step*", 50, 0);
                    noise("*step*", 50, 0);
                    noise("*step*", 50, 0);

                    waitContinue();

                    clearScreen();
                    System.out.println("as soon as I stepped out");
                    noise("...", 500, 0);
                    clearScreen();
                    System.out.print("I got bashed on my back. I dropped down, and everything started to fade...");
                }
                else if (ans == 2)
                {
                    System.out.println("Maybe it's coming from the basement? Hopefully it's nothing, but it can't hurt to check.");

                    noise("*step*", 50, 0);
                    noise("*step*", 50, 0);
                    noise("*step*", 50, 0);

                    waitContinue();

                    clearScreen();
                    noise("*creak*", 50, 0);
                    noise("\nWhat is that?\n", 600, 500);
                    noise("*creak*", 60, 0);
                    noise("*creak*", 70, 0);
                    noise("\nI'm honestly getting scared... I'll just go back\n", 500, 500);
                    noise("*step*", 50, 0);
                    noise("*step*", 50, 0);
                    noise("*c r e a k*", 500, 10);

                    waitContinue();

                    clearScreen();
                    System.out.println("As I reach the entrance of the basement, I heard a fizz, a crackle, and then-");
                    noise("\n*BOOM*", 2500, 2500);  // ambiguous ending

                }
            }
        }
        else if (ans == 2) 
        {
            clearScreen();
            System.out.println("You lie in your bed as the noise slowly fades away, until nothing is heard...");
            noise("\n\n...THE END...", 100, 0);
        }
    }

    //Method that slowly prints a noise
    public static void noise(String noise, int time, int step) throws InterruptedException 
    {
        noise += "\n";

        for (int i = 0; i < noise.length(); i++) 
        {
            System.out.print(noise.substring(i, i+1));
            TimeUnit.MILLISECONDS.sleep(time - (step*i));
        }

        log += noise;
    }

    //Method that prompts the user for a valid answer
    public static int promptUser(String question, int seconds, String timedMessage) 
    {
        Date targetTime = new Date();
        long timeLeft = seconds * 1000;
        ArrayList<Integer> allowedAnswers = new ArrayList<Integer>();
        int ans;

        //Adds the question to the log
        log += "\n\n" + question;

        //Parses the question for the allowed answers and stores them
        String tempQuestion = question;
        while (tempQuestion.indexOf("(") != -1)
        {
            String allowedAnswer = tempQuestion.substring(tempQuestion.indexOf("("), tempQuestion.indexOf(")") + 1);
            allowedAnswers.add(Integer.parseInt(allowedAnswer.substring(1, allowedAnswer.length() - 1)));
            tempQuestion = tempQuestion.replace(allowedAnswer, "");
        }

        //Sets the target time using the amount of seconds
        targetTime.setTime(new Date().getTime() + (seconds * 1000));

        //Continues until valid answer is input
        while (true) 
        {
            //Clears the screen and prints the input 0 to check log
            clearScreen();
            System.out.println("You can input (0) to check the log!");

            //If the question is timed, prints the time left
            if (seconds != 0) 
            {
                System.out.println("You have " + Math.round(timeLeft / 1000) + " second(s) to answer!");
            }

            //Prints the question
            System.out.println("\n" + question);

            try 
            {
                //Gets a new prompt and gets the time left
                sc = new Scanner(System.in);
                ans = sc.nextInt();
                timeLeft = targetTime.getTime() - new Date().getTime();

                //Checks that the target time hasn't passed and the question has a time limit
                if (new Date().compareTo(targetTime) == 1 && seconds != 0) // compound boolean
                {
                    clearScreen();
                    System.out.println("I took too long... " + timedMessage);
                    System.exit(1);
                }

                //Checks if the answer is an actual valid answer
                if (allowedAnswers.indexOf(ans) == -1) 
                {
                    //Checks if the input is the check log input
                    if (ans == 0) 
                    {
                        clearScreen();
                        
                        System.out.println(log);
                        try 
                        {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {}
                
                        waitContinue();
                        throw new Exception("LOG");
                    } 
                    else 
                    {
                        throw new Exception("");
                    }
                }

                break;
            } catch (Exception e) 
            {
                //Prints invalid answer and resets the target time
                if (e.getMessage() != "LOG") 
                {
                    System.out.println("Invalid answer! Try again!");
                }

                targetTime.setTime(new Date().getTime() + timeLeft);
            }
        }

        //Adds the answer to the log and returns the answer
        log += "\n" + ans;
        return ans;
    }

    // Method that clears the terminal
    public static void clearScreen() 
    {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    // Method to wait for the users input to continue the story
    public static void waitContinue() 
    {
        System.out.println("\nPress enter to continue...");
        sc = new Scanner(System.in);
        sc.nextLine();
    }
}
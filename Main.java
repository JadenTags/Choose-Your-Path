import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.ArrayList;

public class Main {
    public static String log = "";
    public static Scanner sc;
    
    public static void main(String[] args) throws InterruptedException {
        clearScreen();
        String scream = "AAAAAAAARRRRGGGGGHHHHHHHHHHH!!!!!!";
        for (int i = 0; i < scream.length(); i++) {
            System.out.print(scream.substring(i, i+1));
            // TimeUnit.MILLISECONDS.sleep(150 - (5*i));
        }
        log += "AAAAAAAARRRRGGGGGHHHHHHHHHHH!!!!!!";
        TimeUnit.SECONDS.sleep(1);

        int ans = promptUser("...What is going on?\nShould I (1) investigate or (2) go back to sleep?", 5, "the entity esaped.");
        if (ans == 1) {
            ans = promptUser("You walk to your storage room and look around. You probab\nBring a weapon or a flashlight?", 5, "the entity escaped.");
    
        } else if (ans == 2) {
            
        }
    }

    public static int promptUser(String question, int seconds, String timedMessage) {
        Date initialTime = new Date();
        Date targetTime = new Date();
        ArrayList<Integer> allowedAnswers = new ArrayList<Integer>();
        ArrayList<String> textAnswers = new ArrayList<String>();
        int ans;

        log += "\n\n" + question;

        String tempQuestion = question;
        while (tempQuestion.indexOf("(") != -1) {
            String allowedAnswer = tempQuestion.substring(tempQuestion.indexOf("("), tempQuestion.indexOf(")") + 1);
            allowedAnswers.add(Integer.parseInt(allowedAnswer.substring(1, allowedAnswer.length() - 1)));
            tempQuestion = tempQuestion.replace(allowedAnswer, "");
        }

        targetTime.setTime(initialTime.getTime() + (seconds * 1000));

        while (true) {
            clearScreen();
            System.out.println("You can input (0) to check the log!");

            if (seconds != 0) {
                System.out.println("You have " + seconds + " seconds to answer!");
            }

            System.out.println("\n" + question);

            try {
                sc = new Scanner(System.in);
                ans = sc.nextInt();

                if (new Date().compareTo(targetTime) == 1 && seconds != 0) {
                    clearScreen();
                    System.out.println("You took too long... " + timedMessage);
                    System.exit(1);
                }

                if (allowedAnswers.indexOf(ans) == -1) {
                    if (ans == 0) {
                        targetTime = checkLog(Math.round((targetTime.getTime() - initialTime.getTime()) / 1000));
                        throw new Exception("LOG");
                    }

                    throw new Exception("");
                }

                break;
            } catch (Exception e) {
                if (e.getMessage() != "LOG") {
                    System.out.println("Invalid answer! Try again!");
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e1) {}
            }
        }

        log += "\n" + ans;
        return ans;
    }

    public static Date checkLog(int secondsLeft) {
        clearScreen();
        System.out.println(secondsLeft);
        System.out.println(log);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {}

        System.out.println("\n\nPress enter to continue...");
        sc = new Scanner(System.in);
        sc.nextLine();

        Date newDate = new Date();
        newDate.setTime(newDate.getTime() + (secondsLeft * 1000));

        return newDate;
    }

    public void time(int secs) {
        try {
            TimeUnit.SECONDS.sleep(secs);
        } catch (InterruptedException e) {}
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
}
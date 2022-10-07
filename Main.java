import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class Main {
    public static Scanner sc;
    
    public static void main(String[] args) throws InterruptedException {
        clearScreen();
        System.out.println("You wake up to a loud scream coming from outside your bunker.");
        TimeUnit.SECONDS.sleep(1);

        String scream = "AAAAAAAARRRRGGGGGHHHHHHHHHHH!!!!!!";
        for (int i = 0; i < scream.length(); i++) {
            System.out.print(scream.substring(i, i+1));
            // TimeUnit.MILLISECONDS.sleep(150 - (5*i));
        }
        TimeUnit.SECONDS.sleep(1);

        int ans = promptUser("Do you want to (1) investigate or (2) go back to sleep?");
        // if (false) {

        // }
    }

    public static int promptUser(String question) {
        ArrayList<Integer> allowedAnswers = new ArrayList<Integer>();
        int ans;

        String tempQuestion = question;
        while (tempQuestion.indexOf("(") != -1) {
            String allowedAnswer = tempQuestion.substring(tempQuestion.indexOf("("), tempQuestion.indexOf(")") + 1);
            allowedAnswers.add(Integer.parseInt(allowedAnswer.substring(1, allowedAnswer.length() - 1)));
            tempQuestion = tempQuestion.replace(allowedAnswer, "");
        }

        while (true) {
            clearScreen();
            System.out.println(question);

            try {
                sc = new Scanner(System.in);
                ans = sc.nextInt();

                if (allowedAnswers.indexOf(ans) == -1) {
                    throw new Exception("w");
                }

                break;
            } catch (Exception e) {
                System.out.println("Invalid answer! Try again!");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e1) {}
            }
        }

        return ans;
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
}
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.ArrayList;

public class Main {
    public static String log = "";
    public static Scanner sc;
    
    public static void main(String[] args) throws InterruptedException {
        clearScreen();
        noise("AAAAAAAARRRRGGGGGHHHHHHHHHHH!!!!!!", 150, 5);
        waitContinue();

        int ans = promptUser("...What is going on?\nShould I (1) investigate or (2) go back to sleep?", 0, "the entity esaped.");
        if (ans == 1) {
            ans = promptUser("I should probably go check that out. I haven't seen anybody else in years.\nShould I bring a (1) weapon or a (2) flashlight?", 0, "the entity escaped.");
            if (ans == 1) {
                ans = promptUser("Having something to protect myself with is probably a good idea. I'm not sure what's even making that noise... would it be smart to go out there?\nShould I (1) step outside or (2) go back to sleep?", 0, "the entity escaped.");
                if (ans == 1) {
                    System.out.println("Eh, I'm big enough to defend myself.");

                    noise("\n*Step*", 50, 0);
                    noise("*Step*", 50, 0);
                    noise("*Step*", 50, 0);

                    noise("\n*Bushes Rustling*", 10, 0);
                    waitContinue();

                    ans = promptUser("\nShould I (1) investigate or (2) go back inside?", 15, "the entity esaped.");
                    if (ans == 1) {
                        System.out.println("What's making that annoying noise?");

                        noise("\n*Step*", 50, 0);
                        noise("*Step*", 100, 0);
                        noise("AAAAARRRRRRRRRG", 50, 0);
                        waitContinue();

                        ans = promptUser("*The monster leaps at me*\nShould I (1) dodge or (2) try to fight back?", 10, "the entity struck you... you didn't survive.");
                        if (ans == 1) {
                            noise("\n*WSHHH*", 50, 0);

                            ans = promptUser("That narrowly missed me... WHAT DO I DO NOW?\nShould I (1) ", 10, "the entity attacked again and didn't hesitate to end your life.");
                            if (ans == 1) {

                            }
                        } else if (ans == 2) {
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
                } else if (ans == 2) {
                    System.out.println("Not sure what's out there. I'll just go back to sleep and hope it goes away.\n");

                    noise("*Zzz...*", 50, 100);

                    clearScreen();
                    System.out.println("You lie in your bed as the noise slowly fades away, until nothing is heard...");
                    noise("\n\n...THE END...", 100, 0);
                }

            } else if (ans == 2) {

            }
        } else if (ans == 2) {
            clearScreen();
            System.out.println("You lie in your bed as the noise slowly fades away, until nothing is heard...");
            noise("\n\n...THE END...", 100, 0);
        }
    }

    public static void noise(String noise, int time, int step) throws InterruptedException {
        noise += "\n";

        for (int i = 0; i < noise.length(); i++) {
            System.out.print(noise.substring(i, i+1));
            TimeUnit.MILLISECONDS.sleep(time - (step*i));
        }

        log += noise;
    }

    public static int promptUser(String question, int seconds, String timedMessage) {
        Date targetTime = new Date();
        long timeLeft = seconds * 1000;
        ArrayList<Integer> allowedAnswers = new ArrayList<Integer>();
        int ans;

        log += "\n\n" + question;

        String tempQuestion = question;
        while (tempQuestion.indexOf("(") != -1) {
            String allowedAnswer = tempQuestion.substring(tempQuestion.indexOf("("), tempQuestion.indexOf(")") + 1);
            allowedAnswers.add(Integer.parseInt(allowedAnswer.substring(1, allowedAnswer.length() - 1)));
            tempQuestion = tempQuestion.replace(allowedAnswer, "");
        }

        targetTime.setTime(new Date().getTime() + (seconds * 1000));

        while (true) {
            clearScreen();
            System.out.println("You can input (0) to check the log!");

            if (seconds != 0) {
                System.out.println("You have " + Math.round(timeLeft / 1000) + " second(s) to answer!");
            }

            System.out.println("\n" + question);

            try {
                sc = new Scanner(System.in);
                ans = sc.nextInt();
                timeLeft = targetTime.getTime() - new Date().getTime();

                if (new Date().compareTo(targetTime) == 1 && seconds != 0) {
                    clearScreen();
                    System.out.println("I took too long... " + timedMessage);
                    System.exit(1);
                }

                if (allowedAnswers.indexOf(ans) == -1) {
                    if (ans == 0) {
                        clearScreen();
                        
                        System.out.println(log);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {}
                
                        waitContinue();
                        throw new Exception("LOG");
                    } else {
                        throw new Exception("");
                    }
                }

                break;
            } catch (Exception e) {
                if (e.getMessage() != "LOG") {
                    System.out.println("Invalid answer! Try again!");
                }

                targetTime.setTime(new Date().getTime() + timeLeft);
            }
        }

        log += "\n" + ans;
        return ans;
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    public static void waitContinue() {
        System.out.println("\nPress enter to continue...");
        sc = new Scanner(System.in);
        sc.nextLine();
    }
}
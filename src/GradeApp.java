import java.util.InputMismatchException;
import java.util.Scanner;

public class GradeApp {

    public static int fetchInteger(int lowerBound, int upperbound){
        Scanner reader;
        int n = 0;
        while(true) {
            System.out.println("Enter a number:");
            try {
                reader = new Scanner(System.in);
                n = reader.nextInt();
            } catch (InputMismatchException e) {

            }
            if(lowerBound <= n && n <= upperbound) {
                break;
            }else{
                System.out.println("That is not a valid number!");
            }
        }
        return n;
    }

    public static void main(String args[]){
        String[] table = new String[5];
        table[0] = "Welcome to GradeApp!";
        table[1] = "Please choose what you want to calculate:";
        table[2] = "1 - Average";
        table[3] = "2 - What to omit";
        table[4] = "3 - Mark needed for a certain grade";
        for(String row : table){
            System.out.println(row);
        }

        int userInput = fetchInteger(1, 3);
        if(userInput == 1){
            System.out.println("Your grade is " + Calculations.averageCalculation() + "%");
        }else if(userInput == 2){
            Calculations.omitCalculation();
        }else if(userInput == 3){
            Calculations.markNeededCalculation();
        }
    }
}

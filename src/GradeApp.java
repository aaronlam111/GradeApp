import java.util.InputMismatchException;
import java.util.Scanner;

public class GradeApp {

    public static double fetchX(int lowerBound, int upperbound){
        Scanner reader;
        double n = 0;
        while(true) {
            System.out.println("Enter a number:");
            try {
                reader = new Scanner(System.in);
                n = reader.nextDouble();
            } catch (InputMismatchException ignored) {

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

        System.out.println("Welcome to GradeApp!");
        while(true) {
            String[] table = new String[6];
            table[0] = "Please choose what you want to calculate:";
            table[1] = "1 - Re-enter marks";
            table[2] = "2 - Average";
            table[3] = "3 - What to omit";
            table[4] = "4 - Mark needed for a certain grade";
            table[5] = "0 - Exit";

            for (String row : table) {
                System.out.println(row);
            }

            int userInput = (int) fetchX(0, 4);
            if (userInput == 0) {
                break;
            } else if (userInput == 1) {
                Calculations.inputGrades();
            } else if (userInput == 2) {
                System.out.println("Your grade is " + Calculations.averageCalculation()*100 + "%");
            } else if (userInput == 3) {
                System.out.println("You should omit #" + Calculations.omitCalculation());
            } else if (userInput == 4) {
                System.out.println("You need a " + Calculations.markNeededCalculation()*100 + "% " +
                        "to achieve your desired grade!");
            }
        }
    }
}

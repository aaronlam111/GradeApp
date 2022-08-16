import java.util.Scanner;


public class Calculations {
    static double[] weightPerAssignment;
    static double[] gradePerAssignment;
    static double totalWeight = 0;

    public static void weightOfItems(){
        System.out.println("Enter the weight of the assignments/tests in DECIMAL format (press enter after each one):");
        Scanner s = new Scanner(System.in);
        for(int i = 0; i < weightPerAssignment.length; i++){
            weightPerAssignment[i] = s.nextDouble();
        }

        for(double i: weightPerAssignment){
            totalWeight += i;
        }
        System.out.println("The total WEIGHT of all your assignments/tests is: " + totalWeight*100 + "%");
    }

    public static void gradeofItems(){
        System.out.println("Enter the GRADE of the assignments/tests in DECIMAL format (press enter after each one):");
        Scanner s = new Scanner(System.in);
        for(int i = 0; i < gradePerAssignment.length; i++){
            gradePerAssignment[i] = s.nextDouble()*100;
        }
    }

    public static double averageCalculation(){
        double grade = 0;
        System.out.println("How many assignments/tests do you have a grade for?");
        int n = GradeApp.fetchInteger(1,99);
        weightPerAssignment = new double[n];
        gradePerAssignment = new double[n];
        weightOfItems();
//        System.out.println("Is this correct? (Y/N)");
//        Scanner s = new Scanner(System.in);
//        String userInput = s.nextLine();
//        if(userInput == "n") weightOfItems();
        gradeofItems();
        for(int i = 0; i < weightPerAssignment.length; i++){
            grade += weightPerAssignment[i] * gradePerAssignment[i];
        }
        return grade/totalWeight;
    }

    public static void omitCalculation() {
    }

    public static void markNeededCalculation() {
    }
}

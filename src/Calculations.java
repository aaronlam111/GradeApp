import java.util.Scanner;


public class Calculations {
    static double[] weightPerAssignment;
    static double[] gradePerAssignment;
    static double totalWeight;

    public static void weightOfItems(){
        System.out.println("Enter the weight of the assignments/tests in DECIMAL format (press enter after each one):");
        Scanner s = new Scanner(System.in);
        for(int i = 0; i < weightPerAssignment.length; i++){
            weightPerAssignment[i] = s.nextDouble();
        }
        totalWeight = 0;
        for(double i: weightPerAssignment){
            totalWeight += i;
        }
        System.out.println("The total WEIGHT of all your assignments/tests is: " + totalWeight*100 + "%");
    }

    public static void gradeOfItems(){
        System.out.println("Enter the GRADE of the assignments/tests in DECIMAL format (press enter after each one):");
        Scanner s = new Scanner(System.in);
        for(int i = 0; i < gradePerAssignment.length; i++){
            gradePerAssignment[i] = s.nextDouble();
        }
    }

    public static void inputGrades() {
        System.out.println("How many assignments/tests do you have a grade for?");
        int n = (int) GradeApp.fetchX(1,99);
        weightPerAssignment = new double[n];
        gradePerAssignment = new double[n];
        weightOfItems();
        gradeOfItems();
    }

    public static double averageCalculation(){
        if(weightPerAssignment == null) inputGrades();

        double grade = 0;
        for(int i = 0; i < weightPerAssignment.length; i++){
            grade += weightPerAssignment[i] * gradePerAssignment[i];
        }
        return grade/totalWeight;
    }

    public static int omitCalculation() {
        if(weightPerAssignment == null) inputGrades();

        double max = 0;
        int indexOfMax = 0;
        double[] weightedAvg = new double[weightPerAssignment.length];
        for(int i = 0; i < weightPerAssignment.length; i++){
            weightedAvg[i] = weightPerAssignment[i] * gradePerAssignment[i];
            if(weightPerAssignment[i] - weightedAvg[i] > max){
                max = weightPerAssignment[i] - weightedAvg[i];
                indexOfMax = i;
            }
        }
        return indexOfMax+1;
    }

    public static double markNeededCalculation() {
        if(weightPerAssignment == null) inputGrades();

        System.out.println("What is your desired grade in DECIMAL format?");
        double desiredGrade = GradeApp.fetchX(0,100);
        double markNeeded = (desiredGrade - (averageCalculation() * totalWeight))/(1-totalWeight);
        return markNeeded /*(double) Math.round(markNeeded)*/;
    }

}

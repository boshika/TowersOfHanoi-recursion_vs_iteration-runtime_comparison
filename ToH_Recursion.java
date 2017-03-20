import java.util.Scanner;

public class ToH_Recursion {
    static int sign;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number of disks: ");
        int input = scan.nextInt();

        //checks if even or odd, decides first direction
        if (input%2 == 0)
            sign = 1;
        else
            sign = -1;
        long start = java.util.Calendar.getInstance().getTimeInMillis();
        System.out.println("Start: " + start + "ms");
        hanoi(input);
        long end = java.util.Calendar.getInstance().getTimeInMillis();
        System.out.println("End: " + end + "ms");
        System.out.println("it took this long to complete this stuff: " + (end - start) + "ms");

        System.out.println("Do you wish to continue, Press 1 for yes/2 for NO? ");
        int input2 = scan.nextInt();

        while(input2 == 1) {
            System.out.println("Enter number of disks: ");
            input = scan.nextInt();
            start = java.util.Calendar.getInstance().getTimeInMillis();
            System.out.println("Start: " + start + "ms");
            hanoi(input);
            end = java.util.Calendar.getInstance().getTimeInMillis();
            System.out.println("End: " + end + "ms");
            System.out.println("it took this long to complete this stuff: " + (end - start) + "ms");
            System.out.println("Do you wish to continue, Press 1 for yes/2 for NO? ");
            input2 = scan.nextInt();
        }
    }

    public static void hanoi(int n) {
        //alternates the direction for each disc

        int i = (int)Math.pow(-1, n)*sign;

        if (n == 1)
            System.out.println("Disc 1: " + (i == 1 ? "left" : "right"));
        else {
            hanoi(n-1);
            System.out.println("Disc " + n + ": " + (i == 1 ? "left" : "right")); //depends on 2 things, if n is even or odd and where we're at now (this calls for an alternation)
            hanoi(n-1);
        }
    }
}
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class ToH_Iterative {

    static int MegaBytes = 1024 * 1024;

    private static int direction_selector; //selects direction of smallest disc according to whether the total number of discs even or odd
    private static int[] disc_position_of; //stores position of each disc. First tower from left is 0, second is 1 and third is 2

    public ToH_Iterative() {
        direction_selector = 0;
    }

    public static void main(String[] args) throws FileNotFoundException {

        //invokes constructor
        ToH_Iterative o = new ToH_Iterative();

        Hashtable<Integer, Long> myList = new Hashtable<Integer, Long>();
        Hashtable<Integer, Long> HeapMemory = new Hashtable<Integer, Long>();
        int str;
        int str2;

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number of n: ");
        int n = scan.nextInt();

        disc_position_of = new int[n];

        //initial position of all disks is 0
        for (int i = 0; i < n; i++) {
            disc_position_of[i] = 0;
        }

        //checks if even or odd
        direction_selector = evenOrOdd(n);

        long start = java.util.Calendar.getInstance().getTimeInMillis();
        long totalMemory = Runtime.getRuntime().totalMemory() / MegaBytes;
        long maxMemory = Runtime.getRuntime().maxMemory() / MegaBytes;
        long freeMemory = Runtime.getRuntime().freeMemory() / MegaBytes;

        System.out.println("**** Iterative Program Start Heap utilization Analysis [MB] ****");
        System.out.println("Start Time: " + start + "ms");
        System.out.println("JVM totalMemory also equals to initial heap size of JVM :"+ totalMemory + " MB");
        System.out.println("JVM maxMemory also equals to maximum heap size of JVM: "+ maxMemory + " MB");
        System.out.println("JVM freeMemory: " + freeMemory + " MB");
        System.out.println("*******************************************************");
        System.out.println("\n");

        System.out.println("**** Building the Hanoi ****");

        towerOfHanoi(n);

        System.out.println("****************************");

        totalMemory = Runtime.getRuntime().totalMemory() / MegaBytes;
        maxMemory = Runtime.getRuntime().maxMemory() / MegaBytes;
        freeMemory = Runtime.getRuntime().freeMemory() / MegaBytes;
        long usedMemory = maxMemory - freeMemory;
        long end = java.util.Calendar.getInstance().getTimeInMillis();
        long execution_time = end - start;

        System.out.println("\n");
        System.out.println("**** Iterative Program End Heap utilization Analysis [MB] ****");
        System.out.println("End Time: " + end + "ms");
        System.out.println("It took this long to complete this stuff: " + execution_time + "ms");
        System.out.println("USED MEMORY: " + usedMemory + " MB");
        System.out.println("totalMemory in JVM shows current size of java heap:"+totalMemory + " MB");
        System.out.println("maxMemory in JVM: " + maxMemory + " MB");
        System.out.println("freeMemory in JVM: " + freeMemory + " MB");
        System.out.println("*******************************************************");
        System.out.println("\n");

        HeapMemory.put(n, usedMemory);
        myList.put(n, execution_time);

        System.out.println("******************** PROMPT ***********************");
        System.out.println("Do you wish to continue, Press 1 for yes/2 for NO? ");
        int input2 = scan.nextInt();

        while(input2 == 1) {
            System.out.println("Enter number of disks: ");
            n = scan.nextInt();
            disc_position_of = new int[n];

            //initial position of all disks is 0
            for (int i = 0; i < n; i++) {
                disc_position_of[i] = 0;
            }

            //checks if even or odd
            direction_selector = evenOrOdd(n);

            start = java.util.Calendar.getInstance().getTimeInMillis();

            System.out.println("**** Iterative Program Start Heap utilization Analysis [MB] ****");
            System.out.println("Start Time: " + start + "ms");
            System.out.println("JVM totalMemory also equals to initial heap size of JVM :"+ totalMemory + " MB");
            System.out.println("JVM maxMemory also equals to maximum heap size of JVM: "+ maxMemory + " MB");
            System.out.println("JVM freeMemory: " + freeMemory + " MB");
            System.out.println("*******************************************************");
            System.out.println("\n");

            System.out.println("**** Building the Hanoi ****");

            towerOfHanoi(n);

            System.out.println("****************************");

            totalMemory = Runtime.getRuntime().totalMemory() / MegaBytes;
            maxMemory = Runtime.getRuntime().maxMemory() / MegaBytes;
            freeMemory = Runtime.getRuntime().freeMemory() / MegaBytes;
            usedMemory = maxMemory - freeMemory;
            end = java.util.Calendar.getInstance().getTimeInMillis();
            execution_time = end - start;

            System.out.println("\n");
            System.out.println("**** Iterative Program End Heap utilization Analysis [MB] ****");
            System.out.println("End Time: " + end + "ms");
            System.out.println("It took this long to complete this stuff: " + execution_time + "ms");
            System.out.println("USED MEMORY: " + usedMemory + " MB");
            System.out.println("totalMemory in JVM shows current size of java heap:"+totalMemory + " MB");
            System.out.println("maxMemory in JVM: " + maxMemory + " MB");
            System.out.println("freeMemory in JVM: " + freeMemory + " MB");
            System.out.println("*******************************************************");
            System.out.println("\n");

            HeapMemory.put(n, usedMemory);
            myList.put(n, execution_time);

            System.out.println("******************** PROMPT ***********************");
            System.out.println("Do you wish to continue, Press 1 for yes/2 for NO? ");
            input2 = scan.nextInt();
        }

        System.out.println("N And Run Time" + myList);
        System.out.println("N And Usage" + HeapMemory);

        Set<Integer> keys = myList.keySet();
        Set<Integer> keys2 = HeapMemory.keySet();
        Iterator<Integer> itr = keys.iterator();
        Iterator<Integer> itr2 = keys2.iterator();


        PrintStream out = new PrintStream(new FileOutputStream("Iterative_TOH_Analysis.txt", true));
        PrintStream console = System.out;
        System.setOut(out);

        System.out.println("-------------------- Iterative Run Times -----------------");
        System.out.println("| Number Of Rings | Execution Time   |");

        //Displaying Key and value pairs
        while (itr.hasNext()) {
            // Getting Key
            str = itr.next();
            System.out.println("|        " + str + " rings" + "  |    " + myList.get(str) + " ms" + "         |");
        }

        System.out.println("-------------------- Iterative Memory Usage -----------------");
        System.out.println("| Number Of Rings | Usage            |");

        //Displaying Key and value pairs from list two
        while (itr2.hasNext()) {
            // Getting Key
            str2 = itr2.next();
            System.out.println("|        " + str2 + " rings" + "  |    " + HeapMemory.get(str2) + " MB" + "         |");
        }

    }

    public static void towerOfHanoi(int n) {

        for (int i = 0; i < (Math.pow(2, n)-1)/2; i++) {

            //moves smallest disc left or right depending on whether total the number of discs even or odd
            System.out.print("Disc 1 moved from tower " + (disc_position_of[0]+1)); //will print 0+1=1
            disc_position_of[0] = (disc_position_of[0] + direction_selector) % 3; //will be print 0, 1 or 2
            System.out.println(" to tower " + (disc_position_of[0]+1)); //will print 1 or 3

            //For easier understanding, let's call TOWER1 and TOWER2 the first and second towers which do not hold the smallest disc

            boolean first_is_empty = true, second_is_empty = true; //indicators for TOWER1 and TOWER2
            int smallest1 = 0, smallest2 = 0; //smallest1 and smallest2 store smallest discs of TOWER1 and TOWER2

            //checks if TOWER1 is empty
            for (int j = 0; j < n; j++)
                if ( disc_position_of[j] == (disc_position_of[0]+1)%3 ) {
                    first_is_empty = false;
                    smallest1 = j;
                    j = n; //breaks out of the loop
                }

            //checks if TOWER2 is empty
            for (int j = 0; j < n; j++)
                if ( disc_position_of[j] == (disc_position_of[0]+2)%3 ) {
                    second_is_empty = false;
                    smallest2 = j;
                    j = n; //breaks out of the loop
                }

            if (first_is_empty) {
                //checks for the smallest disc in TOWER2 and sends it to TOWER1
                for (int j = 0; j < n; j++)
                    if (disc_position_of[j] == (disc_position_of[0]+2)%3) {
                        System.out.print("Disc " + (j+1) + " moved from tower " + (disc_position_of[j]+1));
                        disc_position_of[j] = (disc_position_of[0]+1)%3;
                        System.out.println(" to tower " + (disc_position_of[j]+1));
                        j = n; //breaks out of the loop
                    }
            }

            else if(second_is_empty) {
                //checks for the smallest disc in TOWER1 and sends it to TOWER2
                for (int j = 0; j < n; j++)
                    if (disc_position_of[j] == (disc_position_of[0]+1)%3) {
                        System.out.print("Disc " + (j+1) + " moved from tower " + (disc_position_of[j]+1));
                        disc_position_of[j] = (disc_position_of[0]+2)%3;
                        System.out.println(" to tower " + (disc_position_of[j]+1));
                        j = n; //breaks out of the loop
                    }
            }

            else { //if none is empty, move smallest disc among TOWER1 and TOWER2 from its tower the the other
                if (smallest1 < smallest2) {
                    System.out.print("Disc " + (smallest1+1) + " moved from tower " + (disc_position_of[smallest1]+1));
                    disc_position_of[smallest1] = disc_position_of[smallest2];
                    System.out.println(" to tower " + (disc_position_of[smallest2]+1));
                }

                else {
                    System.out.print("Disc " + (smallest2+1) + " moved from tower " + (disc_position_of[smallest2]+1));
                    disc_position_of[smallest2] = disc_position_of[smallest1];
                    System.out.println(" to tower " + (disc_position_of[smallest1]+1));
                }
            }
        }
    }

    public static int evenOrOdd(int n) {
        if (n%2 == 0)
            return 1;
        else
            return 2;
    }

}
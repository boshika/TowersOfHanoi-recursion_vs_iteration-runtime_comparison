
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class ToH_Recursion {
    static int sign;
    static int MegaBytes = 1024 * 1024;

    public static void main(String[] args) throws FileNotFoundException {

        Hashtable<Integer, Long> myList = new Hashtable<Integer, Long>();
        Hashtable<Integer, Long> HeapMemory = new Hashtable<Integer, Long>();
        int str;
        int str2;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of disks: ");
        int input = scan.nextInt();

        //checks if even or odd, decides first direction
        if (input%2 == 0)
            sign = 1;
        else
            sign = -1;

        long start = java.util.Calendar.getInstance().getTimeInMillis();
        long totalMemory = Runtime.getRuntime().totalMemory() / MegaBytes;
        long maxMemory = Runtime.getRuntime().maxMemory() / MegaBytes;
        long freeMemory = Runtime.getRuntime().freeMemory() / MegaBytes;

        System.out.println("**** Program Start Heap utilization Analysis [MB] ****");
        System.out.println("Start Time: " + start + "ms");
        System.out.println("JVM totalMemory also equals to initial heap size of JVM :"+ totalMemory + " MB");
        System.out.println("JVM maxMemory also equals to maximum heap size of JVM: "+ maxMemory + " MB");
        System.out.println("JVM freeMemory: " + freeMemory + " MB");
        System.out.println("*******************************************************");
        System.out.println("\n");

        System.out.println("**** Building the Hanoi ****");

        hanoi(input);

        System.out.println("****************************");

        totalMemory = Runtime.getRuntime().totalMemory() / MegaBytes;
        maxMemory = Runtime.getRuntime().maxMemory() / MegaBytes;
        freeMemory = Runtime.getRuntime().freeMemory() / MegaBytes;
        long usedMemory = maxMemory - freeMemory;
        long end = java.util.Calendar.getInstance().getTimeInMillis();
        long execution_time = end - start;

        System.out.println("\n");
        System.out.println("**** Program End Heap utilization Analysis [MB] ****");
        System.out.println("End Time: " + end + "ms");
        System.out.println("It took this long to complete this stuff: " + execution_time + "ms");
        System.out.println("USED MEMORY: " + usedMemory + " MB");
        System.out.println("totalMemory in JVM shows current size of java heap:"+totalMemory + " MB");
        System.out.println("maxMemory in JVM: " + maxMemory + " MB");
        System.out.println("freeMemory in JVM: " + freeMemory + " MB");
        System.out.println("*******************************************************");
        System.out.println("\n");

        HeapMemory.put(input, usedMemory);
        myList.put(input, execution_time);


        System.out.println("******************** PROMPT ***********************");
        System.out.println("Do you wish to continue, Press 1 for yes/2 for NO? ");
        int input2 = scan.nextInt();


        while(input2 == 1) {
            System.out.println("Enter number of disks: ");
            input = scan.nextInt();
            start = java.util.Calendar.getInstance().getTimeInMillis();
            totalMemory = Runtime.getRuntime().totalMemory() / MegaBytes;
            maxMemory = Runtime.getRuntime().maxMemory() / MegaBytes;
            freeMemory = Runtime.getRuntime().freeMemory() / MegaBytes;

            System.out.println("**** Program Start Heap utilization Analysis [MB] ****");
            System.out.println("Start Time: " + start + "ms");
            System.out.println("JVM totalMemory also equals to initial heap size of JVM :"+ totalMemory + " MB");
            System.out.println("JVM maxMemory also equals to maximum heap size of JVM: "+ maxMemory + " MB");
            System.out.println("JVM freeMemory: " + freeMemory + " MB");
            System.out.println("*******************************************************");
            System.out.println("\n");

            System.out.println("**** Building the Hanoi ****");

            hanoi(input);

            System.out.println("****************************");

            totalMemory = Runtime.getRuntime().totalMemory() / MegaBytes;
            maxMemory = Runtime.getRuntime().maxMemory() / MegaBytes;
            freeMemory = Runtime.getRuntime().freeMemory() / MegaBytes;
            usedMemory = maxMemory - freeMemory;
            end = java.util.Calendar.getInstance().getTimeInMillis();
            execution_time = end - start;

            System.out.println("\n");
            System.out.println("**** Program End Heap utilization Analysis [MB] ****");
            System.out.println("End Time: " + end + "ms");
            System.out.println("It took this long to complete this stuff: " + execution_time + "ms");
            System.out.println("USED MEMORY: " + usedMemory + " MB");
            System.out.println("totalMemory in JVM shows current size of java heap:"+totalMemory + " MB");
            System.out.println("maxMemory in JVM: " + maxMemory + " MB");
            System.out.println("freeMemory in JVM: " + freeMemory + " MB");
            System.out.println("*******************************************************");
            System.out.println("\n");

            HeapMemory.put(input, usedMemory);
            myList.put(input, execution_time);

            System.out.println("******************** PROMPT ***********************");
            System.out.println("Do you wish to continue, Press 1 for yes/2 for NO? ");
            input2 = scan.nextInt();

        }

        System.out.println("N And Run Time" + myList);

        Set<Integer> keys = myList.keySet();
        Set<Integer> keys2 = HeapMemory.keySet();
        Iterator<Integer> itr = keys.iterator();
        Iterator<Integer> itr2 = keys2.iterator();

        PrintStream o = new PrintStream(new FileOutputStream("output.txt", true));
        PrintStream console = System.out;
        System.setOut(o);
        System.out.println("-------------------- Recursive Run Times -----------------");
        System.out.println("| Number Of Rings | Execution Time   |");

        //Displaying Key and value pairs from list one
        while (itr.hasNext()) {
            // Getting Key
            str = itr.next();
            System.out.println("|        " + str + " rings" + "  |    " + myList.get(str) + " ms" + "         |");
        }

        System.out.println("-------------------- Recursive Memory Usage -----------------");
        System.out.println("| Number Of Rings | Usage   |");

        //Displaying Key and value pairs from list two
        while (itr2.hasNext()) {
            // Getting Key
            str2 = itr2.next();
            System.out.println("|        " + str2 + " rings" + "  |    " + HeapMemory.get(str2) + " MB" + "         |");
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
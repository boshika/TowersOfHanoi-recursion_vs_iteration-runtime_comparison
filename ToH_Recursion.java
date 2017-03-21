
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

        long totalMemory = Runtime.getRuntime().totalMemory() / MegaBytes;
        long maxMemory = Runtime.getRuntime().maxMemory() / MegaBytes;
        long freeMemory = Runtime.getRuntime().freeMemory() / MegaBytes;

        System.out.println("**** Heap utilization Analysis [MB] ****");
        System.out.println("JVM totalMemory also equals to initial heap size of JVM :"+ totalMemory);
        System.out.println("JVM maxMemory also equals to maximum heap size of JVM: "+ maxMemory);
        System.out.println("JVM freeMemory: " + freeMemory);

        hanoi(input);

        totalMemory = Runtime.getRuntime().totalMemory() / MegaBytes;
        maxMemory = Runtime.getRuntime().maxMemory() / MegaBytes;
        freeMemory = Runtime.getRuntime().freeMemory() / MegaBytes;
        long usedMemory = maxMemory - freeMemory;
        System.out.println("Used Memory in JVM: " + usedMemory);
        System.out.println("totalMemory in JVM shows current size of java heap:"+totalMemory);
        System.out.println("maxMemory in JVM: " + maxMemory);
        System.out.println("freeMemory in JVM: " + freeMemory);

        HeapMemory.put(1, usedMemory);
        long end = java.util.Calendar.getInstance().getTimeInMillis();
        System.out.println("End: " + end + "ms");
        long execution_time = end - start;

        System.out.println("it took this long to complete this stuff: " + execution_time + "ms");
        System.out.println("USED MEMORY: " + usedMemory + " MB");

        myList.put(input, execution_time);
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
            execution_time = end - start;
            System.out.println("it took this long to complete this stuff: " + execution_time + "ms");
            myList.put(input, execution_time);
            System.out.println("Do you wish to continue, Press 1 for yes/2 for NO? ");
            input2 = scan.nextInt();
        }

        System.out.println(myList);

        Set<Integer> keys = myList.keySet();
        Iterator<Integer> itr = keys.iterator();
        PrintStream o = new PrintStream(new FileOutputStream("output.txt", true));
        PrintStream console = System.out;
        System.setOut(o);
        System.out.println("-------------------- Recursive Run Times -----------------");
        System.out.println("| Number Of Rings | Execution Time   |");

        //Displaying Key and value pairs
        while (itr.hasNext()) {
            // Getting Key
            str = itr.next();
            System.out.println("|        " + str + " rings" + "  |    " + myList.get(str) + " ms" + "         |");
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
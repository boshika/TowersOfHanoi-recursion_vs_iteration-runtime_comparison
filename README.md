# Towers Of Hanoi: Recursion and Iteration Runtime Comparison

1. [Abstract](#abstract)
1. [Requirements](#requirements)
1. [Development](#development)
    1. [Running the program](#running-program)
    2. [Sample I/O](#samplei/o)
    3. [Documentation](#documentation)
1. [Run-time Graphs](#graphs)
1. [Team](#team)

## Abstract

## Usage

> Make sure you are setup with below mentioned requirements. Fork and have fun.

## Requirements

- Java version 7 or 8
- JDK 1.7 or 1,8
- IDE, either IntelliJ or Eclipse preferred

## Development

### Running The Program

From the terminal within the root directory:

```sh
-- recompile all classes javac *.java
-- run the program java ToH_Iterative.java and ToH_Recursion.java
-- Follow the prompts
```

### Sample I/O

```
$ java ToH_Recursion
Enter number of disks: 
1
**** Recursive Program Start Heap utilization Analysis [MB] ****
Start Time: 1490125052958ms
JVM totalMemory also equals to initial heap size of JVM :61 MB
JVM maxMemory also equals to maximum heap size of JVM: 910 MB
JVM freeMemory: 60 MB
*******************************************************


**** Building the Hanoi ****
Disc 1: left
****************************


**** Recursive Program End Heap utilization Analysis [MB] ****
End Time: 1490125052961ms
It took this long to complete this stuff: 3ms
USED MEMORY: 851 MB
totalMemory in JVM shows current size of java heap:61 MB
maxMemory in JVM: 910 MB
freeMemory in JVM: 59 MB
*******************************************************


******************** PROMPT ***********************
Do you wish to continue, Press 1 for yes/2 for NO? 


```

Results are directed to **Recursion_TOH_Analysis.ext** 

```
-------------------- Recursive Run Times -----------------
| Number Of Rings | Execution Time   |
|        10 rings  |    17 ms         |
|        9 rings  |    6 ms         |
|        8 rings  |    5 ms         |
|        7 rings  |    3 ms         |
|        6 rings  |    3 ms         |
|        5 rings  |    1 ms         |
|        4 rings  |    1 ms         |
|        3 rings  |    1 ms         |
|        2 rings  |    1 ms         |
|        1 rings  |    3 ms         |
-------------------- Recursive Memory Usage -----------------
| Number Of Rings | Usage           |
|        10 rings  |    851 MB         |
|        9 rings  |    851 MB         |
|        8 rings  |    851 MB         |
|        7 rings  |    851 MB         |
|        6 rings  |    851 MB         |
|        5 rings  |    851 MB         |
|        4 rings  |    851 MB         |
|        3 rings  |    851 MB         |
|        2 rings  |    851 MB         |
|        1 rings  |    851 MB         |
```

### Documentation

Refer to javadocs, in the doc folder for more information.

### Run-time Graphs

![Run Time Comparison](/Run Time.png)

![Memory USage](/Memory Usage.png)

## Team

> Solo Project




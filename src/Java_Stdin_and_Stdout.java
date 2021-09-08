/**
 * Created by Shuhua Song
 */

/* Java Stdin and Stdout I
Most HackerRank challenges require you to read input from stdin (standard input) and write output to stdout (standard output).
One popular way to read input from stdin is by using the Scanner class and specifying the Input Stream as System.in. For example:
(1)
                    Scanner scanner = new Scanner(System.in);
                    String myString = scanner.next();
                    int myInt = scanner.nextInt();
                    scanner.close();
                    System.out.println("myString is: " + myString);
                    System.out.println("myInt is: " + myInt);

The code above creates a Scanner object named scanner and uses it to read a String and an int. It then closes the Scanner object because
there is no more input to read, and prints to stdout using System.out.println(String). So, if our input is:
Hi 5
Our code will print:
myString is: Hi
myInt is: 5
Alternatively, you can use the BufferedReader class.
Task
In this challenge, you must read 3 integers from stdin and then print them to stdout. Each integer must be printed on a new line. To make
the problem a little easier, a portion of the code is provided for you in the editor below.
Input Format
There are 3 lines of input, and each line contains a single integer.
(2)
                    Scanner scan = new Scanner(System.in);
                    int a = scan.nextInt();
                    // Complete this line
                    // Complete this line
                    int b = scan.nextInt();
                    int c = scan.nextInt();
                    scan.close();

                    System.out.println(a);
                    // Complete this line
                    // Complete this line
                    System.out.println(b);
                    System.out.println(c);


(3) Your program should read lines from standard input. Each line contains a list of numbers and the number k,

                       String input = "1, 2, 3, 4, 5;2";
                      input = input.trim();
                      String[] strs = input.split(";");
                      System.out.println(strs[0] + " " + strs[1]);

                      List<Integer> nums = new ArrayList<>();
                      for(String s : strs[0].split(",")){
                        nums.add(Integer.parseInt(s.trim()));
                      }

                      int k = Integer.parseInt(strs[1]);

(4) BufferReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Java_Stdin_and_Stdout {
    public static void main(String[] args) throws IOException {
          //Scanner scanner = new Scanner(System.in);
          //String input = scanner.nextLine();
          String input = "1, 2, 3, 4, 5;2";
          input = input.trim();
          String[] strs = input.split(";");
          System.out.println(strs[0] + " " + strs[1]);

          List<Integer> nums = new ArrayList<>();
          for(String s : strs[0].split(",")){
            nums.add(Integer.parseInt(s.trim()));
          }

          int k = Integer.parseInt(strs[1]);
          System.out.println(k);
          for(int a : nums){
              System.out.print(a + " ");
          }



   }
}


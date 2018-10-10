import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
     int minSwap = 0;
     int hp =0 ;
     int postion = arr.length; 

        while(postion > 0){
            //check each number and swap if the no muched
            if(arr[postion-1] == postion){
                // go to the next postion becaus the postion did not changed
                postion--;
            }else {
                // itterate and find where the number is and check the second number

                // find the postion 
                   hp = postion;
                  int brk = 1;

                while(hp > 0 && brk != 0){
                    if(arr[hp-1] == postion){
                        // swap
                        int temp = arr[postion-1];
                        arr[postion-1] = arr[hp-1];
                        arr[hp-1] = temp;
                        brk = 0;
                    }else{
                        hp--;
                    }                    
                }               
                // count the swap 
                minSwap++;
                // postion decrement
                postion--;
            }
            
        }

      return minSwap;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

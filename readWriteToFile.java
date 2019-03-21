/*
Angelu Ferdinand A. Garcia
BSCS - 1
CC12 - A
Mr Lagrosas
3/22/19
Reads file with integers as input, then outputs to a new file in sorted manner.
 */

import java.io.*;
import java.util.Scanner;

public class readWriteToFile
{
    public static void main(String[] args) throws IOException {
            int[] arr = new int[1];

            FileWriter outputFile = null;

            Scanner inputFile = null;


            sLinkedList list = new sLinkedList();

        try {
            //Scanner reads from BufferedReader that reads from FileReader
            inputFile = new Scanner(new File("input.txt"));
            outputFile = new FileWriter("output.txt");
            //Reads line by line
            while (inputFile.hasNextInt())
            {
                list.insertTail(inputFile.nextInt());
            }
            /**
             * Note: use list.next to traverse
             */
            //sort the contents
            arr = list.sortedList(arr);
            //write array to output.txt
            for (int ctr = 0; ctr<arr.length; ctr ++)
            {
                outputFile.write(arr[ctr]+"\n");
            }
        }

        finally
        {
            inputFile.close();
            outputFile.close();
        }


    }
}

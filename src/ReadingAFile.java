import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ReadingAFile {
    public static void main(String[] args) throws IOException {
        /*
        Output sum of all numbers in the file
         */
        /*
        Scanner scanner = new Scanner(System.in);
        String fileToRead = scanner.nextLine();
        File f = new File(fileToRead);
        /*
        //Output the sum of numbers in a file
        int sum = 0;
        try (Scanner scan = new Scanner(f)){

            // Reading the file line by line
            while (scan.hasNext()) {
                sum += scan.nextInt();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(sum);
        */
        /*
        // Look for the greatest number in the file
        File file = new File("src/dataset_91022.txt");
        int number = 0;
        try (Scanner scan = new Scanner(file)){

            // Reading the file line by line
            while (scan.hasNext()) {
                int num = scan.nextInt();
                if (num >= 9999) {
                   number++;
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(number);
        */
        // Count the even numbers ( explicit from 0 and last number)

        File f = new File("src/dataset_91065.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            int count = 0;
            String str;
            while ((str = br.readLine()) != null) {
                int value = Integer.parseInt(str);
                if (value == 0) {
                    break;
                } else if ((value & 1) == 0) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Scanner scanner1 = new Scanner(new File("test1.txt"));
             Scanner scanner2 = new Scanner(new File("test2.txt"))) {
            // some code
        }


        Reader reader = new FileReader("file.txt");
        try (reader) {
            // some code
        }
    }


}

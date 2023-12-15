import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class helper {
    public static void main(String[] args) {
        String inputFileName = "a.txt"; // Replace with your input file name
        String outputFileName = "output.txt"; // Replace with your output file name

        try (Scanner scanner = new Scanner(new File(inputFileName));
             PrintWriter writer = new PrintWriter(new File(outputFileName))) {

            // Read lines from the input file and write them to the output file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] things = line.split(" - ");
                writer.println("list.add(FlashCard(\""+things[0]+"\", \"" +things[1] + "\"))" );
            }

            System.out.println("File copy successful!");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

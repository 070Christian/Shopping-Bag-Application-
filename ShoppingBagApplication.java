import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ShoppingBagApplication {
    public static void main(String[] args) {
        // Creating bag object from my ShoppingBag class
        ShoppingBag bag = new ShoppingBag(7);
        
        //Instance variables for errors, items, and lines 
        int errorCount = 0;
        int itemCount = 0;
        int lineCounter = 0;
        
        //Reading from file 
        try (BufferedReader br = new BufferedReader(new FileReader("src/Lab 1 Input File.txt"))) {
            // Creating new file to record the output
            File file = new File("Lab 1 Output File.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file); 
            PrintWriter writer = new PrintWriter(fileWriter);
            
            //Loop while the file has contents 
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split(" ");
                    
                    //Checking if the file has an int followed by a double
                    if (parts.length == 2) {
                        int quantity = Integer.parseInt(parts[0]);
                        double price = Double.parseDouble(parts[1]);
                        bag.buy(quantity, price);
                        itemCount += quantity;
                        lineCounter++;
                        
                        //Writing the current amount of items and total current cost 
                        writer.println(lineCounter + ".");
                        writer.println("Current Amount of Items: " + itemCount);
                        writer.printf("Total Current Cost: $%.2f%n", bag.TotalCost());
                        writer.println();
                        
                        //Writing an invalid input entered 
                    }
                    else {
                        writer.println("Invalid input format for line:\"" + line+ "\"");
                        writer.println();
                        errorCount++;
                    }
                } catch (NumberFormatException e) {
                    writer.println("Invalid input format for line: \"" + line+ "\"");
                    writer.println();
                    errorCount++;
                }
            }

            //Writing summary of Shopping bag and total errors in file 
            writer.println(bag.toString());
            writer.println("Total errors: " + errorCount);
            writer.close();
            System.out.println("Output written to Lab 1 Output File.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StockIO {
    private String fileName;

    public StockIO() {
        this.fileName = "unknown";
    }

    public StockIO(String fileName) {
        this.fileName = fileName;
    }

    public void saveData(ArrayList<Stock> data) {
        try {
            BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));

            for (Stock stock : data) {
                outFile.write(stock.getCompanyName() + ',');  // adding commas to separate each aspect of the object to later rebuild object
                //on the following lines the numbers need to be converted over to
                outFile.write("" + stock.getNumberOfShares() + ',');
                outFile.write("" + stock.getPurchasePrice() + ',');
                outFile.write("" + stock.getCurrentPrice());  // End of object, no comma required
                outFile.newLine();     // drop to next line
            }

            outFile.close();// close the file so it actually writes and is not stuck in the buffer
        }
        catch(IOException ex)   // catch and display any writing errors
        {
            System.out.println("\nError. Unable to write to the file: " + ex.getMessage());
        }
    }

    public ArrayList<Stock> getData( )
    {
        // create the arraylist that can work with Stock objects
        ArrayList<Stock> data = new ArrayList<>();

        try
        {
            // create a connection to the file and create a tokenizer
            BufferedReader inFile = new BufferedReader( new FileReader(fileName) );

            // get the first line in the file
            String inputLine = inFile.readLine();

            // read the file line by line until we get nothing (null)
            while ( inputLine != null )
            {
                // break the line into parts based on commas -- IBM,10,150,220
                StringTokenizer tokens = new StringTokenizer(inputLine, ",");
                String company = tokens.nextToken();
                int shares = Integer.parseInt(tokens.nextToken());
                double pPrice = Double.parseDouble(tokens.nextToken());
                double cPrice = Double.parseDouble(tokens.nextToken());

                // create a Stock object and add it to the arraylist
                Stock stk = new Stock(company, shares, pPrice, cPrice);
                data.add(stk);

                // read the next line in the file
                inputLine = inFile.readLine();
            }

            // close the file
            inFile.close();
        }
        catch(IOException ex)   // catch any writing errors
        {
            System.out.println("\nError. Unable to read from the file: " + ex.getMessage());
        }

        // return the arraylist
        return data;
    }
}

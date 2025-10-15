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

    public ArrayList<Stock> loadData(String fileName) throws IOException {
        ArrayList<Stock> stockData = new ArrayList<>();
        try {
            BufferedReader inFile = new BufferedReader(new FileReader(fileName));
            String inputLine = inFile.readLine();

            while (inputLine != null) {
                StringTokenizer tokens = new StringTokenizer(inputLine, ",");
                String companyName = tokens.nextToken();
                int numberOfShares = Integer.parseInt(tokens.nextToken());
                double purchasePrice = Double.parseDouble(tokens.nextToken());
                double currentPrice = Double.parseDouble(tokens.nextToken());
                stockData.add(new Stock(companyName, numberOfShares, purchasePrice, currentPrice));
                inputLine = inFile.readLine();
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new IOException(e);
        }
        return stockData;
    }
}

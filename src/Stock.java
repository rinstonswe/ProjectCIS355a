public class Stock {
    // create your attributes here
    private String companyName;
    private int numberOfShares;
    private double purchasePrice;
    private double currentPrice;
    // create your constructors here
    public Stock() {
        this.companyName = "Unknown";
        this.numberOfShares = 0;
        this.purchasePrice = 0;
        this.currentPrice = 0;
    }

    public Stock(String companyName, int numberOfShares, double purchasePrice, double currentPrice) {
        this.companyName = companyName;
        this.numberOfShares = numberOfShares;
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
    }
    // create your behaviors here

    // create your getters and setters here
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }
    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
    public double getCurrentPrice() {
        return currentPrice;
    }
}
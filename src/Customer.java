public class Customer {
    private int customerID;
    private String name;
    private String address;
    private String yardType;
    private double length;
    private double width;
    private double totalCost;

    public Customer() {
        this.customerID = 00000;
        this.name = "";
        this.address = "";
        this.yardType = "";
        this.length = 0;
        this.width = 0;
        this.totalCost = 0;
    }

    public Customer(int customerID, String name, String address, String yardType, double length, double width, double totalCost) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.yardType = yardType;
        this.length = length;
        this.width = width;
        this.totalCost = totalCost;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public int getCustomerID() {
        return customerID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAddress(String address) {this.address = address;    }
    public String getAddress() {
        return address;
    }

    public void setYardType(String yardType) {this.yardType = yardType;}
    public String getYardType() {
        return yardType;
    }

    public void setLength(double length) {this.length = length;}
    public double getLength() {
        return length;
    }

    public void setWidth(double width) {this.width = width;}
    public double getWidth() {return width;}

    public void setTotalCost(double totalCost) {this.totalCost = totalCost;}
    public double getTotalCost() {return totalCost;}

    public String toString(){
        return "Customer{" + "customerID=" + customerID + ", name=" + name + ", address=" + address + ", yardType=" + yardType + ", length=" + length + ", width=" + width + ", totalCost=" + totalCost + "}";
    }


}

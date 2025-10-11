import java.text.DecimalFormat;

public class Burger {
    //Variables
    private String type;
    private boolean cheese;
    private boolean bacon;
    private boolean meal;
    private int quantity;
    //Constants
    private final double SINGLE_COST = 3.50;
    private final double DOUBLE_COST = 4.75;
    private final double CHEESE_COST = 0.50;
    private final double BACON_COST = 1.25;
    private final double MEAL_COST = 4.00;

    public Burger(){
        type = "Single";
        cheese = false;
        bacon = false;
        meal = false;
        quantity = 0;
    }
    //getters and setters
    public String getType(){
        return type;
    }
    public void setType(String newType){
        this.type = newType;
    }
    public boolean getCheese(){
        return cheese;
    }
    public void setCheese(boolean newCheese){
        this.cheese = newCheese;
    }
    public boolean getBacon(){
        return bacon;
    }
    public void setBacon(boolean newBacon){
        this.bacon = newBacon;
    }
    public boolean getMeal(){
        return meal;
    }
    public void setMeal(boolean newMeal){
        this.meal = newMeal;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }
    //Methods
    public double calculateItemCost(){
        double cost = 0.0;
        if ("Single".equalsIgnoreCase(type)){
            cost = SINGLE_COST;
        }
        else if ("Double".equals(type)) {
            cost = DOUBLE_COST;
        }

        if (cheese){
            cost += CHEESE_COST;
        }

        if (bacon){
            cost += BACON_COST;
        }
        if (meal){
            cost += MEAL_COST;
        }
        return cost;
    }

    public double calculateTotalCost(){
        return (calculateItemCost() * quantity);
    }

    public String toString(){
        String order = "";

        order = order + quantity;

        if  (type.equals("Single")){
            order = order + " Single";
        }
        else if (type.equals("Double")){
            order = order + " Double";
        }
        if (cheese){
            order = order + ", cheese";
        }
        if (bacon){
            order = order + ", bacon";
        }
        if (meal){
            order = order + ", meal";
        }
        order = order + " at " + Main.fmt.format(calculateItemCost()) + " each\n";

        return order;
    }




}

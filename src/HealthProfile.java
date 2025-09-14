public class HealthProfile {
    private String name;
    private int age;
    private double weight;
    private int height;


    //getters and setters
    //name
    public String getName(){
        return name;
    }
    public void setName(String newName){
        this.name=newName;
    }
    //age
    public int getAge(){
        return age;
    }
    public void setAge(int newAge){
        this.age=newAge;
    }
    //weight
    public double getWeight(){
        return weight;
    }
    public void setWeight(double newWeight){
        this.weight=newWeight;
    }
    //height, must take as two variables feet and inches and convert to just inches
    public int getHeight() {
        return height;
    }
    public void setHeight(int feet, int inches){
        this.height=(feet*12)+inches;
    }

    //Methods
    //BMI
    public double calculateBMI(){
        double bmi = (weight*703)/(height*height);
        return bmi;
    }
    //BMI Category
    public String calculateCategory(){
        double bmi = calculateBMI();
        if (bmi<18.5){
            return "Underweight";
        }
        else if (bmi<25){
            return "Normal";
        }
        else if (bmi<30){
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }
    //Heart Rate
    public int calculateMaxHR(){
        return (220-age);
    }
}
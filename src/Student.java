public class Student {
    private int studentID;
    private String name;
    private double test1;
    private double test2;
    private double test3;

    public Student() {
        this.studentID = 00000;
        this.name = "";
        this.test1 = 0;
        this.test2 = 0;
        this.test3 = 0;
    }

    public Student(int studentID, String name, double test1, double test2, double test3) {
        this.studentID = studentID;
        this.name = name;
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
    }

    public void setID(int studentID) {
        this.studentID = studentID;
    }
    public int getID() {
        return studentID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setTest1(double test1) {
        this.test1 = test1;
    }
    public double getTest1() {
        return test1;
    }

    public void setTest2(double test2) {
        this.test2 = test2;
    }
    public double getTest2() {
        return test2;
    }

    public void setTest3(double test3) {
        this.test3 = test3;
    }
    public double getTest3() {
        return test3;
    }

    public String toString(){
        return this.name + ", " + this.studentID + ", " + this.test1 + ", " + this.test2 + ", " + this.test3;
    }

    public double calculateAverage() {
        return (test1 + test2 + test3) / 3.0;
    }

    public String calculateLetterGrade() {
        String letterGrade;
        if (calculateAverage() >= 90.0) {
            letterGrade = "A";
        }
        else if (calculateAverage() >= 80.0) {
            letterGrade = "B";
        }
        else if (calculateAverage() >= 70.0) {
            letterGrade = "C";
        }
        else if (calculateAverage() >= 60.0) {
            letterGrade = "D";
        }
        else {
            letterGrade = "F";
        }
        return letterGrade;
    }
}

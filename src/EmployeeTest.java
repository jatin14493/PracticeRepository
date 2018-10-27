class Employee{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    Employee(int age, String name){
        this.age = age;
        this.name =name;
    }
}


class Student extends Employee{
    int age;
    String name;


    public Student(int age, String name) {
        super(age, name);
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int newVal){
        this.age = newVal;
    }

    public String getName(){
        return name;
    }
}


public class EmployeeTest {

    public static void main(String[] args) {
        Employee e = new Employee(1,"Jatin");
        Employee e1 = new Employee(2 , "Avi");

        Student s = new Student(4,"xyz");
        Employee e3 = (Student) s;
        System.out.println(e3.getAge());
        s.setAge(10);
        System.out.println(e3.getAge());

    }
}





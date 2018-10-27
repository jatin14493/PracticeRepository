package Sapient;

import java.util.TreeMap;


class Employee implements Comparable{
    String name;
    int age;

    public Employee(){

    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString(){
        return "name :" + this.name + " | " + " age : " + this.age;
    }

    @Override
    public int compareTo(Object o) {
        Employee e = (Employee)o;
        return this.age - ((Employee) o).age;
    }
}

public class TreeMapCustomDemo {
    public static void main(String[] args) {

        Employee e1 = new Employee();
        e1.setName("Jatin");
        e1.setAge(25);

        Employee e2 = new Employee();
        e2.setName("Jatin");
        e2.setAge(25);


        TreeMap<Employee,String> tm = new TreeMap<Employee, String>();
        tm.put(e1, "One");
        tm.put(e2, "Two");

        tm.entrySet().forEach(entry -> {
            System.out.println("key :" + entry.getKey() + "value :" + entry.getValue()) ;
        });

    }
}

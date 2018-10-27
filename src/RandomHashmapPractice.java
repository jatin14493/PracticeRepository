import java.util.HashMap;

class Employee1{
    int age;
    String name;

    Employee1(String name, int age){
        this.name = name;
        this.age  = age;
    }


//    @Override
//    public int hashCode() {
//        return this.age*31;
//    }

    @Override
    public boolean equals(Object object) {

        if (object == this) {
            return true;
        }

        if(object.getClass()!=this.getClass())
            return false;



        Employee1 e = (Employee1)object;

        return this.name.equalsIgnoreCase(e.name) && (this.age== e.age);

    }
}

public class RandomHashmapPractice {

    public static void main(String[] args) {
        Employee1 e1 = new Employee1("Jatin",1);
        Employee1 e2 = new Employee1("Jatin",1);
        Employee1 e3 = new Employee1("Jatin",1);

        HashMap<Employee1, String> hs = new HashMap<>();
        hs.put(e1,"ABC");
        hs.put(e2,"CDE");
        hs.put(e3,"ABCD");

        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
        System.out.println(e3.hashCode());

        System.out.println(hs.get(e1));
        System.out.println(hs.get(e2));
        System.out.println(hs.get(e3));

    }


    //Case1 :

    // Hashcode method overridden and not the
}

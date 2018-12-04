

final class Person{

    private final String name;
    private final String fname;
    private final String lname;
    private final Integer age;
    private final String poi;
    private final Address address;

    public Person(String name, String fname, String lname, Integer age, String poi, Address address) {
        this.name = name;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.poi = poi;
        //this.address = address; // Not Immutable

        Address a = new Address();
        a.setCity(address.getCity());
        a.setDistrict(address.getDistrict());
        a.setHouseName(address.getHouseName());
        a.setHouseNo(address.getHouseNo());
        a.setPincode(address.getPincode());
        a.setState(address.getState());
        this.address = a;
    }




    public String getName() {
        return name;
    }


    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public Integer getAge() {
        return age;
    }

    public String getPoi() {
        return poi;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                ", poi='" + poi + '\'' +
                ", address=" + address +
                '}';
    }
}

class Address implements Cloneable{
    String houseName;
    Integer houseNo;
    String city;
    String district;
    String state;
    Integer pincode;

    public Address(String houseName, Integer houseNo, String city, String district, String state, Integer pincode) {
        this.houseName = houseName;
        this.houseNo = houseNo;
        this.city = city;
        this.district = district;
        this.state = state;
        this.pincode = pincode;
    }

    public Address() {

    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public Integer getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(Integer houseNo) {
        this.houseNo = houseNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseName='" + houseName + '\'' +
                ", houseNo=" + houseNo +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}

public class Immutable {
    public static void main(String[] args) {

    Address address = new Address("abc villa", 14, "Delhi" , "East Delhi", "Delhi",110051);
    Person p = new Person("Jatin Mahajan" , "Jatin", "Mahajan" , 25, "PAN",address);
        System.out.println(p);

        address.setCity("Uttar Pradesh");
        System.out.println(p);

    }


}

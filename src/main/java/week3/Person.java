package week3;

public class Person {
    private String name;
    private String city; //

    Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {   return this.name;}
    public String getCity() {   return this.city;}

    @Override
    public String toString() {
        return "이름 : " + this.name + "  발령지 : " + this.city;
    }
}

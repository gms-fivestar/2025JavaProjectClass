package week3;

public class Soda {
    String name;
    int price;
    static int count = 0;
    static int totalPrice = 0;

    Soda(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "   " + Integer.toString(price) + "원";
    }
}

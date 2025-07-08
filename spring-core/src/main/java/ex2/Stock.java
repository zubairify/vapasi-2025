package ex2;

public class Stock {
    public Stock() {
        System.out.println("Stock constructor");
    }

    public static Stock getStock() {
        System.out.println("Stock factory method");
        return new Stock();
    }
}

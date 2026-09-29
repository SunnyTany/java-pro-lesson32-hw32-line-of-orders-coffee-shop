package coffee;

public class Order {
    private final int number;
    private final String clientName;

    public Order(int number, String clientName) {
        this.number = number;
        this.clientName = clientName;
    }

    public int getNumber() {
        return number;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public String toString() {
        return "Order{" + "number=" + number + ", clientName='" + clientName + '\'' + '}';
    }
}
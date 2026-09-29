package coffee;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();

        // 1. Додавання замовлень
        board.add("Alen");
        board.add("Yoda");
        board.add("Obi-van");
        board.add("John Snow");

        // Поточний стан черги
        board.draw();

        // 2. Системна видача першого замовлення (Alen - №1)
        board.deliver();

        // 3. Видача замовлення не по черзі (John Snow - №4 готовий раніше)
        board.deliver(4);

        // Кінцевий стан черги
        board.draw();

        // 4. Демонстрація логування помилки із винятком (Exception)
        try {
            board.add(""); // Передаємо некоректне ім'я для виклику помилки
        } catch (IllegalArgumentException e) {
            // Оброблено всередині методу add із записом stacktrace в лог
        }
    }
}
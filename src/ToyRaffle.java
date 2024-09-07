import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyRaffle {
    private PriorityQueue<Toy> toyQueue;
    private Random random;

    public ToyRaffle() {
        toyQueue = new PriorityQueue<>((toy1, toy2) -> toy2.getWeight() - toy1.getWeight());
        random = new Random();
    }

    // Метод добавления игрушек
    public void addToy(Toy toy) {
        toyQueue.add(toy);
    }

    // Метод запуска розыгрыша
    public void startRaffle() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("output/results.txt", true))) {
            writer.println();
            for (int i = 0; i < 10; i++) {
                if (toyQueue.isEmpty()) {
                    writer.println("Нет игрушек для розыгрыша.");
                    break;
                }
                Toy toy = toyQueue.poll();
                if (random.nextInt(100) < toy.getWeight()) {
                    writer.println("Победитель получает игрушку: " + toy.getName());
                } else {
                    writer.println("Игрушка не выпала: " + toy.getName());
                }
                writer.println(); // добавляем пустую строку после каждого запроса
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
    
}

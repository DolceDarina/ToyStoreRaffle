public class Main {
    public static void main(String[] args) {
        // Проверка наличия входных параметров
        if (args.length < 3) {
            System.out.println("Неверное количество аргументов. Ожидается: id name weight");
            return;
        }

        ToyRaffle raffle = new ToyRaffle();
        
        // Преобразование аргументов в игрушки и добавление в розыгрыш
        for (int i = 0; i < args.length; i += 3) {
            int id = Integer.parseInt(args[i]);
            String name = args[i + 1];
            int weight = Integer.parseInt(args[i + 2]);
            raffle.addToy(new Toy(id, name, weight));
        }

        // Запуск розыгрыша
        raffle.startRaffle();
    }
}

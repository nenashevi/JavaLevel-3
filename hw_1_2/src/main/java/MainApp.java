import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainApp {
    public static final int CARS_NUMBER = 4;
    public static final int NUMBER_CARS_IN_TUNNEL = 2;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_NUMBER];
        CyclicBarrier cb = new CyclicBarrier(CARS_NUMBER);
        Semaphore smp = new Semaphore(NUMBER_CARS_IN_TUNNEL);
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), CARS_NUMBER, cb, smp);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

    }

}

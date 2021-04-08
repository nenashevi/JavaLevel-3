import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CAR_PLACES = 1;
    private static int CARS_COUNT;
    public static int CARS_NUMBER;
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier cyclicBarrier;
    private Semaphore semaphore;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, int CARS_NUMBER, CyclicBarrier cb, Semaphore smp) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cyclicBarrier = cb;
        this.semaphore = smp;
        this.CARS_NUMBER = CARS_NUMBER;
    }
    public void printPlaces () {
        int tempCarPlaces = incrementCarPlaces();
        if (tempCarPlaces == CARS_NUMBER) {
            System.out.println(this.name + " пришел " + tempCarPlaces + " - м");
            System.out.println("Гонка завершена!!!");
            return;
        } else {
            System.out.println(this.name + " пришел " + tempCarPlaces + " - м");
            return;
        }

    }
    public synchronized static int incrementCarPlaces () {
        int tempCarPlaces = CAR_PLACES;
        CAR_PLACES++;
        return tempCarPlaces;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            if (cyclicBarrier.getNumberWaiting() == CARS_NUMBER - 1) {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            }
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this, semaphore);
        }
        
        printPlaces();

    }
}


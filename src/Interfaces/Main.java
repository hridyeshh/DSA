package Interfaces;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
//        car.start();
//        car.stop();
//        car.acc();

        Media carmedia = new Car();
        car.stop();
        car.sound();

        Media car2 = new CDplayer();
        car2.sound();

        engine car3 = new PowerEngine();
        car3.start();

    }
}

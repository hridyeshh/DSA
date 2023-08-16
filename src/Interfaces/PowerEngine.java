package Interfaces;

public class PowerEngine implements engine, Media{
    @Override
    public void brake() {

    }

    @Override
    public void start() {
        System.out.println("Power engine starts");
    }

    @Override
    public void stop() {
        System.out.println("Power engine stops");
    }

    @Override
    public void sound() {
        System.out.println("Music in power");
    }

    @Override
    public void acc() {
        System.out.println("Power engine accelerate");
    }
}
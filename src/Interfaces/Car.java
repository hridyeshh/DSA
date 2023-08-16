package Interfaces;

class Car implements engine, brake, Media{
    @Override
    public void brake() {
        System.out.println("I brake like a normal car");

    }

    @Override
    public void start() {
        System.out.println("I start like a normal car");
    }

    @Override
    public void stop() {
        System.out.println("I stop the engine like a normal car");

    }

    @Override
    public void sound() {
        System.out.println("I play the best");
    }

    @Override
    public void acc() {
        System.out.println("I accelerate like a normal car");

    }

    @Override
    public int fun(int num) {
        return 0;
    }
}

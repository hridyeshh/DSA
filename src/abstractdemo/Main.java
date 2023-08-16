package abstractdemo;

public class Main {
    public static void main(String[] args) {
        Son son = new Son();
        son.career("Entrepreneur");
    }

    protected void fun(int num) {
        System.out.println(num/4);
    }
}

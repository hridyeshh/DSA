package exceptionhandling;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try{
            String name = "Hridyesh";
            if(name.equals("Hridyesh")){
                throw new MyException("Name is Hridyesh");
            }
        }
        catch (MyException e){ // will call this when there's an arithmetic exception
            System.out.println(e.getMessage());
        } catch(Exception e){ // will call this when there's an exception
            // giving an error because Exception contain all the exceptions,
            // and we declared for 'exception' earlier so for every exception the
            // same message will be printed
            System.out.println("normal expression");
        } finally{
            System.out.println("This will be printed for sure");
        }
    }
    static int divide(int a, int b) throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException("Please don't divide by 0");
        }
        return a/b;
    }
}

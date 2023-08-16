package Interfaces.nested;

public class nested {
    public class A{
        public interface NestedInterface{
            boolean isOdd(int num);
        }
    }
    static class B implements A.NestedInterface {

        @Override
        public boolean isOdd(int num) {
            return ((num&1)==1);
        }
    }
}

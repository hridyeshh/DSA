package Practice;

public class Mathematics {
    public static boolean isPrime(int x) {
        if(x<=1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
    // false in array means the number is prime
    public static void sieve(int n, boolean[]primes){
        for (int i = 2; i <Math.sqrt(n); i++) {
            if(!primes[i]){
                for (int j = 2*i; j <=n ; j+=i) {
                    primes[j] =true;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if(!primes[i]){
                System.out.print(i+" ");
            }
        }
    }
    public static double sqrt(int number, int places){
        int  s = 0;
        int e = number;
        double root = 0.0;
        while(s<=e){
            int m = (s + e)/2;

            if(m*m==number){
                return m;
            }
            if(m*m>number){
                e = m-1;
            }
            else{
                s = m+1;
            }
            double increment = 0.1;
            for (int i = 0; i < places; i++) {
                while(root*root<=number){
                    root+=increment;
                }
                root-=increment;
                increment/=10;
            }
        }
        return root;
    }
    public static double sqrtNewton(double n){
        double x = n;
        double root;
        while(true){
            root = 0.5*(x+(n/x));

            if(Math.abs(root-x)<1){
                break;
            }
            x = root;
        }
        return root;
    }
    public static void factors(int n){
        for (int i = 1; i <= n; i++) {
            if(n%i==0){
                System.out.print(i+" ");
            }
        }
    }

    public static void OptimisedFactor(int n){
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if(n/i==i){
                    System.out.print(i);
                }
            } else {
                System.out.print(i + " "+n/i);
            }
        }
    }
    public static int gcd(int a, int b){
        if(a==0){
            return b;

        }

        return gcd(b%a,a);
    }
    public int binExpRec(int a, int b){
        if(b==0) return 1;
        int res = binExpRec(a,b/2);
        if((b&1)==1){
            return a*res*res;
        }
        return res*res;
    }
    public static int lcm(int a, int b){
        return (a*b)/gcd(a,b);

    }
    public static void main(String[] args) {
//        int n = 60 ;
//        System.out.println(isPrime(n));
//        for (int i = 0; i <n; i++) {
//            System.out.println(i +" "+ isPrime(i));
//        }
//        boolean[] prime = new boolean[n+1];
//        sieve(n,prime);
//        System.out.println(sqrt(35,2));
//        System.out.println(sqrtNewton(40));

////        OptimisedFactor(36);
//        System.out.println(gcd(4,9));
//        System.out.println(lcm(3,17));
//        System.out.println(Math.pow(2,3));

        System.out.println((2&1)==0);
    }
}

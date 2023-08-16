package Practice;
public class price {
    public static String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {

            if (i >= 0) carry += a.charAt(i--) - '0';
            if (j >= 0) carry += b.charAt(j--) - '0';
            s.append(carry % 2); // if both the string has the i(th) digit as 1 then
            // add 0 i.e sum%2 only
            carry /= 2;
        }
        if (carry != 0) s.append(carry);
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
    }
}

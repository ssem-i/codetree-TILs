import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        int m =sc.nextInt();
        System.out.println((n*m)/getGcd(n, m));
        
    }
    public static int getGcd(int n, int m) {
        if (m == 0) {
            return n;
        } 
    return getGcd(m, n % m);
    }
}
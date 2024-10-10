import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        System.out.println(gcd(n, m));
    }
    public static int gcd(int n, int m){
        if(n%m==0) return m;
        return gcd(m, n%m);
    }
}
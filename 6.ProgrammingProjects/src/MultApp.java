import java.util.Scanner;

public class MultApp {
    public static void main(String[] args) {
        int x = 6;//getInt("Enter X:");
        int y = 5;//getInt("Enter multiplier:");
        long ans = mult(x, y);
        System.out.println("The product " + x + " * " + y + " = " + ans);

        x = 7;
        y = 2;
        ans = power(x, y);
        System.out.println("The power " + x + " ^ " + y + " = " + ans);

    }
    //Computes x*y recursively
    public static long mult(int x, int y) {
        if (y == 1)
            return x;
        return x + mult(x, y-1);
    }
    //Computes x^y recursively
    public static long power(int x, int y) {
        if (y == 1)
            return x;
        return x * power(x, y-1);

    }
    public static int getInt(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextInt();
    }
}

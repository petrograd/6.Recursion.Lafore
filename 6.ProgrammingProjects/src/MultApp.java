import java.util.Scanner;

public class MultApp {
    public static void main(String[] args) {
        int x = getInt("Enter X:");
        int y = getInt("Enter multiplier:");
        System.out.println(mult(x, y));
    }
    public static long mult(int x, int y) {
        if (y == 1)
            return x;
        return x + mult(x, y-1);
    }
    public static int getInt(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextInt();
    }
}

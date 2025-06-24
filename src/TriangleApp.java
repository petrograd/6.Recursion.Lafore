import java.util.Scanner;

public class TriangleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int theNumber = scanner.nextInt();
        int theAnswer = triangle(theNumber);
        System.out.println("Triangle = " + theAnswer);
    }
    public static int triangle(int n){
        if (n == 1)
            return 1;
        else
            return n + triangle(n-1);
    }
}

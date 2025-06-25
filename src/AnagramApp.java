import java.util.Scanner;

public class AnagramApp {
    static int size;
    static int count;
    static char[] arrChar = new char[100];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String input = scanner.next();
        size = input.length();
        count = 0;
        for (int i = 0; i < size; i++) {
            arrChar[i] = input.charAt(i);
        }
        doAnagram(size);
    }
    public static void doAnagram(int newSize) {
        if (newSize == 1)
            return;
        for (int i = 0; i < newSize; i++) {
            doAnagram(newSize-1);
            if (newSize == 2)
                displayWord();
            rotate(newSize);
        }
    }
    public static void rotate(int newSize) {
        int j;
        int position = size-newSize;
        char temp = arrChar[position];
        for (j = position+1; j < size; j++)
            arrChar[j-1] = arrChar[j];
        arrChar[j-1] = temp;
    }
    public static void displayWord() {
        if (count < 99)
            System.out.print(" ");
        if (count < 9)
            System.out.print(" ");
        System.out.print(++count + " ");
        for (int i = 0; i < size; i++)
            System.out.print( arrChar[i]);
        System.out.print("   ");
        if (count%6 == 0)
            System.out.println("");
    }
}

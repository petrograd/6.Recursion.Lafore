package stacktriangle2;

import java.util.Scanner;

class StackX {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackX(int s) {
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }
    public void push(int p) {
        stackArray[++top] = p;
    }
    public int pop() {
        return stackArray[top--];
    }
    public int peek() {
        return stackArray[top];
    }
    public boolean isEmpty() {
        return top == -1;
    }
}
public class StackTriangle2App {
    static int theNumber;
    static int theAnswer;
    static StackX theStack;

    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        theNumber = getInt();
        stackTriangle();
        System.out.println("Triangle = " + theAnswer);
    }
    private static void stackTriangle() {
        theStack = new StackX(10000);
        theAnswer = 0;

        while (theNumber > 0) {
            theStack.push(theNumber);
            --theNumber;
        }
        while (!theStack.isEmpty()) {
            theAnswer += theStack.pop();
        }
    }
    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}

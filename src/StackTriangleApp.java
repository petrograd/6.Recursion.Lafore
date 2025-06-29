import java.util.Scanner;

class Params {
    public int n;
    public int returnAddress;
    public Params(int nn, int ra) {
        n = nn;
        returnAddress = ra;
    }
}
class StackX {
    private int maxSize;
    private Params[] stackArray;
    private int top;

    public StackX(int s) {
        maxSize = s;
        stackArray = new Params[maxSize];
        top = -1;
    }
    public void push(Params p) {
        stackArray[++top] = p;
    }
    public Params pop() {
        return stackArray[top--];
    }
    public Params peek() {
        return stackArray[top];
    }
}
public class StackTriangleApp {
    static int theNumber;
    static int theAnswer;
    static StackX theStack;
    static int codePart;
    static Params theseParams;

    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        recTriangle();
        System.out.println("Triangle=" + theAnswer);
    }

    private static void recTriangle() {
        theStack = new StackX(10000);
        codePart = 1;
        while (step() == false){

        }

    }

    private static boolean step() {
        switch(codePart) {
            case 1:
                theseParams = new Params(theNumber, 6);
                theStack.push(theseParams);
                codePart = 2;
                break;
            case 2:
                theseParams = theStack.peek();
                if (theseParams.n == 1) {
                    theAnswer = 1;
                    codePart = 5;
                } else
                    codePart = 3;
                break;
            case 3:
                Params newParams = new Params(theseParams.n - 1, 4);
                theStack.push(newParams);
                codePart = 2;
                break;
            case 4:
                theseParams = theStack.peek();
                theAnswer = theAnswer + theseParams.n;
                codePart = 5;
                break;
            case 5:
                theseParams = theStack.peek();
                codePart = theseParams.returnAddress; // 4 or 6
                theStack.pop();
                break;
            case 6:
                return true;
        }
        return false;
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}

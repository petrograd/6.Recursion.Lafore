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
}

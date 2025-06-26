class OrdArray {
    private long[] a;
    private int nElems;
    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }
    public int size() {
        return nElems;
    }
    public int find(long searchKey) {
        return recFind(searchKey, 0, nElems-1);
    }
    public int recFind(long searchKey, int lowerBound, int upperBound) {
        int curInd;
        curInd = lowerBound + (upperBound - lowerBound)/2;
        if (a[curInd] == searchKey)
            return curInd;
        else if(lowerBound > upperBound)
            return nElems;
        else {
            if (a[curInd] < searchKey)
                return recFind(searchKey, curInd + 1, upperBound);
            else
                return recFind(searchKey, lowerBound, curInd - 1);
        }
    }
    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] > value)
                break;
        }
        for (int i = nElems; i > j; i--) {
            a[i] = a[i-1];
        }
        a[j] = value;
        nElems++;
    }
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
}
public class BinarySearchApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr;
        arr = new OrdArray(maxSize);

        long val = 0;
        for (int i = 0; i < 20 ; i++) {
            val = (long)(Math.random()*100);
            arr.insert(val);

        }
        arr.display();

        int searchKey = (int)val;
        if (arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
        else System.out.println("Can't find " + searchKey);
    }
}

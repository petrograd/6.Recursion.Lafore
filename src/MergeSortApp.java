class DArray {
    private long[] theArray;
    private int nElems;
    public DArray(int max) {
        theArray = new long[max];
        nElems = 0;
    }
    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println();
    }
    public void mergeSort() {
        long[] workSpace = new long[nElems];
        recMergeSort(workSpace, 0, nElems-1);
    }
    private void recMergeSort(long[] workSpace, int lowerBound, int upperBound){
        System.out.println("Entering " + lowerBound + "-" + upperBound);
        if (lowerBound == upperBound) {
            System.out.println("Base-Case Return " + lowerBound + "-" + upperBound);
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            System.out.println("Will sort low half of " + lowerBound + "-" + upperBound);
            recMergeSort(workSpace, lowerBound, mid);
            System.out.println("Will sort high half of " + lowerBound + "-" + upperBound);
            recMergeSort(workSpace, mid+1, upperBound);
            System.out.println("Will merge halves into " + lowerBound + "-" + upperBound);
            merge(workSpace, lowerBound, mid+1, upperBound);
        }
        System.out.println("Return " + lowerBound + "-" + upperBound);
    }
    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int mid = highPtr-1;
        int lowerBound = lowPtr;
        int ind = 0;
        int cntElm = upperBound - lowerBound + 1;

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (theArray[lowPtr] < theArray[highPtr]) {
                workSpace[ind++] = theArray[lowPtr++];
            } else {
                workSpace[ind++] = theArray[highPtr++];
            }
        }
        while (lowPtr <= mid)
            workSpace[ind++] = theArray[lowPtr++];
        while (highPtr <= upperBound)
            workSpace[ind++] = theArray[highPtr++];

        if (cntElm >= 0) System.arraycopy(workSpace, 0, theArray, lowerBound + 0, cntElm);
    }
}
public class MergeSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        DArray arr;
        arr = new DArray(maxSize);

        for (int i = 0; i < 12; i++) {
            arr.insert((long)(Math.random()*100));
        }
        arr.display();
        arr.mergeSort();
        arr.display();
    }
}

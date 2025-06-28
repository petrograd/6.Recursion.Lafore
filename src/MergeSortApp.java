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
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid+1, upperBound);
            merge(workSpace, lowerBound, mid+1, upperBound);
        }
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
        for (int i = 0; i < cntElm; i++) {
            theArray[lowerBound + i] = workSpace[i];
        }
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

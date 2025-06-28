public class MergeApp {
    public static void main(String[] args) {
        int[] arrayA = {23, 47, 81, 95};
        int[] arrayB = {7, 14, 39, 55, 62, 74};
        int[] arrayC = new int[arrayA.length + arrayB.length];

        display(arrayA);
        display(arrayB);
        merge(arrayA, arrayB, arrayC);
        display(arrayC);
    }
    public static void merge(int[] arrayA, int[] arrayB, int[] arrayC) {
        int aDex = 0, bDex = 0, cDex = 0;
        while (aDex < arrayA.length && bDex < arrayB.length) {
            if (arrayA[aDex] < arrayB[bDex]) {
                arrayC[cDex++] = arrayA[aDex++];
            } else {
                arrayC[cDex++] = arrayB[bDex++];
            }
        }
        while (aDex < arrayA.length)
            arrayC[cDex++] = arrayA[aDex++];
        while (bDex < arrayB.length)
            arrayC[cDex++] = arrayB[bDex++];
    }
    public static void display(int[] theArray) {
        for (int i = 0; i < theArray.length; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println();
    }
}

package package1;

/**
 *
 * @author Alex
 */
public class Sorts {
    
    static int steps = 0;

    static int[] array, helper;

    public static void main(String[] args) {
        array = new int[50];
        helper = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println("| " + i + " |" + " | " + array[i] + " |");
        }
        //bubbleSort(array);
        //selectionSort(array);
        //insertionSort(array);
        mergeSort(0, array.length-1);
        System.out.println("Sorted:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("| " + i + " |" + " | " + array[i] + " |");
        }

        //System.out.println("No steps: " + steps);
    }

    public static void bubbleSort(int[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < array.length-1; i++) {
                steps++;
                if (array[i+1] < array[i]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    swapped = true;
                }
            }
        } while (swapped == true);
    }

    public static void selectionSort(int[] array) {
       int i,j;
       int iMin;
       for (j = 0; j < array.length-1; j++) {
           iMin = j;
           for (i = j+1; i < array.length; i++) {
               steps++;
               if (array[i] < array[iMin]) {
                   iMin = i;
               }
           }
           if (j != iMin) {
               int temp = array[j];
               array[j] = array[iMin];
               array[iMin] = temp;
           }
       }
    }

    public static void insertionSort(int[] array) {
       for (int i = 1; i < array.length; i++) {
           int j = i;
           int toInsert = array[i];
           while ((j > 0) && (array[j-1] > toInsert)) {
               steps++;
               array[j] = array[j-1];
               j--;
           }
           array[j] = toInsert;
       }
    }

    public static void mergeSort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(low, middle);
            mergeSort(middle+1, high);
            merge(low, middle, high);
        }
    }

    public static void merge(int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                array[k] = helper[i];
                i++;
            }
            else {
                array[k] = array[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = helper[i];
            k++;
            i++;
        }
    }
}

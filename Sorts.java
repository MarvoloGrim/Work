 *
 * @author Marvolo
 */
public class Sorts {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*100);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println("| " + i + " |" + " | " + array[i] + " |");
        }
        selectionSort(array);
        System.out.println("Sorted:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("| " + i + " |" + " | " + array[i] + " |");
        }
    }

    public static void bubbleSort(int[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]) {
                    swapped = true;
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
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
                if (array[i] < array[iMin]) {
                    iMin = i;
                }
            }
            if (iMin != j) {
                int temp = array[iMin];
                array[iMin] = array[j];
                array[j] = temp;
            }
        }
    }

    public static void insertionSort(int[] array) {

    }
}

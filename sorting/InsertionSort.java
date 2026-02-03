package sorting;

public class InsertionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Insertion Sort!!!");
    }
    public void insertionSort(int[] array) {
        int n = arr.length;
        for (int i = 0; i < n -1; i++){
            int minIndex = i;
            for(int j = i + 1; j < n; j++){
                if(a[j] < a[minIndex]){
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        }
    }


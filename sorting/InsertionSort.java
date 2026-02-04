package sorting;

public class InsertionSort implements Sorter {



    @Override
            public void sort(int[] input) {
        System.out.println("Insertion Sort!!!");
    }

   
    
    public void insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++){
            int current = array[i];
            int j = i-1;
            
            while (j >= 0 && array[j] > current){
                array[j + 1] = array[j];
                j--;
            }
                
            array[j + 1] = current;
        }
        }
    }


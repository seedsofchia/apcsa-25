package sorting;

public class InsertionSort implements Sorter {

    @Override
    public void sort(int[] input) {
        System.out.println("Insertion Sort!!!");

        for (int i = 1; i < input.length; i++) {
            int current = input[i];
            int j = i - 1;

            while (j >= 0 && input[j] > current) {
                input[j + 1] = input[j];
                j--;
            }

            input[j + 1] = current;
        }
    }
}
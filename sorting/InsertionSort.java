package sorting;

public class InsertionSort implements Sorter {
    private long steps = 0;

    
    public void sort(int[] input) {
        resetSteps();
        
        for (int i = 1; i < input.length; i++) {
            int current = input[i];
            int j = i - 1;

            while (j >= 0 && input[j] > current) {
                steps++; 
                input[j + 1] = input[j];
                j--;
            }
            steps++; 
            input[j + 1] = current;
        }
    }

    
    public long getSteps() {
        return steps;
    }

    
    public void resetSteps() {
        steps = 0;
    }
}
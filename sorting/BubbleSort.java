package sorting;

public class BubbleSort implements Sorter {
    private long steps = 0;

    public void sort(int[] input) {
        resetSteps();

        for (int outer = 0; outer < input.length - 1; outer++) {
   
            for (int inner = 0; inner < input.length - outer - 1; inner++) {
                steps++; 
                if (input[inner] > (input[inner + 1])) {
                    int temp = input[inner];
                    input[inner] = input[inner + 1];
                    input[inner + 1] = temp;
                    steps++; 
                }
            }
        }
    }

    
    public long getSteps() {
        return steps;
    }

    
    public void resetSteps() {
        steps = 0;
    }
}
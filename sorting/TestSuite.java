package sorting;



public class TestSuite {
  
    public static void run(int[] testInput, int loops) {
        boolean pass = true;

        System.out.println("Running test with input size: " + testInput.length);

        BubbleSort b = new BubbleSort();
        pass &= basicTest(b, testInput, loops);

        MergeSort m = new MergeSort();
        pass &= basicTest(m, testInput, loops);

        SelectionSort s = new SelectionSort();
        pass &= basicTest(s, testInput, loops);

        InsertionSort i = new InsertionSort();
        pass &= basicTest(i, testInput, loops);

        if (pass == true) {
            System.out.println("--- TEST PASSED! Congrats! ---");
        } else {
            System.out.println("--- TEST FAILED! :( ---");
        }
    }

    public static boolean basicTest(Sorter s, int[] unsorted, int loops) {
        boolean result = false;
        String className = s.getClass().getSimpleName();
        System.out.println("\n--- Testing: " + className + " ---");

        long totalSteps = 0;
       
        long startTime = System.nanoTime();
        for (int x = 0; x < loops; x++) {
       
            int[] test = unsorted.clone();
    
            s.sort(test);
         
            totalSteps += s.getSteps();
   
            result = checkResults(test, unsorted);
        }
        long endTime = System.nanoTime();

     
        double duration = (endTime - startTime) / 1000000000.0;
        double avgSteps = (double) totalSteps / loops;
        
    
        System.out.println(className + " took: " + duration + " seconds for " + loops + " loops.");
        System.out.println("Average steps per sort: " + String.format("%.0f", avgSteps));
        System.out.println("Total steps: " + totalSteps);

        return result;
    }

    public static boolean checkResults(int[] sorted, int[] unsorted) {
   
        if (sorted.length != unsorted.length) {
            System.out.println("Error! Mismatching lengths.");
            return false;
        }


        for (int i = 0; i < sorted.length - 1; i++) {
     
            if (sorted[i] > sorted[i + 1]) {
                System.out.println("Error! sorted[" + i + "] (" + sorted[i] + " > sorted[" + i + 1 + "] (" + sorted[i + 1] + ")");
                return false;
            }
        }
        return true;
    }
}
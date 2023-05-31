import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestLargeInput {
    static SortArray sortArray, sortArray2;
    static String path = "src\\tests\\array100.txt";
    static String path2 = "src\\tests\\positive100.txt";
    static Runtime runtime;
    @BeforeAll
    static void init(){
        sortArray = new SortArray(path);
        sortArray2 = new SortArray(path2);
    }
    static boolean checkSorting(int[] array){
        for (int i=0;i<array.length-1;i++){
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }
    //Not practical on n = 100K
    @Test
    void testSimpleSort(){
        runtime = Runtime.getRuntime();
        Long startTime = System.nanoTime();
        Long startSpace = runtime.totalMemory() - runtime.freeMemory();
        int result[] = sortArray.simpleSort(true);
        assertTrue(checkSorting(result));
        Long endTime = System.nanoTime();
        Long endSpace = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Selection Sort >> Size = " + result.length + " ,Time = " + (endTime-startTime)/1000 + " microsecond ,Space = " + (endSpace-startSpace)/1000 + "KB");
    }
    @Test
    void testEfficientSort(){
        runtime = Runtime.getRuntime();
        Long startTime = System.nanoTime();
        Long startSpace = runtime.totalMemory() - runtime.freeMemory();
        int result[] = sortArray.efficientSort(true);
        assertTrue(checkSorting(result));
        Long endTime = System.nanoTime();
        Long endSpace = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Merge Sort >> Size = " + result.length + " ,Time = " + (endTime-startTime)/1000 + " microsecond ,Space = " + (endSpace-startSpace)/1000 + "KB");
    }
    @Test
    void testNonComparisonSort(){
        runtime = Runtime.getRuntime();
        Long startTime = System.nanoTime();
        Long startSpace = runtime.freeMemory();
        int result[] = sortArray2.nonComparisonSort(true);
        assertTrue(checkSorting(result));
        Long endTime = System.nanoTime();
        Long endSpace = runtime.freeMemory();
        System.out.println("Counting Sort >> Size = " + result.length + " ,Time = " + (endTime-startTime)/1000 + " microsecond ,Space = " + (startSpace-endSpace)/1000 + "KB");
    }
    @Test
    void testHeapSort(){
        runtime = Runtime.getRuntime();
        Long startTime = System.nanoTime();
        Long startSpace = runtime.freeMemory();
        int result[] = sortArray.heapSort();
        assertTrue(checkSorting(result));
        Long endTime = System.nanoTime();
        Long endSpace = runtime.freeMemory();
        System.out.println("Heap Sort >> Size = " + result.length + " ,Time = " + (endTime-startTime)/1000 + " microsecond ,Space = " + (startSpace-endSpace)/1000 + "KB");
    }
}
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generator {
    private String filePath;
    private int numIntegers;
    private int minRange;
    private int maxRange;

    public Generator(String filePath, int numIntegers, int minRange, int maxRange) {
        this.filePath = filePath;
        this.numIntegers = numIntegers;
        this.minRange = minRange;
        this.maxRange = maxRange;
    }
    public Generator(String filePath, int numIntegers) {
        this.filePath = filePath;
        this.numIntegers = numIntegers;
        this.minRange = Integer.MIN_VALUE;
        this.maxRange = Integer.MAX_VALUE;
    }
    public void generateSortedFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Random random = new Random();
            int value = -1 * numIntegers;
            for (int i = 0; i < numIntegers; i++) {
                value += random.nextInt(4);
                writer.write(String.valueOf(value));
                if (i != numIntegers - 1) {
                    writer.write(",");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void generateReverseSortedFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Random random = new Random();
            int value = numIntegers;
            for (int i = 0; i < numIntegers; i++) {
                value -= random.nextInt(4);
                writer.write(String.valueOf(value));
                if (i != numIntegers - 1) {
                    writer.write(",");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void generateFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Random random = new Random();
            for (int i = 0; i < numIntegers; i++) {
                int value = random.nextInt(maxRange - minRange + 1) + minRange;
                writer.write(String.valueOf(value));

                if (i != numIntegers - 1) {
                    writer.write(",");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String positiveArrays[] = {"src\\positive1.txt", "src\\positive10.txt", "src\\positive100.txt"};
        String arrays[] = {"src\\array1.txt", "src\\array10.txt", "src\\array100.txt"};
        Generator positiveGenerators[] = new Generator[3];
        Generator generators[] = new Generator[3];
        for(int i = 0; i < 3; i++){
            positiveGenerators[i] = new Generator(positiveArrays[i].replace("src\\", "src\\tests\\"),  (int)(Math.pow(10,i)*1000),0,100000);
            positiveGenerators[i].generateFile();
        }
        for(int i = 0; i < 3; i++){
            generators[i] = new Generator(arrays[i].replace("src\\", "src\\tests\\"),  (int)(Math.pow(10,i)*1000),-100000,100000);
            generators[i].generateFile();
        }
//        String sortedArray = "src\\tests\\sorted10.txt";
//        String reversedArray = "src\\tests\\reversed10.txt";
//        String bestCounting = "src\\tests\\bestCounting.txt";
//        String avgCounting = "src\\tests\\avgCounting.txt";
//        String worstCounting = "src\\tests\\worstCounting.txt";
//        var generator1 = new Generator(sortedArray,10000);
//        var generator2 = new Generator(reversedArray,10000);
//        var generator3 = new Generator(bestCounting,10000, 0 , 500);
//        var generator4 = new Generator(avgCounting,10000, 0 , 8000);
//        var generator5 = new Generator(worstCounting,10000, 0 , 100000);
//        generator1.generateSortedFile();
//        generator2.generateReverseSortedFile();
//        generator3.generateFile();
//        generator4.generateFile();
//        generator5.generateFile();
    }
}
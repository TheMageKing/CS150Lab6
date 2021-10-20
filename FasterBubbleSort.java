
/**
 * This is a slightly improved bubble sort. It's double the speed!
 *
 * @author Calum McConnell
 * @version 0.0.1
 */
public class FasterBubbleSort implements ComplexityCount {
    // default-initializes to zero
    private long counter;

    private int[] data;

    public FasterBubbleSort(int[] dataToSort) {
        data = dataToSort;
    }

    public long result() {
        return counter;
    }

    public void incr() {
        counter++;
    }

    public void initialize() {
        counter = 0;
    }

    public int[] getSorted() {
        return data;
    }

    public void run_algorithm() {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                incr();
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    incr();
                }
            }
        }
    }
}

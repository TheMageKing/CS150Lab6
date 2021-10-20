
/**
 * This is a bog-standard bubble sort. It's super efficent!
 *
 * @author Calum McConnell
 * @version 0.0.1
 */
public class BubbleSort implements ComplexityCount {
    // default-initializes to zero
    private long counter;

    private int[] data;

    public BubbleSort(int[] dataToSort) {
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
            for (int j = 0; j < data.length - 1; j++) {
                incr();
                if (data[j] > data[j + 1]) {
                    // yes, we do initialize a new variable every loop, paying that cost.
                    // if java's optimizer isn't smart enough to notice,
                    // I don't know why it even bothers existing.
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;

                    incr();
                    // we do an incr() here to make our report a little bit more interesting:
                    // this makes the resulting counter dependent on the data, to a slight degree:
                    // it also is more reflective of the data. This isn't in the spec,
                    // but it won't change the conclusions (other than adding some multiplier
                    // to the runtime)

                    // also, if the optimizer is sufficiently clever (which it probably isnt),
                    // it might notice that we never access the sorted data, and then just
                    // decide not to sort it, only adjusting our counter.
                    // because it's an instance variable with an accessor, this decision
                    // would be unlikely: but it is legal, since our observed results (other than
                    // runtime) are unchanged.
                }
            }
        }
    }
}

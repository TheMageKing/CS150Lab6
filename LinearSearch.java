
/**
 * Conducts a linear search through a list for the given number
 *
 * @author Calum McConnell
 * @version 0.0.1
 */
public class LinearSearch implements ComplexityCount {
    final int[] data;
    int numberToFind;
    int foundAtIndex;
    int counter;

    public LinearSearch(int[] dataToSearch) {
        // C++ and rust have nicer structures for constants
        // which i miss when I want to provide additional guarantees in java
        data = dataToSearch;
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

    public void resetSearchTarget(int target) {
        initialize();
        numberToFind = target;
    }

    public int getLocatedIndex() {
        return foundAtIndex;
    }

    public void run_algorithm() {
    	// if I wanted to, I could have modified this algorithm
    	// to give up when the key was smaller than the next value, optimizing
    	// greatly the very common case where the key is not in the list. 
    	// Shame I thought of that after my million-element run was already halfway done.
    	
    	// speaking of optimizations, I could also have reduced the complexity
    	// of running this search N times from O(N^2) to O(N log N), by
    	// searching for an entire array of keys at once.  This is done by sorting the key
    	// array, and then advancing through both arrays simultaneuously.
    	// If the current key is greater than the current value, go to the next
    	// key.  otherwise, go to the next value.  this simple system is O(N):
    	// we need to be in O(N log N) to sort the data (using a sane algorithm),
    	// and we'd need to fudge the values for this project, but otherwise
    	// we'd be in the same class as repeated binary searches.  Our runtime,
    	// however, would be far better: as this algorithm substancially benefits
    	// from good locality and the L1/L2 CPU caches, whereas the binary search...
    	// doesn't.
    	
    	// anyways, its a shame I thought of that after I had already
    	// started my desktop on this problem.

        for (int i = 0; i < data.length; i++) {
            incr();
            if (numberToFind == data[i]) {
                foundAtIndex = data[i];
                return;
            }
        }
        foundAtIndex = -1;
        return;

    }
}

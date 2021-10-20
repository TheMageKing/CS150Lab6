
/**
 * Conducts a linear search through a list for the given number
 *
 * @author Calum McConnell
 * @version 0.0.1
 */
public class BinarySearch implements ComplexityCount
{
    final int[] data;
    int numberToFind;
    int foundAtIndex;
    int counter;
    
    public BinarySearch(int[] dataToSearch)
    {
        // C++ and rust have nicer structures for constants
        // which i miss when I want to provide additional guarantees in java
        data = dataToSearch;
    }
    
    public long result(){
        return counter;
    }
    
    public void incr(){
        counter ++;
    }
    
    public void initialize(){
        counter = 0;
    }
    
    public void resetSearchTarget(int target){
        initialize();
        numberToFind = target;
    }
    
    public int getLocatedIndex(){
        return foundAtIndex;
    }
    public void run_algorithm(){
 int mid = 0;
 int low = 0;
 int high = data.length - 1;

 while(high >= low) {

 mid = (high + low)/2;

 if (data[mid] < numberToFind) { // search to the right
 low = mid + 1;
 } else if (numberToFind < data[mid]) {// search to the left
 high = mid - 1;
 } else {
      foundAtIndex = data[mid]; // item found
 return;
 }
 }

 foundAtIndex = -1; // item not found
 
    }
}
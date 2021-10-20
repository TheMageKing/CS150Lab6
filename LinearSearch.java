
/**
 * Conducts a linear search through a list for the given number
 *
 * @author Calum McConnell
 * @version 0.0.1
 */
public class LinearSearch implements ComplexityCount
{
    final int[] data;
    int numberToFind;
    int foundAtIndex;
    int counter;
    
    public LinearSearch(int[] dataToSearch)
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

 for(int i = 0; i < data.length; i++) {
incr();
 if(numberToFind == data[i]) {
     foundAtIndex = data[i]; 
    return;
}
 }
 foundAtIndex = -1;
 return;

    }
}

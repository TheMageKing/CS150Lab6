/**
* The ComplexityCount interface defines several methods that are used
* to manipulate a counter to determine the number of iterations
* an algorithm performs for estimating the algorithmic complexity.
*
* The class will need to specify the counter that is to be used.
*/
public interface ComplexityCount {
 /**
 * This method will be used to initialize the counter to zero.
 */
 public void initialize();

 /**
 * This method increments the counter by one.
 */
 public void incr();

 /**
 * This will return the counter value. Changed to a long,
 * because we'll probably have more than 4 billion iterations
 * 
 *
 * @return The returned counter.
 */
 public long result();

 /**
 * This will run the algorithm implement within the class.
 */
 public void run_algorithm();
}
import java.io.FileWriter;

/**
 * This class is responsible for actually running the tests.
 * Pay no attention to the fact that it apparently uses multithreading;
 * that's not something that's taught in CS150
 *
 * @author Calum McConnell
 * @version 42
 */
public class Runner
{
    public static void main(){
        FileWriter fileOutput;
        try{
            // open the file
            fileOutput = new FileWriter("output");
            // put some column headers in
            fileOutput.write("randomSeed,nValue,searchesNotFound,bubSort,fastBubSort,linSearchMin,linSearchAvg,linSearchMax,binSearchMin,binSearchAvg,binSearchMax");
        }
        catch(Exception e){
            System.out.println("things broke");
            System.err.println(e);
            return;
        }
        
        // get a list of the N-values we will be using
        int[] nVals = {10,100,1000,10_000,100_000,1_000_000};
        
        // now, for the multithreading.  Lets make an array to hold the threads
        // I created.  this way, I can get a 'progress bar'
        Thread[] threads = new Thread[nVals.length*20];
        // this represents the index we are inserting into within the array
        int dex = 0;
        
        // build a thread for each value of N
        for(int i: nVals){
            // our seeds are just 00000,00002, etc... it doesn't matter, the
            // random class is good enough.
            for(int j = 0; j < 20; j++){
                // capturing lambdas can only work with local variables 
                // that are never modified, so we need to 'clone' j.
                int k = j;
                // now, we summon ThreadThulu
                Thread t = new Thread(() ->runAndEvaluateSorts(k,i,fileOutput));
                // place ThreadThulu in the array
                threads[dex++] = t;
            }
        }
        
        // now, we wait.  but that's boring, so lets get a status printing
        
        // loop until all threads are done
        boolean allDone = false;
        
        
    }
    
    /**
     * This method will be used as a runable, and will be running multiple
     * times simultaneuously.  In the interests of thread-saftey, it must
     * therefore behave in a specific way, and I need to be careful about
     * what objects it can access (since unsynchronized access means data
     * races and problems).
     * 
     * Fortunately, its very easy in this case (which is why I am using
     * threads, rather than just doing it sequentially).  The thread needs
     * to access almost nothing outside of itself, and what it does need
     * is primitive types (which can't data race anyways in java). The
     * FileWriter class is synchronized: a review of the docs shows that
     * it will not modify the file concurrently within a single
     * method call, which would corrupt our data.
     * I pass it in as a parameter just to make it really clear that 
     * I know what firey torches I am juggling here.
     */
    public static void runAndEvaluateSorts(int seed, int N, FileWriter w){
        
    }
}

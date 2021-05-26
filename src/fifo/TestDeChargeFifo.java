
package fifo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import structures.ListCAL.ListCal;
import structures.ListDoubleCAL.DoubleListCAL;
import structures.VectorCAL.VectorCAL;
import timecounter.TimeCounter;

import static org.junit.Assert.assertEquals;


public class TestDeChargeFifo {
    TimeCounter tc;

    public TestDeChargeFifo() { }

    @Before
    public void setUp() {
        tc = new TimeCounter();
    }
    
    @After
    public void tearDown() {
        tc.stop();
         System.out.println(tc.toString());
         System.out.println();
         System.out.println();
    }

    //push test
    @Test
    public void pushVectorCAL() throws InterruptedException{
        VectorCAL datastructureVector = new VectorCAL();
          Fifo f = new Fifo( datastructureVector );
          tc.start(); 
          for (int i = 1 ; i <= 10; i++) {
              f.push("toto");
              tc.lap();
          }
    }
    
    @Test
    public void pushListCAL() throws InterruptedException{
        ListCal datastructureVector = new ListCal ();
        Fifo f = new Fifo( datastructureVector);
        tc.start();
        for(int i = 1; i <= 10; i++) {
          f.push("toto");
          tc.lap();
        }
    }
    
     @Test
    public void pushDoubleListCAL() throws InterruptedException{
        DoubleListCAL datastructureVector = new DoubleListCAL ();
        Fifo f = new Fifo( datastructureVector);
        tc.start();
        for (int i = 1; i <= 10; i++) {
            f.push("toto");
            tc.lap();
        }
    }
    
//pop test charge

@Test
    public void popVectorCAL() throws InterruptedException {
        VectorCAL datastructureVector = new VectorCAL();
        Fifo f = new Fifo( datastructureVector);

        for (int i = 1; i <= 10; i++) {
            f.push("toto");
        }
        tc.start();

        for (int i = 1; i <= 10; i++){
            assertEquals("toto",f.pop());
            tc.lap();
        }
    }
    
    @Test
    public void popListCAL() throws InterruptedException{
        ListCal datastructureVector = new ListCal ();
        Fifo f = new Fifo( datastructureVector);

        for (int i = 1; i <= 10; i++) {
            f.push("toto");
        }

        tc.start();
        for (int i = 1; i <= 10; i++) {
            assertEquals("toto",f.pop());
            tc.lap();
        }
    }
    
     @Test
    public void popshDoubleListCAL() throws InterruptedException{
        DoubleListCAL datastructureVector=new DoubleListCAL ();
        Fifo f = new Fifo( datastructureVector);
        for (int i = 1; i <= 10; i++) {
            f.push("toto");
        }
          
        tc.start();
        for (int i = 1; i <= 10; i++) {
          assertEquals("toto",f.pop());
          tc.lap();
        }
    }
}
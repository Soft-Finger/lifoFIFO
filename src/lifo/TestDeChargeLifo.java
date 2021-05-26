
package lifo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import structures.ListCAL.ListCal;
import structures.ListDoubleCAL.DoubleListCAL;
import structures.VectorCAL.VectorCAL;
import timecounter.TimeCounter;

import static org.junit.Assert.assertEquals;


public class TestDeChargeLifo {
    public TestDeChargeLifo() {
    }
    TimeCounter tc;
    @Before
    public void setUp() {
        tc=new TimeCounter();
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
        VectorCAL datastructureVector=new VectorCAL();
          Lifo l = new Lifo( datastructureVector);
          tc.start(); 
          for(int i=1;i<=10;i++){
            
          l.push("toto");
          tc.lap();
          }
    }
    
    @Test
    public void pushListCAL() throws InterruptedException{
        ListCal datastructureVector=new ListCal ();
          Lifo l = new Lifo( datastructureVector);
          tc.start(); 
          for(int i=1;i<=10;i++){
            
          l.push("toto");
          tc.lap();
          }
    }
    
     @Test
    public void pushDoubleListCAL() throws InterruptedException{
        DoubleListCAL datastructureVector=new DoubleListCAL ();
          Lifo l = new Lifo( datastructureVector);
          tc.start(); 
          for(int i=1;i<=10;i++){
            
          l.push("toto");
          tc.lap();
          }

    }
    
//pop test charge

@Test
    public void popVectorCAL() throws InterruptedException{
          VectorCAL datastructureVector=new VectorCAL();
          Lifo l = new Lifo( datastructureVector);

          for(int i = 1; i <= 10; i++){
            l.push("toto");
          }
          tc.start(); 
          for(int i=1;i<=10;i++){
            assertEquals("toto",l.pop());
            tc.lap();
          }
    }
    
    @Test
    public void popListCAL() throws InterruptedException{
        ListCal datastructureVector = new ListCal ();
        Lifo l = new Lifo( datastructureVector);
        for(int i = 1; i <= 10; i++){
            l.push("toto");
        }

        tc.start();
        for(int i = 1; i <= 10; i++){
            assertEquals("toto",l.pop());
            tc.lap();
        }
    }
    
     @Test
    public void popshDoubleListCAL() throws InterruptedException{
        DoubleListCAL datastructureVector=new DoubleListCAL ();
          Lifo l = new Lifo( datastructureVector);
        for (int i = 1; i <= 10; i++) {
            l.push("toto");
        }

        tc.start();
        for (int i = 1; i <= 10; i++) {
          assertEquals("toto",l.pop());
          tc.lap();
        }
    }
}

package fifo;

import org.junit.Test;
import structures.ListCAL.ListCal;
import structures.ListDoubleCAL.DoubleListCAL;
import structures.VectorCAL.VectorCAL;

import static org.junit.Assert.*;

public class FifoTest {
// VectorCAL test junit
     @Test
    public void pushEmpty() {
         VectorCAL datastructureVector=new VectorCAL();
          Fifo f = new Fifo( datastructureVector);
          f.push("toto");
          assertEquals("toto", f.pop());
          assertTrue(f.isEmpty());
    }
    
     @Test
    public void pushFull() {
        //fillup the initial tab (4 elements by default)
        VectorCAL datastructureVector = new VectorCAL();
          Fifo f = new Fifo( datastructureVector);
          f.push("toto");
          f.push("titi");
          f.push("tata");
          f.push("tutu");

        //add a new element (resize is called internally)
        f.push("tyty");

        assertEquals("toto",f.pop());
        assertEquals("titi",f.pop());
        assertEquals("tata",f.pop());
        assertEquals("tutu",f.pop());
        assertEquals("tyty",f.pop());
        assertTrue(f.isEmpty());
        
    }
    
     @Test
    public void pushNull() {
         VectorCAL datastructureVector = new VectorCAL();
          Fifo f = new Fifo( datastructureVector);
        //fillup the initial tab (4 elements by default)
        f.push("toto");
        f.push("titi");

        //add a new element (resize is called internally)
        try {
            f.push(null);
        }
        catch (IllegalArgumentException e){
            
            assertEquals("toto",f.pop());
            assertEquals("titi",f.pop());
             assertTrue(f.isEmpty());
            return;
        }
        fail();
    }
    
     @Test
    public void popEmpty() {
          VectorCAL datastructureVector=new VectorCAL();
          Fifo f = new Fifo( datastructureVector);
         try {
          assertEquals("toto", f.pop());
        }
        catch (IllegalArgumentException e){
            
           
             assertTrue(f.isEmpty());
            return;
        }
        fail();     
        
    }
    
    @Test
    public void empty() {
        //fillup the initial tab (4 elements by default)
        VectorCAL datastructureVector=new VectorCAL();
          Fifo f = new Fifo( datastructureVector);
          f.push("toto");
          f.push("titi");
          f.push("tata");
          f.push("tutu");

        //add a new element (resize is called internally)
        f.push("tyty");

        f.empty();
        assertTrue(f.isEmpty());
        
    }
    
     @Test
    public void isEmptyFull() {
        //fillup the initial tab (4 elements by default)
        VectorCAL datastructureVector=new VectorCAL();
          Fifo f = new Fifo( datastructureVector);
          f.push("toto");
          f.push("titi");
          f.push("tata");
          f.push("tutu");

        //add a new element (resize is called internally)
        f.push("tyty");
        assertFalse(f.isEmpty());
        
    }

    // ListCAL test junit
     @Test
    public void pushEmptyList() {
          ListCal datastructureVector = new ListCal();
          Fifo f = new Fifo( datastructureVector);
          f.push("toto");
          assertEquals("toto", f.pop());
          assertTrue(f.isEmpty());
    }
    
     @Test
    public void pushFullList() {
        //fillup the initial tab (4 elements by default)
        ListCal datastructureVector = new ListCal();
          Fifo f = new Fifo( datastructureVector);
          f.push("toto");
          f.push("titi");
          f.push("tata");
          f.push("tutu");

        //add a new element (resize is called internally)
        f.push("tyty");

        assertEquals("toto",f.pop());
        assertEquals("titi",f.pop());
        assertEquals("tata",f.pop());
        assertEquals("tutu",f.pop());
        assertEquals("tyty",f.pop());
        assertTrue(f.isEmpty());
        
    }
    
     @Test
    public void pushNullList() {
         ListCal datastructureVector = new ListCal();
          Fifo f = new Fifo( datastructureVector);
        //fillup the initial tab (4 elements by default)
        f.push("toto");
        f.push("titi");

        //add a new element (resize is called internally)
        try {
            f.push(null);
        }
        catch (IllegalArgumentException e){
            
            assertEquals("toto",f.pop());
            assertEquals("titi",f.pop());
             assertTrue(f.isEmpty());
            return;
        }
        fail();
    }
    
     @Test
    public void popEmptyList() {
          ListCal datastructureVector=new ListCal();
          Fifo f = new Fifo( datastructureVector);
         try {
          assertEquals("toto", f.pop());
        }
        catch (IllegalArgumentException e){
            
           
             assertTrue(f.isEmpty());
            return;
        }
        fail();
    }
    
    @Test
    public void emptyList() {
        //fillup the initial tab (4 elements by default)
        ListCal datastructureVector=new ListCal();
          Fifo f = new Fifo( datastructureVector);
          f.push("toto");
          f.push("titi");
          f.push("tata");
          f.push("tutu");

        //add a new element (resize is called internally)
        f.push("tyty");

        f.empty();
        assertTrue(f.isEmpty());
    }
    
     @Test
    public void isEmptyFullList() {
        //fillup the initial tab (4 elements by default)
        ListCal datastructureVector=new ListCal();
          Fifo f = new Fifo( datastructureVector);
          f.push("toto");
          f.push("titi");
          f.push("tata");
          f.push("tutu");

        //add a new element (resize is called internally)
        f.push("tyty");

        assertFalse(f.isEmpty());
    }
    
    
    
     // DoubleListCAL test junit
     @Test
    public void pushEmptyDoubleList() {
          DoubleListCAL datastructureVector = new DoubleListCAL();
          Fifo f = new Fifo( datastructureVector);
          f.push("toto");
          assertEquals("toto", f.pop());
          assertTrue(f.isEmpty());
    }
    
     @Test
    public void pushFullDoubleList() {
        //fillup the initial tab (4 elements by default)
        DoubleListCAL datastructureVector=new DoubleListCAL();
          Fifo f = new Fifo( datastructureVector);
          f.push("toto");
          f.push("titi");
          f.push("tata");
          f.push("tutu");
        //add a new element (resize is called internally)
        f.push("tyty");

        assertEquals("toto",f.pop());
        assertEquals("titi",f.pop());
        assertEquals("tata",f.pop());
        assertEquals("tutu",f.pop());
        assertEquals("tyty",f.pop());
        assertTrue(f.isEmpty());
    }
    
     @Test
    public void pushNullDoubleList() {
         DoubleListCAL datastructureVector=new DoubleListCAL();
          Fifo f = new Fifo( datastructureVector);
        //fillup the initial tab (4 elements by default)
        f.push("toto");
        f.push("titi");

        //add a new element (resize is called internally)
        try {
            f.push(null);
        }
        catch (IllegalArgumentException e) {
            assertEquals("toto",f.pop());
            assertEquals("titi",f.pop());
             assertTrue(f.isEmpty());
            return;
        }
        fail();
    }
    
     @Test
    public void popEmptyDoubleList() {
          DoubleListCAL datastructureVector=new DoubleListCAL();
          Fifo f = new Fifo( datastructureVector);
         try {
          assertEquals("toto", f.pop());
        }
        catch (IllegalArgumentException e){
            
           
             assertTrue(f.isEmpty());
            return;
        }
        fail();     
        
    }
    
    @Test
    public void emptyDoubleList() {
        //fillup the initial tab (4 elements by default)
        DoubleListCAL datastructureVector=new DoubleListCAL();
          Fifo f = new Fifo( datastructureVector);
          f.push("toto");
          f.push("titi");
          f.push("tata");
          f.push("tutu");

        //add a new element (resize is called internally)
        f.push("tyty");

        f.empty();
        assertTrue(f.isEmpty());
        
    }
    
     @Test
    public void isEmptyFullDoubleList() {
        //fillup the initial tab (4 elements by default)
        DoubleListCAL datastructureVector=new DoubleListCAL();
          Fifo f = new Fifo( datastructureVector);
          f.push("toto");
          f.push("titi");
          f.push("tata");
          f.push("tutu");

        //add a new element (resize is called internally)
        f.push("tyty");
        assertFalse(f.isEmpty());
    }
}

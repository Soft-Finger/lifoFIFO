
package lifo;


import org.junit.Test;
import structures.ListCAL.ListCal;
import structures.ListDoubleCAL.DoubleListCAL;
import structures.VectorCAL.VectorCAL;

import static org.junit.Assert.*;

public class LifoTest {
// VectorCAL test junit
     @Test
    public void pushEmpty() {
         VectorCAL datastructureVector = new VectorCAL();
          Lifo l = new Lifo( datastructureVector);
          l.push("toto");
          assertEquals("toto", l.pop());
          assertTrue(l.isEmpty());
    }
    
     @Test
    public void pushFull() {
        //fillup the initial tab (4 elements by default)
        VectorCAL datastructureVector = new VectorCAL();
          Lifo l = new Lifo( datastructureVector);
          l.push("toto");
          l.push("titi");
          l.push("tata");
          l.push("tutu");

        //add a new element (resize is called internally)
        l.push("tyty");

        assertEquals("tyty",l.pop());
        assertEquals("tutu",l.pop());
        assertEquals("tata",l.pop());
        assertEquals("titi",l.pop());
        assertEquals("toto",l.pop());
        assertTrue(l.isEmpty());
    }
    
     @Test
    public void pushNull() {
         VectorCAL datastructureVector = new VectorCAL();
         Lifo l = new Lifo( datastructureVector);

        //fillup the initial tab (4 elements by default)

        l.push("toto");
        l.push("titi");

        //add a new element (resize is called internally)

        try {
            l.push(null);
        }
        catch (IllegalArgumentException e){
            assertEquals("titi",l.pop());
            assertEquals("toto",l.pop());
            assertTrue(l.isEmpty());
            return;
        }
        fail();
    }
    
     @Test
    public void popEmpty() {
          VectorCAL datastructureVector = new VectorCAL();
          Lifo l = new Lifo( datastructureVector);
         try {
          assertEquals("toto", l.pop());
        }
        catch (IllegalArgumentException e){
             assertTrue(l.isEmpty());
            return;
        }
        fail();
    }
    
    @Test
    public void empty() {
        //fillup the initial tab (4 elements by default)
        VectorCAL datastructureVector=new VectorCAL();
          Lifo l = new Lifo( datastructureVector);
          l.push("toto");
          l.push("titi");
          l.push("tata");
          l.push("tutu");

        //add a new element (resize is called internally)
        l.push("tyty");

        l.empty();
        assertTrue(l.isEmpty());
        
    }
    
     @Test
    public void isEmptyFull() {

        //fillup the initial tab (4 elements by default)

        VectorCAL datastructureVector = new VectorCAL();
        Lifo l = new Lifo( datastructureVector);
        l.push("toto");
        l.push("titi");
        l.push("tata");
        l.push("tutu");

        //add a new element (resize is called internally)

        l.push("tyty");
        assertFalse(l.isEmpty());
    }
    

    // ListCAL test junit
     @Test
    public void pushEmptyList() {
        ListCal datastructureVector = new ListCal();
        Lifo l = new Lifo( datastructureVector);
        l.push("toto");
        assertEquals("toto", l.pop());
        assertTrue(l.isEmpty());
    }
    
     @Test
    public void pushFullList() {
        //fillup the initial tab (4 elements by default)
        ListCal datastructureVector = new ListCal();
          Lifo l = new Lifo( datastructureVector);
          l.push("toto");
          l.push("titi");
          l.push("tata");
          l.push("tutu");

        //add a new element (resize is called internally)
        l.push("tyty");

        assertEquals("tyty",l.pop());
        assertEquals("tutu",l.pop());
        assertEquals("tata",l.pop());
        assertEquals("titi",l.pop());
        assertEquals("toto",l.pop());
        assertTrue(l.isEmpty());
    }
    
     @Test
    public void pushNullList() {
         ListCal datastructureVector=new ListCal();
         Lifo l = new Lifo( datastructureVector);
        //fillup the initial tab (4 elements by default)
        l.push("toto");
        l.push("titi");

        //add a new element (resize is called internally)
        try {
            l.push(null);
        }
        catch (IllegalArgumentException e){
            
            assertEquals("titi",l.pop());
            assertEquals("toto",l.pop());
             assertTrue(l.isEmpty());
            return;
        }
        fail();
    }
    
     @Test
    public void popEmptyList() {
          ListCal datastructureVector=new ListCal();
          Lifo l = new Lifo( datastructureVector);
         try {
          assertEquals("toto", l.pop());
        }
        catch (IllegalArgumentException e) {
             assertTrue(l.isEmpty());
            return;
        }
        fail();
    }
    
    @Test
    public void emptyList() {
        //fillup the initial tab (4 elements by default)
        ListCal datastructureVector=new ListCal();
          Lifo l = new Lifo( datastructureVector);
          l.push("toto");
          l.push("titi");
          l.push("tata");
          l.push("tutu");

        //add a new element (resize is called internally)
        l.push("tyty");

        l.empty();
        assertTrue(l.isEmpty());
    }
    
     @Test
    public void isEmptyFullList() {
        //fillup the initial tab (4 elements by default)
        ListCal datastructureVector=new ListCal();
          Lifo l = new Lifo( datastructureVector);
          l.push("toto");
          l.push("titi");
          l.push("tata");
          l.push("tutu");

        //add a new element (resize is called internally)
        l.push("tyty");
        assertFalse(l.isEmpty());
        
    }
    
     // DoubleListCAL test junit
     @Test
    public void pushEmptyDoubleList() {
          DoubleListCAL datastructureVector=new DoubleListCAL();
          Lifo l = new Lifo( datastructureVector);
          l.push("toto");
          assertEquals("toto", l.pop());
          assertTrue(l.isEmpty());
        
    }
    
     @Test
    public void pushFullDoubleList() {
        //fillup the initial tab (4 elements by default)
        DoubleListCAL datastructureVector=new DoubleListCAL();
          Lifo l = new Lifo( datastructureVector);
          l.push("toto");
          l.push("titi");
          l.push("tata");
          l.push("tutu");

        //add a new element (resize is called internally)
        l.push("tyty");

        assertEquals("tyty",l.pop());
        assertEquals("tutu",l.pop());
        assertEquals("tata",l.pop());
        assertEquals("titi",l.pop());
        assertEquals("toto",l.pop());
        assertTrue(l.isEmpty());
        
    }
    
     @Test
    public void pushNullDoubleList() {
         DoubleListCAL datastructureVector=new DoubleListCAL();
          Lifo l = new Lifo( datastructureVector);
        //fillup the initial tab (4 elements by default)
        l.push("toto");
        l.push("titi");

        //add a new element (resize is called internally)
        try {
            l.push(null);
        }
        catch (IllegalArgumentException e){
            
            assertEquals("titi",l.pop());
            assertEquals("toto",l.pop());
             assertTrue(l.isEmpty());
            return;
        }
        fail();
    }
    
     @Test
    public void popEmptyDoubleList() {
          DoubleListCAL datastructureVector=new DoubleListCAL();
          Lifo l = new Lifo( datastructureVector);
         try {
          assertEquals("toto", l.pop());
        }
        catch (IllegalArgumentException e){
            
           
             assertTrue(l.isEmpty());
            return;
        }
        fail();
    }
    
    @Test
    public void emptyDoubleList() {
        //fillup the initial tab (4 elements by default)
        DoubleListCAL datastructureVector=new DoubleListCAL();
          Lifo l = new Lifo( datastructureVector);
          l.push("toto");
          l.push("titi");
          l.push("tata");
          l.push("tutu");

        //add a new element (resize is called internally)
        l.push("tyty");

        l.empty();
        assertTrue(l.isEmpty());
        
    }
    
     @Test
    public void isEmptyFullDoubleList() {
        //fillup the initial tab (4 elements by default)
        DoubleListCAL datastructureVector=new DoubleListCAL();
          Lifo l = new Lifo( datastructureVector);
          l.push("toto");
          l.push("titi");
          l.push("tata");
          l.push("tutu");

        //add a new element (resize is called internally)
        l.push("tyty");
        assertFalse(l.isEmpty());
    }
}

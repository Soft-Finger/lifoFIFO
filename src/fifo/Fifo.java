
package fifo;

import structures.DataStructure;

public class Fifo {
    private Object value;
    private DataStructure datastructure;

    public Fifo(DataStructure datastructure) {
        this.datastructure = datastructure;
    }

   public void push(Object value) {
        datastructure.insertLastElement(value);
   }
   
   public Object pop() {
       Object v;
       v = datastructure.getFirstElement();
       datastructure.removeFirstElement();
       return v;
   }
   
   public boolean isEmpty() {
        return datastructure.isEmpty();
   }
   
   public void empty(){
        datastructure.Empty();
   }
}

package structures.ListDoubleCAL;

public class DoubleNode{
    DoubleNode previous;
    DoubleNode next;
    Object value;

    public DoubleNode(DoubleNode previous, DoubleNode next, Object value)  throws IllegalArgumentException{
        if (value == null) {
            throw new  IllegalArgumentException(" impossible d'ajouter null");
        } else {
            this.previous = previous;
            this.next = next;
            this.value = value;
        }
    }

    public DoubleNode(Object value) {
       this.value = value;
    }

    public DoubleNode getPrevious() {
        return this.previous;
    }

    public void setPrevious(DoubleNode previous) {
        this.previous = previous;
        return ;
    }

    public DoubleNode getNext() {
        return this.next;
    }

    public void setNext(DoubleNode next) {
         this.next = next;
        return ;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) throws IllegalArgumentException {
         if (value == null) {
            throw new  IllegalArgumentException(" impossible d'ajouter null");
        } else {
            this.value = value;
       }
        return ;
    }
}

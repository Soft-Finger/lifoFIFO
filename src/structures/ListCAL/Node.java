package structures.ListCAL;


public class Node {
    private Object value;
    private Node next;

    /**
     * @param value valeur a stocker
     * @param next prochain noeud
     * @throws IllegalArgumentException quand value est null;
     */

    public Node(Object value, Node next) throws IllegalArgumentException {
        if(value==null) {
            throw new  IllegalArgumentException(" impossible d'ajouter null");
        } else {
            this.value=value;
            this.next=next;
        }
    }

    public Object getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }

    public void setValue(Object value) {
       if (value==null) {
            throw new  IllegalArgumentException(" impossible d'ajouter null");
       } else {
            this.value=value;
       }
    }

    public void setNext(Node next) throws IllegalArgumentException {
        this.next=next;
    }

    @Override
    public String toString() {
        return null;
    }
}

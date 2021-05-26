package structures.ListCAL;

import structures.DataStructure;

public class ListCal implements DataStructure {
    private Node first;
    private static int counter;

    public ListCal() { }

    public void Empty(){
        first = null;
     }

    public boolean isEmpty() {
        return first == null;
    }

    private Node getNodeAt(int position) throws IllegalArgumentException {
         Node courant = first;
         if (first != null) {
           for (int i = 0; i < getNbElements(); i++) {
               if (i == position) {
                   break;
               }
           courant = courant.getNext();
           }
         }
       return courant;
    }

    /**
     * @return le nombre d object dans le tableau
     */

    public int getNbElements() {
        int nombreElements = 0;
        for (Node noeud = first; noeud != null; noeud = noeud.getNext()) {
          nombreElements = nombreElements + 1;
        }
       return nombreElements;
    }


    private Node getLastNode() {
      return getNodeAt(getNbElements() - 1);
    }

    /**
     * Insert l'objet o a la fin de la liste
     *
     * @param o
     * @throws IllegalArgumentException si o est null
     */

    public void insertLastElement(Object o) throws IllegalArgumentException {
        if (o == null) {
            throw new IllegalArgumentException("impossible d'ajout objet null");
        } else {
            if (isEmpty()) {
                first = new Node (o,null);
            } else {
               Node last = getLastNode();
               last.setNext(new Node(o,null));
            }
            return;
        }
    }

    /**
     * Insert l'objet o au debut de la liste.
     * @param o
     * @throws IllegalArgumentException si o est null
     */

    public void insertFirstElement(Object o) throws IllegalArgumentException {
        if (o == null) {
            throw new IllegalArgumentException("impossible d'ajouter objet null");
        } else {
            if (isEmpty()) {
                first=new Node (o,null);
            } else {
                Node n = first;
                first=new Node(o, n);
            }
            return;
        }
    }

    /**
     * Insert l'objet o a la position "position".
     *
     * @param o
     * @throws IllegalArgumentException si o est null
     */

    public void insertElementAt(Object o, int position) throws IllegalArgumentException {
        if (o == null) {
            throw new IllegalArgumentException();
        } else {
            if (position >= 0 && position <= getNbElements()) {
               if (position == 0) {
                    first = new Node (o, first);
               } else {
                  Node courant=getNodeAt(position);
                  Node precedent=getNodeAt(position - 1);
                  precedent.setNext(new Node(o, courant));
              }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * @param position >0 && < getNbelements
     * @return l object a la pposition i
     * @throws IllegalArgumentException si la position n est pas valide
     */

    public Object getElementAt(int position) throws IllegalArgumentException {
        if (position >= 0 && position < getNbElements()) {
            int counter = 0;
            Node courant = first;
            while(first != null && counter < position) {
                courant = courant.getNext();
                counter++;
           }
            return courant.getValue();
        } else {
            throw new IllegalArgumentException("Position invalide");
        }
    }

    /**
     * supprime l object a la position i
     *
     * @param position >0 && < getNbelements
     * @throws IllegalArgumentException si la position n est pas valide
     */

    public void removeElementAt(int position) throws IllegalArgumentException {
        if (position >= 0 && position < getNbElements()) {
            if (position == 0) {
                removeFirstElement();
            } else {
                if (position == getNbElements() - 1 ) {
                    removeLastElement();
                } else {
                     Node avantDernier = getNodeAt(position - 1);
                     avantDernier.setNext(avantDernier.getNext().getNext());
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        return;
    }

    /**
     * Supprime la premiere occurence de o dans la liste
     *
     * @param o non null
     * @return true si l ement a ete supprime, false sinon
     * @throws IllegalArgumentException si o est null
     */

    public boolean removeElement(Object o) throws IllegalArgumentException {
        if (o == null) {
            throw new IllegalArgumentException();
        } else {
            if (isEmpty()) {
                throw new IllegalArgumentException();
            } else {
                boolean sup;
                if (findPosition(o) == - 1) {
                    sup = false;
                } else {
                    removeElementAt(findPosition(o));
                    sup = true;
                }
                return sup;
            }
        }
    }

    /**
     * Supprime toutes les occurences de o dans le tableau
     *
     * @param o non null
     * @return le nombre d element supprimes
     * @throws IllegalArgumentException si o est null
     */
    public int removeAllOccurences(Object o) throws IllegalArgumentException {
         int nbElementSuprimer = 0;
         if (o == null) {
            throw new IllegalArgumentException("impossible d'ajouter null");
        } else {
            Node n = first;
            while (n != null) {
                if (n.getValue().equals(o)) {
                    removeElementAt(findPosition(o));
                    n = first;
                    nbElementSuprimer=nbElementSuprimer + 1;
                }
                n = n.getNext();
            }
        }
        return nbElementSuprimer;
    }

    public boolean removeFirstElement() throws IllegalArgumentException {
        boolean sup = false;
        if (isEmpty()) {
            return false;
        }

        if (!isEmpty()) {
            if (getNbElements() == 1) {
                first = null;
            } else {
                first = first.getNext();
            }
            sup = true;
        }
        return sup;
    }

    public boolean removeLastElement() throws IllegalArgumentException {
        boolean sup = false;
        if (isEmpty()) {
        }   else {
            if  (getNbElements() == 1) {
                removeFirstElement();
            } else {
                 Node avantDernier = getNodeAt(getNbElements() - 2);
                 avantDernier.setNext(avantDernier.getNext().getNext());
            }
            sup = true;
        }
        return sup;
    }

    public int findPosition(Object o) throws IllegalArgumentException {
        int position = - 1;
        int trouve = - 1;
         if (o == null) {
            throw new IllegalArgumentException("impossible de rechercher null");
         } else {
            Node n = first;
            while (n != null) {
                position++;
                if (n.getValue().equals(o)) {
                    trouve = position;
                    break;
                }
                n = n.getNext();
            }
            return trouve;
         }
    }

   public Object getLastElement() {
        return getElementAt(getNbElements()-1);
    }

    public Object getFirstElement() {
        return getElementAt(0);
    }

    public String toString() {
        String res = "";
        Node n = first;
        while (n != null) {
            res += n.getNext();
            n = n.getNext();
        }
        return res;
    }
}

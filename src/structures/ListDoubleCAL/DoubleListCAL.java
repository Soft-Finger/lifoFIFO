package structures.ListDoubleCAL;

import structures.DataStructure;

public class DoubleListCAL implements DataStructure {
    private DoubleNode first;
    private DoubleNode last;
    private int nbNodes = 0;

    public boolean isEmpty() {
        return (first == null && last == null);
    }

    public void Empty() {
        first = null;
        last = null;
    }

    private void checkPosition(int position){
        return;
    }

    private DoubleNode getNodeAtFromFirst(int position) throws IllegalArgumentException {
            return null;
    }

    private DoubleNode getNodeAtFromEnd(int position) throws IllegalArgumentException {
        return null;
    }

    private DoubleNode getNodeAt(int position) throws IllegalArgumentException {
         DoubleNode courant = first;
         if (first != null) {
            for(int i = 0; i < getNbElements(); i++) {
                if (i == position){
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
         nbNodes = 0;
        for (DoubleNode noeud = first; noeud != null; noeud = noeud.getNext()) {
            nbNodes = nbNodes + 1;
        }
        return nbNodes;
    }

    private DoubleNode getLastNode() {
        return getNodeAt(getNbElements() - 1);
    }

    public Object getLastElement() {
        return getElementAt(getNbElements() - 1);
    }

    public Object getFirstElement() {
        return getElementAt(0);
    }


    /**
     * Insert l'objet o a la fin de la liste
     *
     * @param o
     * @throws IllegalArgumentException si o est null
     */
    public void insertLastElement(Object o) throws IllegalArgumentException {
        if (o == null) {
            throw new IllegalArgumentException("impossible d'ajouter objet null");
        } else {
            if (isEmpty()) {
                first = new DoubleNode (null,null, o);
            } else {
               DoubleNode fin = getLastNode();
               fin.setNext(new DoubleNode(fin,null, o));
            }
        }
        return;
    }

    /**
     * Insert l'objet o au debut de la liste.
     *
     * @param o
     * @throws IllegalArgumentException si o est null
     */
    public void insertFirstElement(Object o) throws IllegalArgumentException {
        if  (o == null) {
            throw new IllegalArgumentException("impossible d'ajouter objet null");
        } else {
            if (isEmpty()) {
                first = new DoubleNode (null,null,o);
            } else {
                DoubleNode premier = first;
                first = new DoubleNode(null, premier, o);
                premier.setPrevious(first);
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
        if ( o == null) {
            throw new IllegalArgumentException();
        } else {
            if (position >= 0 && position <= getNbElements()) {
                  if (position == 0) {
                      insertFirstElement(o);
                  } else if (position == getNbElements()) {
                      insertLastElement(o);
                  } else {
                      DoubleNode courant = getNodeAt(position);
                      DoubleNode precedent = courant.getPrevious();
                      precedent.setNext(new DoubleNode(precedent, courant, o));
                      courant.setPrevious(new DoubleNode(precedent, courant, o));
                  }
            } else {
            throw new IllegalArgumentException();
        }
    }
        return;
    }


    /**
     * @param position > 0 && < getNbelements
     * @return l object a la pposition i
     * @throws IllegalArgumentException si la position n est pas valide
     */

    public Object getElementAt(int position) throws IllegalArgumentException {
         if (isEmpty()) {
            throw new IllegalArgumentException("impossible de retourner null");
         } else {
             if (position >= 0 && position< getNbElements()) {
                int counter = 0;
                DoubleNode courant = first;
                while (first != null && counter < position) {
                   courant = courant.getNext();
                   counter++;
                }
                return courant.getValue();
             } else {
                throw new IllegalArgumentException("Position invalide");
             }
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
                if (position == getNbElements() - 1) {
                    removeLastElement();
                } else {
                     DoubleNode avantDernier = getNodeAt(position - 1);
                     avantDernier.setNext(avantDernier.getNext().getNext());
                     avantDernier.getNext().setPrevious(avantDernier);
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
                if (findPosition(o)==-1) {
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
            DoubleNode n = first;
            while (n != null) {
                if (n.getValue().equals(o)) {
                    removeElementAt(findPosition(o));
                    n = first;
                    nbElementSuprimer=nbElementSuprimer+1;
                } else {
                    n = n.getNext();
                }
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
                last = null;
            } else {
                first= first.getNext();
                first.setPrevious(null);
            }
            sup = true;
        }
        return sup;
    }

    public boolean removeLastElement() throws IllegalArgumentException {
        boolean sup = false;
        if (isEmpty()) {
        } else {
            if (getNbElements() == 1) {
                removeFirstElement();
            } else {
                 DoubleNode avantDernier=getNodeAt(getNbElements()-2);
                 avantDernier.setNext(avantDernier.getNext().getNext());
            }
            sup = true;
        }
        return sup;
    }

    public int findPosition(Object o) throws IllegalArgumentException{
        int position =- 1;
        int trouve =- 1;
         if (o == null) {
            throw new IllegalArgumentException("impossible de rechercher null");
        } else {
            DoubleNode n = first;
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

    public String toString() {
            return "";
        }

    public String ForwardListe() {
        String res = "";
            DoubleNode n = first;
            while (n != null) {
                res += n.getValue();
                n = n.getNext();
            }
        return res;
    } 

    public String BackwardListe() {
        String res = "";
            DoubleNode n = getLastNode();
            while (n != null) {
                res = n.getValue() + res;
                n = n.getPrevious();
            }
        return res;
    }

    /**
     * liste 1 2 3 4 5 6
     * liste a partir du debut  1 2 3 4 5 6
     * liste a partir de la fin 6 5 4 3 2 1
     * verifie que les liens sont coherent dans les deux sens
     * @return true si le parcours a partir de la fin est l inverse du parcours a partir du debut
     */

    public boolean checkIntegrity() {
        boolean n = false;
        if (BackwardListe().equals(ForwardListe())) {
            n = true;
        }
        return n;
    }
}

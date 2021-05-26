
package structures.VectorCAL;

import structures.DataStructure;

public class VectorCAL implements DataStructure {
    private final int INITIAL_SIZE = 4;
    private final int SCALING_RATIO = 2;
    private final int NOT_FOUND_INDEX = - 1;

    private Object[] tab=new Object[INITIAL_SIZE];
    private int nbElements = 0;


    public VectorCAL(){ }

    /**
     * private car l utilisateur n'a pas a connaitre la taille du tableau
     * @return la taille du tableau
     */
    private int size(){
        return tab.length;
    }
    
    public void Empty() {
        for(int i = 0; i < tab.length; i++) {
           tab[i] = null;
        }
    }
 
    /**
     * @return le nombre d object dans le tableau
     */

    public int getNbElements() {
        nbElements = 0;
        for (Object tab1 : tab) {
            if (tab1 != null) {
                nbElements = nbElements + 1;
            }
        }
            return nbElements;
        }

    /**
     * augmente la taille du tableau d un facteur SCALING_RATIO et conserve le contenu du tableau
     * private car l'usager n'a pas a gere la taille du tableau, la fonction sera appelee au besoin par les methodes d insertion
     */

    private void resize() {
        Object[] temp = new Object[size() + SCALING_RATIO];
        for(int i = 0; i < tab.length; i++) {
           temp[i] = tab[i];
        }
       tab = temp;
    }

    /**
     * Insert l'objet o a la fin du tableau. resize est appele au besoin
     * @param o
     * @throws IllegalArgumentException si o est null
     */

    public void insertLastElement(Object o) throws IllegalArgumentException{
        if (o == null) {
            throw new IllegalArgumentException("impossible d'ajouter null");
        } else {
             if (getNbElements()==tab.length) {
                resize();
             }
            tab[getNbElements()]=o;
        }
    }

    /**
     * Insert l'objet o au debut du tableau. resize est appele au besoin
     * @param o
     * @throws IllegalArgumentException si o est null
     */

    public void insertFirstElement(Object o)  throws IllegalArgumentException{
         if (o == null) {
            throw new IllegalArgumentException("impossible d'ajouter null");
        } else {
            if (tab[0] != null) {
                if (getNbElements() == tab.length) {
                    resize();
                }
                moveRight(0);
            }
            tab[0] = o;
        }
    }

    /**
     * Insert l'objet o a la fin du tableau. resize est appele au besoin
     * @param o
     * @throws IllegalArgumentException si o est null
     */

    public void insertElementAt(Object o, int position) throws IllegalArgumentException {
        if (position>=0 && position < getNbElements()) {
              if (o == null) {
                    throw new IllegalArgumentException("impossible d'ajouter null");
              } else {
                    if (tab[position] != null) {
                        if (getNbElements() == tab.length) {
                            resize();
                        }
                        moveRight(position);
                    }
                    tab[position] = o;
              }
        } else {
            throw new IllegalArgumentException("Positon invalide");
        }
    }

    /**
     *
     * @param position >0 && < getNbelements
     * @return l object a la pposition i
     * @throws ArrayIndexOutOfBoundsException si la position n est pas valide
     */

    public Object getElementAt(int position) throws IllegalArgumentException {
        Object temp;
        if (position >= 0 && position < getNbElements()) {
            temp = tab[position];
        } else {
          throw new IllegalArgumentException("Position invalide");
        }
        return temp;
    }

    /**
     * supprime l object a la position i
     * @param position > 0 && < getNbelements
     * @throws IllegalArgumentException si la position n est pas valide
     */

    public void removeElementAt(int position) throws IllegalArgumentException {
        if (position >= 0 && position < getNbElements()) {
            tab[position] = null;
            moveLeft(position);
        } else {
            throw new IllegalArgumentException("Position invalide");
        }
    }

    /**
     * ecrase l object a la position i avec la suite du tableau
     * @param position >0 && < getNbelements
     * @throws IllegalArgumentException si la position n est pas valide
     */

    private void moveLeft(int position) throws IllegalArgumentException {
          Object[] temp = new Object[ size() - 1 ];
          if (position >= 0 && position<getNbElements() + 1) {
                for (int i = 0; i < temp.length; i++) {
                    if (i < position) {
                        temp[i] = tab[i];
                    } else {
                        temp[i] = tab[ i + 1 ];
                    }
                }
                    tab = temp;
          } else {
                throw new IllegalArgumentException("Position invalide");
          }
    }

    /**
     * decale tous les object vers la droite a partir de la position "position" pour ouvrir un trou dans le tableau a la position "position".
     * La valeur null est affecte a cette position.
     * @param position >0 && < getNbelements
     * @throws IllegalArgumentException si la position n est pas valide
     */

    private void moveRight(int position) {
        Object[] temp = new Object[size()];
        if ( position >= 0&& position<getNbElements()) {
            for (int i = 0; i < tab.length; i++) {
                if (i < position) {
                    temp[i] = tab[i];
                } else {
                    if (i > position) {
                        temp[i] = tab[ i - 1 ];
                    }
                }
            }
            temp[ position ] = null;
            tab = temp;
        } else {
            throw new IllegalArgumentException("Position invalide");
       }
    }


    /**
     * decale tous les object vers la droite a partir de la position "position" pour ouvrir un trou dans le tableau a la position "position".
     * La valeur null est affecte a cette position.
     * @param o non null
     * @throws IllegalArgumentException si o est null
     * @return la position de l object (compare avec la fonction.equals()), ou NOT_FOUND_INDEX si l object n est pas trouve
     */

    public int findPosition(Object o) throws IllegalArgumentException {
        int position = NOT_FOUND_INDEX;
         if (o == null){
            throw new IllegalArgumentException("impossible de rechercher null");
         } else {
            for (int i = 0; i < getNbElements() ; i++) {
                if (tab[i].equals(o)) {
                    position = i;
                    break;
                }
            }
            return position;
         }
    }

    /**
     * Supprime la premiere occurence de o dans le tableau
     * @param o non null
     * @return true si l ement a ete supprime, false sinon
     * @throws IllegalArgumentException si o est null
     */

    public boolean removeElement(Object o) throws IllegalArgumentException {
         if (o == null) {
            throw new IllegalArgumentException("impossible de supprimer null");
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

    /**
     * Supprime toutes le occurences de o dans le tableau
     * @param o non null
     * @throws IllegalArgumentException si o est null
     * @return le nombre d element supprimes
     */

    public int removeAllOccurences(Object o) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        int nbElementSuprimer = 0;
         if (o == null) {
            throw new IllegalArgumentException("impossible d'ajouter null");
         } else {
            for (int i = 0; i < getNbElements(); i++) {
                if (tab[i] != null) {
                    if (tab[i].equals(o)) {
                        removeElementAt(i);
                        nbElementSuprimer = nbElementSuprimer + 1;
                    }
                }
            }
        }
        return nbElementSuprimer;
    }


    /**
     * supprime le premier element du tableau. Aucun trou ne doit etre cree dansle tableau
     * @return True si l operation reussi false sinon
     */

    public boolean removeFirstElement() {
        boolean succes;
        if (getNbElements() != 0) {
           moveLeft(0);
           succes = true;
        } else {
            succes = false;
        }
        return succes;
    }

    /**
     * supprime le dernier element du tableau. Aucun trou ne doit etre cree dansle tableau
     * @return True si l operation reussi false sinon
     */
    public boolean removeLastElement() {
         boolean succes;
        if (getNbElements() != 0) {
           removeElementAt(getNbElements() - 1);
           succes = true;
        } else {
            succes = false;
        }
        return succes;
    }

    /**
     * retourne le contenu du tableau, un element pas ligne
     * @return
     */
    
    public String toString() {
        String contenuTableau = "";
        for (int i = 0; i < getNbElements(); i++) {
            if (tab[i] != null) {
                contenuTableau = contenuTableau + ( i + 1 ) + "-" + tab[i] + "\n";
            }
        }
        return contenuTableau;
    }

    @Override
    public boolean isEmpty() {
        return getNbElements() == 0;
    }

    public Object getLastElement() {
            return getElementAt(getNbElements() - 1);
        }

    public Object getFirstElement() {
            return getElementAt(0);
    }
}

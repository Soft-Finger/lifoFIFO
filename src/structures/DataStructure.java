
package structures;

/**
 * Raison principale : Je ne vais pas implémenter les méthodes j'ai
 * juste besoin de la signature des méthodes donc une interface est appropriée
 * pour cela car elle ne prend que la signature des méthodes. Si j'avais besoin de la signature de certaines méthodes, l'implémentation
 * d'autres méthodes et la factorisation du code dans le cadre d'un héritage
 * la classe.
 * */

public  interface DataStructure {
    /**
     *
     * @return le nombre d object dans le tableau
     */
    public int getNbElements();
    
     /**
         * Insert l'objet o a la fin de la liste
         *
         * @param o
         * @throws IllegalArgumentException si o est null
         */
    public void insertLastElement(Object o);
    
    /**
     * Insert l'objet o au debut du tableau. resize est appele au besoin
     * @param o
     * @throws IllegalArgumentException si o est null
     */
    public void insertFirstElement(Object o);
    
    /**
         * Insert l'objet o a la position "position".
         *
         * @param o
         * @throws IllegalArgumentException si o est null
         */
    public void insertElementAt(Object o, int position);
    
     /**
     *
     * @param position >0 && < getNbelements
     * @return l object a la pposition i
     * @throws ArrayIndexOutOfBoundsException si la position n est pas valide
     */
    public Object getElementAt(int position);
    
     /**
         * supprime l object a la position i
         *
         * @param position >0 && < getNbelements
         * @throws IllegalArgumentException si la position n est pas valide
         */
    public void removeElementAt(int position);
    
    /**
     * decale tous les object vers la droite a partir de la position "position" pour ouvrir un trou dans le tableau a la position "position".
     * La valeur null est affecte a cette position.
     * @param o non null
     * @throws IllegalArgumentException si o est null
     * @return la position de l object (compare avec la fonction.equals()), ou NOT_FOUND_INDEX si l object n est pas trouve
     */
    public int findPosition(Object o);
    
    /**
         * Supprime la premiere occurence de o dans la liste
         *
         * @param o non null
         * @return true si l ement a ete supprime, false sinon
         * @throws IllegalArgumentException si o est null
         */
    public boolean removeElement(Object o);
    
    /**
         * Supprime toutes les occurences de o dans le tableau
         *
         * @param o non null
         * @return le nombre d element supprimes
         * @throws IllegalArgumentException si o est null
         */
    public int removeAllOccurences(Object o);
    
      /**
     * supprime le premier element du tableau. Aucun trou ne doit etre cree dansle tableau
     * @return True si l operation reussi false sinon
     */
    public boolean removeFirstElement();

    /**
     * supprime le dernier element du tableau. Aucun trou ne doit etre cree dansle tableau
     * @return True si l operation reussi false sinon
     */
    public boolean removeLastElement();
    
    public boolean isEmpty() ;

    public Object getLastElement();

    public Object getFirstElement();
    
    public void Empty();
}

package exercice;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe contenant une méthode pour trier les mots d'un texte en fonction d'un ordre donné.
 */
public class Exercice {

    /**
     * Trie les mots d'un texte en fonction de l'ordre donné.
     *
     * @param texte le texte contenant les mots à trier
     * @param ordre l'ordre des caractères utilisé pour le tri
     * @return une liste contenant les mots triés selon l'ordre donné
     */
    public static List<String> solution(String texte, List<Character> ordre) {
        List<String> mots = new ArrayList<>();
        String s1 = new String();
    
        for (int i = 0; i < texte.length(); i++) {
            char c = texte.charAt(i);
            if (Character.isLetter(c)) {
                s1+=c;
            } else if (c == '\'') {
                s1+=' ';
            } else {
                if (s1.length() > 0) {
                    mots.add(s1.toString());
                    s1 = new String();
                }
            }
        }
    
        if (s1.length() > 0) {
            mots.add(s1.toString());
        }
    
        triRapide(mots, ordre, 0, mots.size() - 1);
    
        return mots;
    }
    

    /**
     * Effectue un tri rapide récursif sur une liste de mots en utilisant l'ordre donné.
     *
     * @param mots   la liste de mots à trier
     * @param ordre  l'ordre des caractères utilisé pour le tri
     * @param debut  l'indice de début de la portion à trier
     * @param fin    l'indice de fin de la portion à trier
     */
    private static void triRapide(List<String> mots, List<Character> ordre, int debut, int fin) {
        if (debut < fin) {
            int pivotIndex = partitionner(mots, ordre, debut, fin);
            triRapide(mots, ordre, debut, pivotIndex - 1);
            triRapide(mots, ordre, pivotIndex + 1, fin);
        }
    }

    /**
     * Partitionne la liste de mots en utilisant un pivot et l'ordre donné.
     *
     * @param mots   la liste de mots à partitionner
     * @param ordre  l'ordre des caractères utilisé pour le tri
     * @param debut  l'indice de début de la portion à partitionner
     * @param fin    l'indice de fin de la portion à partitionner
     * @return l'indice du pivot après partitionnement
     */
    private static int partitionner(List<String> mots, List<Character> ordre, int debut, int fin) {
        String pivot = mots.get(fin);
        int i = debut - 1;

        for (int j = debut; j < fin; j++) {
            if (compare(mots.get(j), pivot, ordre) <= 0) {
                i++;
                echanger(mots, i, j);
            }
        }

        echanger(mots, i + 1, fin);
        return i + 1;
    }

    /**
     * Compare deux mots en utilisant l'ordre donné.
     *
     * @param mot1   le premier mot à comparer
     * @param mot2   le deuxième mot à comparer
     * @param ordre  l'ordre des caractères utilisé pour le tri
     * @return un entier négatif si mot1 est inférieur à mot2, un entier positif si mot1 est supérieur à mot2, 0 si les mots sont égaux
     */
    private static int compare(String mot1, String mot2, List<Character> ordre) {
        int minLength = Math.min(mot1.length(), mot2.length());

        for (int i = 0; i < minLength; i++) {
            char c1 = mot1.charAt(i);
            char c2 = mot2.charAt(i);

            if (c1 != c2) {
                return getIndex(c1, ordre) - getIndex(c2, ordre);
            }
        }

        return mot1.length() - mot2.length();
    }

    /**
     * Retourne l'indice d'un caractère dans l'ordre donné.
     *
     * @param c      le caractère à rechercher
     * @param ordre  l'ordre des caractères utilisé pour le tri
     * @return l'indice du caractère dans l'ordre, ou -1 si le caractère n'est pas présent dans l'ordre
     */
    private static int getIndex(char c, List<Character> ordre) {
        for (int i = 0; i < ordre.size(); i++) {
            if (ordre.get(i) == c) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Échange deux mots dans la liste.
     *
     * @param mots  la liste de mots
     * @param i     l'indice du premier mot à échanger
     * @param j     l'indice du deuxième mot à échanger
     */
    private static void echanger(List<String> mots, int i, int j) {
        String temp = mots.get(i);
        mots.set(i, mots.get(j));
        mots.set(j, temp);
    }
}

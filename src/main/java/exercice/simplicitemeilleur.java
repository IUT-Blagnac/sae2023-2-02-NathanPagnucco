package exercice;

import java.util.ArrayList;
import java.util.List;

/**
 * Une solution algorithmique qui vise à être la plus facile à comprendre et à maintenir
 */
public class simplicitemeilleur {
    /**
     * Permet de trier une liste de mots selon un ordre donné
     * @param texte IN : texte à trier, les mots sont séparés par des caractères qui ne sont pas des lettres ou des chiffres
     * @param ordre IN : ordre de tri, les lettres sont uniques et peuvent être en majuscule ou minuscule
     * @return la liste des mots triés selon l'ordre, vide si le texte ou l'ordre est vide
     * @throws IllegalArgumentException si un des paramètres est null
     */
    public static List<String> solution(String texte, List<Character> ordre) throws IllegalArgumentException
    {
        if(texte==null || ordre==null) {
            throw new IllegalArgumentException("Les paramètres ne peuvent pas être null"); //On vérifie que les paramètres ne sont pas null
        }
        if(texte.isEmpty()) {
            return List.of(""); //Si le texte ou l'ordre est vide, on retourne une liste vide
        }
        //Si les paramètres sont valides, on commence le tri
        List<String> listeMotsTries = new ArrayList<>();
        String[] arrayMotsNonTries = texte.split("[^a-zA-Z0-9]"); //On sépare le texte en mots, on enlève les caractères qui ne sont pas des lettres ou des chiffres qui séparent les mots
        for (char lettreOrdre : ordre) {
            //On parcourt les lettres de l'ordre
            for (String mot : arrayMotsNonTries) {
                //On parcourt les mots du texte
                if (!mot.isEmpty() && mot.charAt(0) == lettreOrdre) { //Si le mot n'est pas vide et que la première lettre du mot est la lettre de l'ordre
                    listeMotsTries.add(mot); //On ajoute le mot à la liste des mots triés, il sera trié selon l'ordre
                    mot=""; //On vide le mot pour ne pas le réutiliser
                }
            }
        }
        //On parcourt les mots restants, ceux qui ne sont pas impacté par l'ordre
        for (String mot : arrayMotsNonTries) {
            if (!mot.isEmpty() && !listeMotsTries.contains(mot)) {
                listeMotsTries.add(mot);
            }
        }
        return listeMotsTries;
    }
}

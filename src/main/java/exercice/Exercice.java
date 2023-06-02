package exercice;

import java.util.ArrayList;
import java.util.List;

public class Exercice {
    //Version de test on en fait une qui marche
    public static List<String> solution(String texte, List<Character> ordre) {
        List<String> listeMotsTries = new ArrayList<>();
        String[] arrayMotsNonTries = texte.split("[^a-zA-Z0-9]");
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

    

    //Solution pire simplicité
    public static List<String> solutionPireSimp(String texte, List<Character> ordre) {List<String> mots = new ArrayList<String>();String[] motsArray = texte.split("[^a-zA-Z]+");for (char lettre : ordre) {for (String mot : motsArray) {if (!mot.isEmpty() && mot.charAt(0) == lettre) {mots.add(mot);}}}for (String mot : motsArray) {if (!mot.isEmpty() && !mots.contains(mot)) {mots.add(mot);}}return mots;}



}

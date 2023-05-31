package exercice;

import java.util.ArrayList;
import java.util.List;

public class Exercice {
    //Version de test on en fait une qui marche
    public static List<String> solution(String texte, List<Character> ordre) {
        List<String> mots = new ArrayList<String>();
        String[] motsArray = texte.split("[^a-zA-Z0-9]");
        for (char lettre : ordre) {
            for (String mot : motsArray) {
                if (!mot.isEmpty() && mot.charAt(0) == lettre) {
                    mots.add(mot);
                    mot="";
                }
            }
        }
        for (String mot : motsArray) {
            if (!mot.isEmpty() && !mots.contains(mot)) {
                mots.add(mot);
            }
        }
        return mots;
    }

    //Solution pire efficacité
    public static List<String> solutionPireEff(String texte, List<Character> ordre) {
        List<String> mots = new ArrayList<String>();
        List<String> motsArray = new ArrayList<>();
        StringBuilder motCourant = new StringBuilder();

        for (int i = 0; i < texte.length(); i++) {
            char caractere = texte.charAt(i);
            
            // Vérifie si le caractère est une lettre
            if (Character.isLetter(caractere)) {
                motCourant.append(caractere);
            } else {
                // Si le mot courant n'est pas vide, l'ajoute à la liste de mots
                if (motCourant.length() > 0) {
                    motsArray.add(motCourant.toString());
                    motCourant.setLength(0); // Réinitialise le mot courant
                }
            }
        }
        // Ajoute le dernier mot si le texte se termine par une lettre
        if (motCourant.length() > 0) {
            motsArray.add(motCourant.toString());
        }
        for (char lettre : ordre) {
            for (String mot : motsArray) {
                if (mot.charAt(0) == lettre) {
                    mots.add(mot);
                }
            }
        }
        for (String mot : motsArray) {
            boolean motExiste = false;
        
            // Vérifie si le mot est déjà présent dans la liste
            for (String motExist : mots) {
                if (motExist.equals(mot)) {
                    motExiste = true;
                    break;
                }
            }
        
            // Ajoute le mot à la liste si ce n'est pas déjà le cas
            if (!motExiste) {
                mots.add(mot);
            }
        }
        return mots;
    }

    //Solution pire simplicité
    public static List<String> solutionPireSimp(String texte, List<Character> ordre) {List<String> mots = new ArrayList<String>();String[] motsArray = texte.split("[^a-zA-Z]+");for (char lettre : ordre) {for (String mot : motsArray) {if (!mot.isEmpty() && mot.charAt(0) == lettre) {mots.add(mot);}}}for (String mot : motsArray) {if (!mot.isEmpty() && !mots.contains(mot)) {mots.add(mot);}}return mots;}
}

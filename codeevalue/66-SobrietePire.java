package exercice;

import java.util.ArrayList;
import java.util.List;

public class SobrietePire {

    public static List<String> solution(String str, List<Character> ordre) {
        List<String> motOrdreList = new ArrayList<>(); // Liste des mots dans l'ordre 
        List<String> motSepareList = new ArrayList<>(); // Liste des mots séparés par des espaces, des apostrophes et des virgules
    
        String[] motsSepares = str.split("[,\\s']+"); // Séparer la chaîne en mots en utilisant des espaces, des apostrophes et des virgules comme délimiteurs
    
        for (String motSep : motsSepares) { // Parcourir chaque mot séparé 
            motSepareList.add(motSep); // Ajouter le mot à la liste des mots séparés 
        } 
    
        if (str.isEmpty()) { // Si la chaîne de caractère est vide 
            motOrdreList.add(""); // Ajouter un mot vide à la liste des mots dans l'ordre
        } else {
            for (char motOrd : ordre) { // Parcourir chaque caractère de la liste des ordres 
                for (String motSep : motSepareList) { // Parcourir chaque mot de la liste des mots séparés 
                    if (motSep.charAt(0) == motOrd) { // Si le premier caractère du mot est égal à l'ordre 
                        motOrdreList.add(motSep); // Ajouter le mot à la liste des mots dans l'ordre 
                    }
                }
            }
            motSepareList.removeAll(motOrdreList); // Supprimer les mots déjà présents dans la liste des mots dans l'ordre
    
            // Ajouter les mots restants à la liste des mots dans l'ordre
            motOrdreList.addAll(motSepareList);
        }
        return motOrdreList; // Retourne la liste des mots dans l'ordre
    }
}

// Point de vue de la complexité algorithmique, cette solution est pire que la solution de SimpliciteMeilleur.java car elle utilise deux boucles imbriquées pour parcourir les mots séparés et les ordres.
// La liste motOrdreList sera d'abord remplie avec les mots correspondant à l'ordre spécifié, puis les mots restants de motSepareList seront ajoutés à la liste.
    

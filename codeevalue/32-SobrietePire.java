package src.main.java.exercice;

import java.util.ArrayList;
import java.util.List;

public class SobrieteMeilleur {
    public static class Arbre { private Arbre gauche; private Arbre droite; private String valeur; public Arbre(String valeur) { this.valeur = valeur; gauche = null; droite = null; } }
    public static List<String> sortWords(String texte, List<Character> ordre) { List<String> mots = new ArrayList<>(); ArrayList<String> motsArray = textToList(texte); Arbre root = null; for (String mot : motsArray) { char premierCaractere = mot.charAt(0); if (ordre.contains(premierCaractere)) { root = ajouterNoeud(root, mot, ordre); } else { mots.add(mot); } } getSortedWords(root, mots); return mots; }
    public static ArrayList<String> textToList(String str) { str = str.replaceAll("[^a-zA-Z0-9]+", " ").trim(); String mot = ""; ArrayList<String> motsep = new ArrayList<String>(); for (int index = 0; index < str.length(); index++) { char car = str.charAt(index); if (car == ' ') { motsep.add(mot.trim()); mot = ""; } mot += car; } if (mot != "") { motsep.add(mot.trim()); } return motsep; }
    private static Arbre ajouterNoeud(Arbre racine, String mot, List<Character> ordre) { if (racine == null) { return new Arbre(mot); } char premierCaractere = mot.charAt(0); char rootPremierCaractere = racine.valeur.charAt(0); if (ordre.indexOf(premierCaractere) <= ordre.indexOf(rootPremierCaractere)) { racine.gauche = ajouterNoeud(racine.gauche, mot, ordre); } else { racine.droite = ajouterNoeud(racine.droite, mot, ordre); } return racine; }
    private static void getSortedWords(Arbre node, List<String> mots) { if (node != null) { getSortedWords(node.gauche, mots); mots.add(node.valeur); getSortedWords(node.droite, mots); } }
    public static List<String> solution(String str, List<Character> ordre) { List<String> result = sortWords(str, ordre); if (result.size() == 0) return List.of(""); return result; }
}

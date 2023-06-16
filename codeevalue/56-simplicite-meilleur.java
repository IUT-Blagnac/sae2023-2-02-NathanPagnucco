package exercice;

import java.util.ArrayList;
import java.util.List;

public class exercice {

    public static List<String> solution(String texte, List<Character> ordre) {
        List<String> mots = new ArrayList<>();
        String[] motsTexte = texte.split(" ");

        for (char lettre : ordre) {
            for (String mot : motsTexte) {
                if (mot.charAt(0) == lettre) {
                    mots.add(mot);
                }
            }
        }

        return mots;
    }
}
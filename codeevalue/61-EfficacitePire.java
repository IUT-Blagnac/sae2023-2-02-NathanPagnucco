package exercice;

import java.util.ArrayList;
import java.util.List;

public class EfficacitePire {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> result = new ArrayList<>();

        List<String> mots = new ArrayList<>();
        String mot = "";
        for (int i = 0; i < str.length(); i++) {
            // On ne peut pas utiliser la méthode isLetterOrDigit, on va donc utiliser (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= '0' && str.charAt(i) <= '9')
            if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                mot += str.charAt(i);
            } else {
                if (!mot.isEmpty()) {
                    mots.add(mot);
                    mot = "";
                }
            }
        }
        if (!mot.isEmpty()) {
            mots.add(mot);
        }

        for (Character c : ordre) {
            for (String m : mots) {
                if (!m.isEmpty() && m.charAt(0) == c) {
                    result.add(m);
                }
            }
        }

        for (String m : mots) {
            boolean contient = false;
            for (String r : result) {
                if (r.equals(m)) {
                    contient = true;
                }
            }
            if (!contient && !m.equals("")) {
                result.add(m);
            }
        }

        if (str.isEmpty()) {
            result.add("");
        }

        return result;
    }
}
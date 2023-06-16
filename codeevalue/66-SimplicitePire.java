package exercice;

import java.util.ArrayList;
import java.util.List;

public class SimplicitePire {
    
    public static List<String> solution(String s, List<Character> o) {
        List<String> m = new ArrayList<>(); // permet de stocker les mots dans l'ordre
        List<String> l = new ArrayList<>(); // permet de stocker les mots dans l'ordre
        String w = ""; // permet de stocker les mots dans l'ordre
    
        for (char c : s.toCharArray()) { // permet de stocker les mots dans l'ordre
            if (c == ' ' || c == '\'' || c == ',') { // permet de stocker les mots dans l'ordre
                if (!w.isEmpty()) { // permet de stocker les mots dans l'ordre
                    l.add(w); // permet de stocker les mots dans l'ordre
                    w = ""; // permet de stocker les mots dans l'ordre
                }
            } else {
                w += c; // permet de stocker les mots dans l'ordre
            }
        }
    
        if (!w.isEmpty()) { // permet de stocker les mots dans l'ordre
            l.add(w); // permet de stocker les mots dans l'ordre
        }
    
        if (s.isEmpty()) { // permet de stocker les mots dans l'ordre
            m.add(""); // permet de stocker les mots dans l'ordre
        } else {
            for (char mo : o) { // permet de stocker les mots dans l'ordre
                for (String ms : l) { // permet de stocker les mots dans l'ordre
                    if (ms.charAt(0) == mo) { // permet de stocker les mots dans l'ordre
                        m.add(ms); // permet de stocker les mots dans l'ordre
                    }
                }
            }
    
            for (String ms : l) { // permet de stocker les mots dans l'ordre
                if (!m.contains(ms)) { // permet de stocker les mots dans l'ordre
                    m.add(ms); // permet de stocker les mots dans l'ordre
                }
            }
        }
    
        return m; // permet de stocker les mots dans l'ordre
    }
}
// Les noms de variables courts et peu explicites rendent le code difficile à comprendre.
// La logique est difficile à suivre.

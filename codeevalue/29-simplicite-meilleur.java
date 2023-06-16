package exercice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {

        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < ordre.size(); i++) {
            orderMap.put(ordre.get(i), i);
        }

        List<String> mots = new ArrayList<>();
        StringBuilder motCourant = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                motCourant.append(c);
            } else if (motCourant.length() > 0) {
                mots.add(motCourant.toString());
                motCourant.setLength(0);
            }
        }

        if (motCourant.length() > 0) { 
            mots.add(motCourant.toString());
        }

        mots.sort((mot1, mot2) -> compareWords(mot1, mot2, orderMap));

        return mots;
    }

    private static int compareWords(String mot1, String mot2, Map<Character, Integer> orderMap) {
        int minLength = Math.min(mot1.length(), mot2.length());
        for (int i = 0; i < minLength; i++) {
            char c1 = mot1.charAt(i);
            char c2 = mot2.charAt(i);
            int index1 = orderMap.getOrDefault(c1, orderMap.size());
            int index2 = orderMap.getOrDefault(c2, orderMap.size());
            if (index1 != index2) {
                return Integer.compare(index1, index2);
            }
        }
        return Integer.compare(mot1.length(), mot2.length());
    }
}

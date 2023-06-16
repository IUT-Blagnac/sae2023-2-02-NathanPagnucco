package exercice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {

        List<String> words;
        ArrayList<String> result = new ArrayList<>();
        
        if (str.length() == 0) {
            return List.of("");
        }

        str = str.replace(",", "");
        str = str.replace("'", " ");

        words = new ArrayList<>(Arrays.asList(str.split(" ")));

        for (Character c : ordre) {
            for (int i=0; i<words.size(); i++) {
                if (words.get(i).charAt(0) == c) {
                    result.add(words.get(i));
                    words.remove(i);
                    i--;
                }
            }
        }

        result.addAll(words);

        return result;
    }
}

package exercice;

import java.util.ArrayList;
import java.util.List;
public class efficacitemeilleur {

    //Solution meilleur efficacité
    public static List<String> solution(String texte, List<Character> ordre) {
        int tailleTexte = texte.length();
        int cptMots = 1;
        int cptMotsTries = 0;
        ArrayList<Integer> initialesInd = new ArrayList<Integer>();
        initialesInd.add(0);
        for (int i = 0; i < tailleTexte; i++) {
            char caractere = texte.charAt(i);
            if (!Character.isLetterOrDigit(caractere)) { //Caractère non alphanumérique
                cptMots++;
                if(Character.isLetterOrDigit(texte.charAt(i+1))) {
                    initialesInd.add(i+1);
                }
            }
        }
        initialesInd.add(tailleTexte+1);
        String[] mots = new String[cptMots];
        Boolean[] motsTries = new Boolean[cptMots];
        StringBuilder mot = new StringBuilder();
        for (char lettre : ordre) {
            for (int i=0;i<cptMots;i++) {
                int initInd = initialesInd.get(i);
                if (texte.charAt(initInd) == lettre) {
                    for(int y = initInd; y < initialesInd.get(i+1)-1; y++) {
                        mot.append(texte.charAt(y));
                    }
                    mots[cptMotsTries] = mot.toString();
                    mot = new StringBuilder();
                    cptMotsTries++;
                    motsTries[i] = true;
                }
            }
        }
        for (int i=0;i<cptMots-1;i++) {
            if (motsTries[i] == null) {
                int initInd = initialesInd.get(i);
                for(int y = initInd; y < initialesInd.get(i+1)-1; y++) {
                    mot.append(texte.charAt(y));
                }
                mots[cptMotsTries] = mot.toString();
                mot = new StringBuilder();
                cptMotsTries++;
            }
        }

        return List.of(mots);
    }
}

package exercice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;



//Deplacer ce fichier dans le dossier src\main\java\exercice
public class Chrono 
{
    static final String petitTexte = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse";
    static final String moyenTexte = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam. Maecenas ligula massa, varius a, semper congue, euismod non, mi.";
    static final String grandTexte = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.";
    /**
     * Fonction qui prend en parametre une fonction et qui calcule le temps d'execution de cette fonction
     * @return le temps d'execution moyen sur un petit ordre, un ordre moyen et un grand ordre en milisecondes
     */
    public static float[] calculTempsExecution(int nbTest) { 
        
        List<Character> petitOrdre = generateRandomLetterList(5);
        List<Character> moyenOrdre = generateRandomLetterList(20);
        List<Character> grandOrdre = generateRandomLetterList(26*2+10);
        long start, end,tempsMoyen = 0;
        float[] tempsExecution = new float[3];
        for(int i = 0; i < nbTest; i++)
        {
            start = System.nanoTime();
            Exercice.solution(petitTexte,petitOrdre);
            end = System.nanoTime();
            tempsMoyen += (end - start);
        }
        tempsExecution[0] = (tempsMoyen / nbTest)/1000000f;
        tempsMoyen = 0;
        for(int i = 0; i < nbTest; i++)
        {
            start = System.nanoTime();
            Exercice.solution(moyenTexte,moyenOrdre);
            end = System.nanoTime();
            tempsMoyen += (end - start);
        }
        tempsExecution[1] = (tempsMoyen / nbTest)/1000000f;
        tempsMoyen = 0;
        for(int i = 0; i < nbTest; i++)
        {
            start = System.nanoTime();
            Exercice.solution(grandTexte,grandOrdre);
            end = System.nanoTime();
            tempsMoyen += (end - start);
        }
        tempsExecution[2] =(tempsMoyen / nbTest)/1000000f;

        // tempsMoyen /= nbTest;
        return tempsExecution;
    }


    /**
     * Génère une liste de lettres aléatoires
     * @param length taille de la liste à générer
     * @return
     */
    public static List<Character> generateRandomLetterList(int length) {
        List<Character> letters = new ArrayList<>();
        Random random = new Random();
        int i = 0;
        char letter;
        while(i < length)
        {
            if (random.nextBoolean()) {
                if(random.nextBoolean())
                {
                    // Générer une lettre majuscule
                    letter = (char) (random.nextInt(26) + 'A');
                }
                else 
                {
                    //génération d'un chiffre
                    letter = (char) (random.nextInt(10) + '0');
                }
                
            } else {

                // Générer une lettre minuscule
                letter = (char) (random.nextInt(26) + 'a');
                
            }
            if(!letters.contains(letter))
            {
                letters.add(letter);
                i++;
            }
        }
        
        // Mélanger la liste de lettres
        Collections.shuffle(letters);
        
        return letters;
    }
}
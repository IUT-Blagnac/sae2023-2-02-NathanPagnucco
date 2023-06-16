import org.junit.Test;
import static org.junit.Assert.assertEquals;

import exercice.Exercice;
import java.util.*;

public class ExerciceTest {
    @Test
    public void testSolution() {
        // Chaine simple avec ordre complet
        assertEquals(List.of("666","the", "the", "number", "of", "beast"), Exercice.solution("666, the number of the beast",List.of('6', 't', 'n', 'o', 'b')));
        // Chaine à 1 mot
        assertEquals("Erreur de chaine à 1 mot", List.of("OK"), Exercice.solution("OK",List.of('a', 'b', 'c', 'd', 'e')));
        // Chaine vide
        
        assertEquals(List.of(""), Exercice.solution("",List.of('6', 't', 'n', 'o', 'b')));
        // Chaine donnée en exemple
        assertEquals(List.of("fait", "Il", "aujourd", "aout", "beau", "hui", "comme", "en"), Exercice.solution("Il fait beau aujourd'hui comme en aout",List.of('f', 'I', 'z', 'u', 'k', 'a', 'b', 'o')));
        // Ajoutez vos test ici...
        //Test avec des mots qui ont la même initiale mais pas le même ordre
        //Phrase : Le chêne est un arbre et le chien est un animal
        //Ordre : a,n,r,e,c,h,t,i,o,u,s
        assertEquals(List.of("animal","arbre","et","est","est","chene","chien","un","un","Le","le"), Exercice.solution("Le chene est un arbre et le chien est un animal",List.of('a','n','r','e','c','h','t','i','o','u','s')));
        //Test avec des virgules qui séparent les mots
        //Phrase : Bonjour,je,m'appelle Jean
        //Ordre : J,m,B,a,e,o,n,u,r
        assertEquals(List.of("Jean","m","Bonjour","appelle","je"), Exercice.solution("Bonjour,je,m'appelle Jean",List.of('J','m','B','a','e','o','n','u','r')));
    }
}
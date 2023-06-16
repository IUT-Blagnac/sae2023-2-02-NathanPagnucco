package exercice;

import java.util.List;
public class Main {
    public static void main(String[] args) {
        
        int[] test = Chrono.calculTempsExecution(1000);
        
        for(int i = 0; i < test.length; i++)
        {
            System.out.println(test[i]);
        }

        System.out.println(Exercice.solution("Bonjour,je,m'appelle Jean",List.of('J','m','B','a','e','o','n','u','r')));
        System.out.println(Exercice.solution("Le chene est un arbre et le chien est un animal",List.of('a','n','r','e','c','h','t','i','o','u','s')));
        System.out.println(Exercice.solution("Il fait beau aujourd'hui comme en aout",List.of('f', 'I', 'z', 'u', 'k', 'a', 'b', 'o')));
        System.out.println(Exercice.solution("OK",List.of('a', 'b', 'c', 'd', 'e')));
        System.out.println(Exercice.solution("666, the number of the beast",List.of('6', 't', 'n', 'o', 'b')));
    }

    
}

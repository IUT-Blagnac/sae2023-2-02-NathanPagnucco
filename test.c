#include <stdio.h>
#include "solution.h"
int main() {
    char test[] =  {'f', 'I', 'z', 'u', 'k', 'a', 'b', 'o'};
    int tailleTest = 8;
    char* result[tailleTest];
    //Premier test : resultat doit être : "fait", "Il", "aujourd", "aout", "beau", "hui", "comme", "en"
    solution(result, tailleTest, "Il fait beau aujourd’hui comme en aout", test, 8);
    for (int i = 0; i < tailleTest; i++) {
        printf("%s\n", result[i]);
    }

    char ordre2[] = {'6', 't', 'n', 'o', 'b'};
    tailleTest = 6;
    char* result2[tailleTest];
    solution(result2, tailleTest, "666, the number of the beast", ordre2, 5);
    for (int i = 0; i < tailleTest; i++) {
        printf("%s\n", result2[i]);
    }
    //Resultat doit être : "animal","arbre","et","est","est","chien","chene","un","un","Le","le"
    char ordre3[] = {'a','n','r','e','c','h','t','i','o','u','s'};
    tailleTest = 11;
    char* result3[tailleTest];
    solution(result3, tailleTest, "Le chene est un arbre et le chien est un animal", ordre3, 11);
    for (int i = 0; i < tailleTest; i++) {
        printf("%s\n", result3[i]);
    }
    getchar(); // Attend une entrée de l'utilisateur
    return 0;
    //
}
#include <stdio.h>
#include "solution.h"
#include <time.h>
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

    //Tests des temps
    clock_t start, end;
    double averageTime = 0;
    int nbTests = 1000;
    tailleTest=126;
    char* result4[tailleTest];
    //Ordre : [r, i, y, b, I, P, U, G, 0, h, 1, D, z, n, x, j, c, g, Y, R, l, o, E, B, Z, 2, w, V, 7, u, O, 9, a, M, t, v, Q, 4, p, L, q, J, 8, F, e, N, d, 3, W, X, s, T, C, A, k, f, 6, H, S, K, 5, m]
    char ordre4[] = {'r', 'i', 'y', 'b', 'I', 'P', 'U', 'G', '0', 'h', '1', 'D', 'z', 'n', 'x', 'j', 'c', 'g', 'Y', 'R', 'l', 'o', 'E', 'B', 'Z', '2', 'w', 'V', '7', 'u', 'O', '9', 'a', 'M', 't', 'v', 'Q', '4', 'p', 'L', 'q', 'J', '8', 'F', 'e', 'N', 'd', '3', 'W', 'X', 's', 'T', 'C', 'A', 'k', 'f', '6', 'H', 'S', 'K', '5', 'm'};
    for (int i = 0; i < nbTests; i++) {
        char* result4[tailleTest];
        start = clock();
        solution(result4, tailleTest, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.", ordre4, 62);
        end = clock();

        averageTime += ((double)(end - start) / CLOCKS_PER_SEC) * 1000;
    }
    averageTime /= nbTests;
    //On convertit en millisecondes

    printf("Temps moyen d'execution : %f ms\n", averageTime);
    getchar(); // Attend une entrée de l'utilisateur
    return 0;
    //
}
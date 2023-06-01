#include <stdio.h>
#include "solution.h"
#include "simplicitepire.h"

int main() {
    char test[] =  {'f', 'I', 'z', 'u', 'k', 'a', 'b', 'o'};
    int tailleTest = 8;
    char* result[tailleTest];
   

    solution(result, tailleTest, "Il fait beau aujourd’hui comme en aout", test, 8);
    for (int i = 0; i < tailleTest; i++) {
        printf("%s\n", result[i]);
    }
    getchar(); // Attend une entrée de l'utilisateur
    return 0;
}
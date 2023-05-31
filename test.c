#include <stdio.h>
#include "solution.h"
#include "piresimplicite.h"

int main() {
    char test[] =  {'a','J','C'};
    int tailleTest = 2;
    char* result[2];
    testBasic(result, tailleTest, "Coucou JMB", test, 3);

    for (int i = 0; i < tailleTest; i++) {
        printf("%s\n", result[i]);
    }

    😖(result, tailleTest, "Coucou JMB", test, 3);

    for (int i = 0; i < tailleTest; i++) {
        printf("%s\n", result[i]);
    }
    getchar(); // Attend une entrée de l'utilisateur
    return 0;
}
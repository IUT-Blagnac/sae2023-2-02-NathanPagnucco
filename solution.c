
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "solution.h"

const char* separators = " ,.;:!?";

/**
 * Fonction de tri de mots
 * @param result tableau de mots triés
 * @param tailleResult taille du tableau de mots triés
 * @param input texte à trier
 * @param ordre ordre de tri
 * @param tailleOrdre taille de l'ordre de tri
 * @return tableau de mots triés
 */
void testBasic(char** output, int tailleOutput, char* input, char* ordre, int tailleOrdre) {
    int i, j;
    int k=0;
    //Chaine de caractères modifiable
    char* inputCopy = malloc(strlen(input) + 1);
    char* tempOutput[tailleOutput];
    int found[tailleOutput];
    for (j = 0; j < tailleOutput; j++) {
        found[j] = 0;
    }
    strcpy_s(inputCopy, strlen(input) + 1, input);
    // Création d'un tableau de mots
    char* mot = strtok(inputCopy, separators);
    while (mot != NULL) {
        tempOutput[k] = (char*)malloc(sizeof(char)* strlen(mot) + 1);
        strcpy_s(tempOutput[k], strlen(mot) + 1, mot);
        k++;
        mot = strtok(NULL , separators);
    }
    free(inputCopy);
    //Tri du tableau de tempOutput
    //On parcoure l'ordre
    k=0;
    for(i = 0; i < tailleOrdre; i++) {
        //On parcourt le tableau de mots
        for(j = 0; j < tailleOutput; j++) {
            //Si le mot est égal à l'ordre
            if(tempOutput[j][0] == ordre[i]) {
                //On l'ajoute au tableau de sortie
                output[k] = "";
                output[k] = tempOutput[j];
                found[j] = 1;
                k++;
            }
        }
    }
    //On rajoute le reste des mots dans tempOutput
    for(j = 0; j < tailleOutput; j++) {
        if(!found[j]) {
            output[k] = "";
            output[k] = tempOutput[j];
            k++;
        }
    }
}


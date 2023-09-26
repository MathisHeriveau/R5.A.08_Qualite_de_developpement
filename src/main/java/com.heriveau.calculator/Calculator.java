package com.heriveau.calculator;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

    public int add(int opG, int opD) {
        if ((opG > 0 && opD > Integer.MAX_VALUE - opG) || (opG < 0 && opD < Integer.MIN_VALUE - opG)) {
            // Gérer le dépassement de la plage autorisée pour un entier
            System.err.println("Dépassement de la plage autorisée pour un entier lors de l'addition.");
            return 0; // Ou tout autre traitement d'erreur approprié
        } else {
            // Effectuer l'addition en toute sécurité
            return opG + opD;
        }
    }

    public int divise(int opG, int opD) {
        if (opD == 0) {
            // Gérer la division par zéro
            System.err.println("Division par zéro détectée.");
            return 0; // Ou tout autre traitement d'erreur approprié
        } else {
            // Effectuer la division en toute sécurité
            return opG / opD;
        }
    }

    public Set<Integer> ensembleChiffres(int pNombre) {
        Set<Integer> chiffres = new HashSet<>();

        // Convertir le nombre en positif si nécessaire
        int nombre = Math.abs(pNombre);

        // Traitement spécial pour 0
        if (nombre == 0) {
            chiffres.add(0);
            return chiffres;
        }

        while (nombre > 0) {
            int chiffre = nombre % 10;
            chiffres.add(chiffre);
            nombre /= 10;
        }

        return chiffres;
    }

}

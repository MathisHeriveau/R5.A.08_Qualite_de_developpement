package com.heriveau.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        /* On construit un objet Calculator */
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1, 1",
            "1, 2, 3",
            "-2, 2, 0",
            "0, 0, 0",
            "-1, -2, -3"
    })
    void verification_fonction_addition(int opG, int opD, int resultatAttendu) {
        int resultat = calculator.add(opG, opD);
        assertEquals(resultatAttendu, resultat);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1, 0",
            "1, 2, 0",
            "-2, 2, -1",
            "0, 0, 0",
            "-1, -2, 0"
    })
    void verification_fonction_division(int opG, int opD, int resultatAttendu) {
        int resultat = calculator.divise(opG, opD);
        assertEquals(resultatAttendu, resultat);
    }

    @Test
    void testEnsembleChiffresPositif() {
        int nombre = 7679;
        Set<Integer> chiffres = calculator.ensembleChiffres(nombre);

        assertTrue(chiffres.contains(6));
        assertTrue(chiffres.contains(7));
        assertTrue(chiffres.contains(9));
        assertEquals(3, chiffres.size());
    }

    @Test
    void testEnsembleChiffresNegatif() {
        int nombre = -11;
        Set<Integer> chiffres = calculator.ensembleChiffres(nombre);

        assertTrue(chiffres.contains(1));
        assertEquals(1, chiffres.size());
    }

    @Test
    void testEnsembleChiffresZero() {
        int nombre = 0;
        Set<Integer> chiffres = calculator.ensembleChiffres(nombre);

        assertTrue(chiffres.contains(0));
        assertEquals(1, chiffres.size());
    }

    @Test
    void testEnsembleChiffresNegatifZero() {
        int nombre = -0;
        Set<Integer> chiffres = calculator.ensembleChiffres(nombre);

        assertTrue(chiffres.contains(0));
        assertEquals(1, chiffres.size());
    }

    @Test
    void testEnsembleChiffresGrandNombre() {
        int nombre = 1234567890;
        Set<Integer> chiffres = calculator.ensembleChiffres(nombre);

        assertTrue(chiffres.contains(0));
        assertTrue(chiffres.contains(1));
        assertTrue(chiffres.contains(2));
        assertTrue(chiffres.contains(3));
        assertTrue(chiffres.contains(4));
        assertTrue(chiffres.contains(5));
        assertTrue(chiffres.contains(6));
        assertTrue(chiffres.contains(7));
        assertTrue(chiffres.contains(8));
        assertTrue(chiffres.contains(9));
        assertEquals(10, chiffres.size());
    }

    @Test
    void testEnsembleChiffresZeroMultiple() {
        int nombre = 10000;
        Set<Integer> chiffres = calculator.ensembleChiffres(nombre);

        assertTrue(chiffres.contains(0));
        assertTrue(chiffres.contains(1));
        assertEquals(2, chiffres.size());
    }

    @AfterEach
    void tearDown() {
        /* On détruit l'objet Calculator */
        calculator = null;
    }
}

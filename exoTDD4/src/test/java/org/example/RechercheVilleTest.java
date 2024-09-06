package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class RechercheVilleTest {

        private RechercheVille rechercheVille;

        @BeforeEach
        public void setUp() {
            rechercheVille = new RechercheVille();
        }

        @Test
        public void testRechercherAvecMoinsDeDeuxCaracteres() {
            assertThrows(NotFoundException.class, () -> {
                rechercheVille.Rechercher("A");
            });
        }

        @Test
        public void testRechercherAvecDeuxCaracteres()  throws NotFoundException {
            List<String> result = rechercheVille.Rechercher("Va");
            assertTrue(result.contains("Valence"));
            assertTrue(result.contains("Vancouver"));
            assertEquals(2, result.size());
        }

        @Test
        public void testRechercherInsensibleACasse()  throws NotFoundException {
            List<String> result = rechercheVille.Rechercher("lOnDoN");
            assertTrue(result.contains("Londres"));
            assertEquals(1, result.size());
        }

        @Test
        public void testRechercherPartieDuNomDeVille() throws NotFoundException {
            List<String> result = rechercheVille.Rechercher("ape");
            assertTrue(result.contains("Budapest"));
            assertEquals(1, result.size());
        }

        @Test
        public void testRechercherAvecAsterisque()  throws NotFoundException {
            List<String> result = rechercheVille.Rechercher("*");
            assertEquals(14, result.size());
        }
}


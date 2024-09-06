package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RechercheVille {
    private List<String> villes;

    public RechercheVille() {
        // Liste initiale de villes
        this.villes = Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valence",
                "Vancouver", "Amsterdam", "Vienne", "Sydney",
                "New York", "Londres", "Bangkok", "Hong Kong",
                "Dubaï", "Rome", "Istanbul");
    }

    public List<String> Rechercher(String mot) throws NotFoundException {
        if (mot.length() < 2) {
            throw new NotFoundException("Le texte de recherche doit contenir au moins 2 caractères.");
        }

        List<String> resultats = new ArrayList<>();
        String motMinuscule = mot.toLowerCase();

        for (String ville : villes) {
            if (motMinuscule.equals("*") || ville.toLowerCase().contains(motMinuscule)) {
                resultats.add(ville);
            }
        }

        return resultats;
    }
}
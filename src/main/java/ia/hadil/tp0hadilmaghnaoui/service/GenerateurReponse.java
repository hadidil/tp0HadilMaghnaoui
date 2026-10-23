
package ia.hadil.tp0hadilmaghnaoui.service;

import jakarta.enterprise.context.Dependent;

import java.io.Serializable;
import java.text.Normalizer;
import java.util.Locale;

@Dependent
public class GenerateurReponse implements Serializable {

    public String genererReponse(String question, String roleSysteme) {

        // Convertir la question en minuscules et supprimer les accents
        String texte = Normalizer.normalize(
                question.toLowerCase(Locale.FRENCH),
                Normalizer.Form.NFD
        ).replaceAll("\\p{M}", "");

        String resultat;

        // 1. Gestion des examens
        if (texte.contains("examen") || texte.contains("controle")
                || texte.contains("revision")) {

            resultat = "Plan de revision rapide :\n\n"
                    + "1. Identifie les chapitres les plus importants.\n"
                    + "2. Passe 25 minutes a reviser un chapitre.\n"
                    + "3. Fais des exercices sans regarder la correction.\n"
                    + "4. Termine par une petite revision des points difficiles.\n\n"
                    + "Conseil : garde aussi du temps pour dormir.";

            // 2. Procrastination
        } else if (texte.contains("procrastin")
                || texte.contains("remettre a plus tard")
                || texte.contains("commencer a travailler")) {

            resultat = "Pour arreter de procrastiner :\n\n"
                    + "1. Choisis une seule petite tache.\n"
                    + "2. Travaille dessus pendant seulement 5 minutes.\n"
                    + "3. Eloigne ton telephone.\n"
                    + "4. Continue si tu te sens motive.\n\n"
                    + "Objectif : commence petit, sans chercher la perfection.";

            // 3. Manque de concentration
        } else if (texte.contains("concentr")
                || texte.contains("distraction")
                || texte.contains("distrait")) {

            resultat = "Pour mieux te concentrer :\n\n"
                    + "1. Mets ton telephone en mode silencieux.\n"
                    + "2. Choisis un endroit calme.\n"
                    + "3. Travaille 25 minutes sans interruption.\n"
                    + "4. Prends une pause de 5 minutes.\n\n"
                    + "Repete ce cycle selon tes besoins.";

            // 4. Trop de travail
        } else if (texte.contains("devoir")
                || texte.contains("trop de travail")
                || texte.contains("deborde")
                || texte.contains("organiser")) {

            resultat = "Organisons tes priorites :\n\n"
                    + "1. Note toutes les taches a faire.\n"
                    + "2. Commence par celle qui est la plus urgente.\n"
                    + "3. Divise les gros travaux en petites etapes.\n"
                    + "4. Fixe une heure limite pour chaque tache.\n\n"
                    + "Astuce : concentre-toi sur une seule tache a la fois.";

            // 5. Fatigue et manque d'energie
        } else if (texte.contains("fatigu")
                || texte.contains("energie")
                || texte.contains("epuise")) {

            resultat = "Pour mieux gerer ton energie :\n\n"
                    + "1. Fais une courte pause si tu en as besoin.\n"
                    + "2. Bois de l'eau et prends un repas adapte.\n"
                    + "3. Alterne les periodes de travail et de repos.\n"
                    + "4. Essaie de garder un sommeil regulier.\n\n"
                    + "Travailler plus longtemps n'est pas toujours travailler mieux.";

            // 6. Motivation
        } else if (texte.contains("motivation")
                || texte.contains("decourage")
                || texte.contains("abandonner")) {

            resultat = "Tu n'as pas besoin de tout terminer aujourd'hui.\n\n"
                    + "Choisis un objectif simple et realisable, puis avance "
                    + "etape par etape.\n\n"
                    + "Meme 15 minutes de travail peuvent te permettre "
                    + "de progresser. Commence par une petite action.";

            // 7. Question non reconnue
        } else {

            resultat = "Je suis StudyMate, ton assistant de productivite "
                    + "etudiante !\n\n"
                    + "Je peux t'aider a :\n"
                    + "- preparer un examen ;\n"
                    + "- lutter contre la procrastination ;\n"
                    + "- ameliorer ta concentration ;\n"
                    + "- organiser tes devoirs ;\n"
                    + "- gerer ta fatigue ;\n"
                    + "- retrouver ta motivation.\n\n"
                    + "Decris-moi ta difficulte pour recevoir un conseil adapte.";
        }

        return resultat;
    }
}

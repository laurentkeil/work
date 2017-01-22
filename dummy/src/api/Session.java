package api;

import java.util.List;

public interface Session {
    /**
     *
     * @return la liste des cours, et une liste vide si pas de cours.
     */
    List<Course> getCourses();
    /**
     * Ferme la session et libère les ressources éventuelles.
     */
    void closeSession();
}

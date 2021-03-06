package api;

/**
 *  Impl�mentation des fonctionnalit�s de claroline pouvant etre utilis�es sur la partie client. Cr�e une session et un cookie pour l'utilisateur voulant se connecter, acc�dant � ces fonctionnalit�s.
 * @author Keil Laurent
 * @version 1.1
 */
public interface Session {
	/**
	 * Ferme la session et lib�re les ressources �ventuelles.</br>
     * @throws Exception si l'utilisateur n'est pas connect� ou le cookie non-valide.
	 */
	void closeSession() throws Exception;
    /**
	 * @return un objet UserData contenant des informations pouvant �tre obtenues sur l'utilisateur connect�.
     * @throws Exception si l'utilisateur n'est pas connect� ou le cookie non-valide.
	 */ 
    UserData getUserData() throws Exception;	
	/**
     * @return un objet Courses contenant des informations sur les cours de l'utilisateur connect�.
     * @throws Exception si l'utilisateur n'est pas connect� ou le cookie non-valide.
     */
    Courses getCourses() throws Exception;
    /**	 
	 * @return un objet Updates contenant des informations sur les modifications apport�es depuis la derni�re connexion de l'utilisateur connect�.
	 * @throws Exception si l'utilisateur n'est pas connect� ou le cookie non-valide.
	 */
    Updates getUpdates() throws Exception;
}
	
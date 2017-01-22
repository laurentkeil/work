
package api;

/**
 * permet d'obtenir et de donner des informations séparément sur une modification particulière d'une ressource d'un module d'un cours de l'utilisateur connecté depuis sa dernière connexion.
 * Les setters de cette interface ne sont qu'utilitaire à l'interface Updates. Elles ne <b>peuvent pas<b> être appelés par la partie cliente.
 * @author Keil Laurent
 */
public interface Update {
	
	/**
	 * place string comme syscode de l'objet Update
	 * @param string : le code du cours qui a subi une modification depuis la dernière connexion de l'utilisateur connecté.
	 */
	void setSysCode(String string);
	/**
	 * place string comme tagModule de l'objet Update
	 * @param string : le code du module qui a subi une modification depuis la dernière connexion de l'utilisateur connecté.
	 */
	void setTagModule(String string);
	/**
	 * place string comme resID de l'objet Update
	 * @param string : le code de la ressource qui a subi une modification depuis la dernière connexion de l'utilisateur connecté.
	 */
	void setResID(String string);
	/**
	 * place string comme date de l'objet Update
	 * @param string : la date du la ressource qui a subi une modification depuis la dernière connexion de l'utilisateur connecté.
	 */
	void setDate(String string);
	/**
	 * @return syscode : le code du cours qui a subi une modification depuis la dernière connexion de l'utilisateur connecté.
	 */
	String getSysCode();
	/**
	 * @return string : le code du module qui a subi une modification depuis la dernière connexion de l'utilisateur connecté.
	 */
	String getTagModule();
	/**
	 * @return string : le code de la ressource qui a subi une modification depuis la dernière connexion de l'utilisateur connecté.
	 */
	String getResID();
	/**
	 * @return string : la date du la ressource qui a subi une modification depuis la dernière connexion de l'utilisateur connecté.
	 */
	String getDate();

}

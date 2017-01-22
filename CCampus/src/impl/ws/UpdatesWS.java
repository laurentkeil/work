
package impl.ws;


import java.io.Serializable;
import java.util.Iterator;

import impl.ws.services.JsonConvertor;

import org.json.JSONException;
import org.json.JSONObject;

import api.Update;

/**
 * implémention avec les données des webservices de Claroline.
 * @author Keil Laurent
 * @see api.Updates
 */
public class UpdatesWS implements api.Updates, Serializable {
	
	 /**
	  * Référence de sérialisation
	  */
	private static final long serialVersionUID = 4982908816389444731L;
	/**
	 * taille du tableau tabUpdate
	 */
	private int taille = 5000;
	/**
	 * un tableau d'objet Update contenant nbUpdates updates et des informations les concernant pour l'utilisateur connecté depuis sa dernière connexion.
	 * </br>Seulement ces nbUpdates premières cases du tableau sont accessibles.
	 */
	private Update[] tabUpdate = new Update[taille];
	/**
	 * le nombre d'updates de ressources différentes depuis la dernière connexion de l'utilisateur connecté.
	 */
	private int nb;
	
	/**
	 * domaine de l'url
	 */
	private String domaine;
	/**
	 * url à accéder
	 */
	private String url;
	
	/**
	 * Contructeur de l'Objet UpdatesWS.</br>
	 * Placement des valeurs des updates dans le tableau tabUpdate en créant nb objet Update.
	 * @throws Exception : si l'utilisateur n'est pas connecté.
	 */
	public UpdatesWS() throws Exception {		

		this.domaine = "https://chouettecampus.info.fundp.ac.be/module/MOBILE/index.php?Method=";
		 
		// url pour la requête
		this.url = domaine+"getUpdates";

			// Creating JSON Parser instance
		JsonConvertor jParser = new JsonConvertor();
			 
			// getting JSON string from URL
		JSONObject json = jParser.getJSONObjectFromUrl(url);
		
		this.nb=0;
		
		try {
		  /*
		   * parcours des updates 0 à nbUpdates() et placement des valeurs des updates dans le tableau tabUpdate en créant nb objet Update.
		   */
		  for (Iterator iterator1 = json.keys(); iterator1.hasNext();) {
		    Object cours = iterator1.next();
		    JSONObject val1 = json.getJSONObject(cours.toString());
		    
		    for (Iterator iterator2 = val1.keys(); iterator2.hasNext();) {
			    Object module = iterator2.next();
			    JSONObject val2 = val1.getJSONObject(module.toString());
			    
			    for (Iterator iterator3 = val2.keys(); iterator3.hasNext();) {
				    Object ressource = iterator3.next();
				    JSONObject val3 = val2.getJSONObject(ressource.toString());
				    
				    for (Iterator iterator4 = val3.keys(); iterator4.hasNext();) {
					    Object cle = iterator4.next();
					    Object val4= val3.get(cle.toString());
					   
					    Update up = new UpdateWS();
					    up.setSysCode(cours.toString());				    
					    up.setTagModule(module.toString());
					    up.setResID(ressource.toString());
					    up.setDate(val4.toString());
					    this.tabUpdate[this.nb] = up;

					  }
				    this.nb++;
				  }
			    
			  }
		    
		  }
		 
		} catch (JSONException e) {
			e.printStackTrace(); 
		}
		
	}
	
	@Override
	public Update[] getUpdatesTab() throws JSONException{
		return tabUpdate;
	}
	
	@Override
	public int nbUpdates() throws JSONException{	
		return nb;
	}
	
	
}

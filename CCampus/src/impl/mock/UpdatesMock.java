package impl.mock;

import impl.ws.UpdateWS;

import java.io.Serializable;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import api.Update;

/** 
 * implémention mock avec des données tests de l'interface.
 * @author Keil Laurent
 * @see api.Updates
 */
public class UpdatesMock implements api.Updates, Serializable {

	 /**
	  * Référence de sérialisation
	  */
	private static final long serialVersionUID = -8607560392016316623L;
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
	 * Constructeur / post de données test pour le mock
	 */
	public UpdatesMock() {

		JSONObject json = new JSONObject();
		JSONObject cours1 = new JSONObject();
		JSONObject cours2 = new JSONObject();
		JSONObject module1 = new JSONObject();
		JSONObject module2 = new JSONObject();
		JSONObject ressource1 = new JSONObject();
		JSONObject ressource2 = new JSONObject();
		JSONObject ressource3 = new JSONObject();
		
		try {
		  ressource1.put("ressourceId", "1");
		  ressource1.put("date", "2012-11-21 17:56:34");
		  ressource2.put("ressourceId", "2");
		  ressource2.put("date", "2012-11-21 17:57:01");
		  ressource3.put("ressourceId", "3");
		  ressource3.put("date", "2012-11-21 18:57:01"); 
		  module1.put("1", ressource1);
		  module2.put("2", ressource2);
		  module1.put("3", ressource3);
	      cours2.put("CLDOC", module2);
		  cours1.put("CLANN", module1);
		  json.put("B", cours1);
		  json.put("H1", cours2);
		}catch (JSONException e) {
			e.printStackTrace(); 		
		}
		
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
		return this.nb;
	}

}

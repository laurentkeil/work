package impl.mock;

import java.io.IOException;
import java.io.Serializable;

import impl.ws.AnnonceWS;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import api.Annonce;

/**
* implémention mock avec des données tests de l'interface.
* @see api.Annonces
* @author Keil Laurent
*/
public class AnnoncesMock implements api.Annonces, Serializable  {


	/**
	 * Référence de sérialisation
	 */
	private static final long serialVersionUID = 2617625294127033504L;
	/**
	 * code de l'annonce
	 */
	private String sysCode;
	/**
	 * tableau d'id des annonces
	 */
	private int[] idTab = new int[5000];
	/**
	 * tableau de titre des annonces
	 */
	private String[] titleTab = new String[5000];
	/**
	 * Chaine de caractère contenant le fichier au format JSON
	 */
	private String annoncesStr;
	
	
	/**
	 * Constructeur de l'objet AnnoncesMock / place les champs d'annonces ressourceId et title des annonces dans leur tableau respectif.
	 * @param sysCode : le code du cours dans lequel on récupère des informations sur les annonces de ce cours.
	 * @throws JSONException : si problème de format JSON.
	 */
	public AnnoncesMock(String sysCode) throws JSONException {
		// getting JSON string from URL
		JSONArray annonces = new JSONArray();
		JSONObject ann1 = new JSONObject();
		JSONObject ann2 = new JSONObject();
		
		 try{
		    	ann1.put("title", "chouette annonce 4");
		    	ann1.put("content", "test contenu");
		    	ann1.put("visibleFrom", "null");
		    	ann1.put("visibleUntil", "null");
		    	ann1.put("time", "2012-11-21");
		    	ann1.put("visibleFrom", "null");
		    	ann1.put("visibleUntil", "null");
		    	ann1.put("visibility", "true");
		    	ann1.put("rank", "2");
		    	ann1.put("notified", "false");
		    	ann1.put("date", "2012-11-21");
		    	ann1.put("ressourceId", "4");

		    	ann2.put("title", "annonce 5");
		    	ann2.put("content", "contenu du 5");
		    	ann2.put("visibleFrom", "null");
		    	ann2.put("visibleUntil", "null");
		    	ann2.put("time", "2012-11-15");
		    	ann2.put("visibleFrom", "null");
		    	ann2.put("visibleUntil", "null");
		    	ann2.put("visibility", "true");
		    	ann2.put("rank", "3");
		    	ann2.put("notified", "false");
		    	ann2.put("date", "2012-11-15");
		    	ann2.put("ressourceId", "5");
		    	
		    }catch (JSONException e) {
		    	e.printStackTrace();
		    }

	    annonces.put(ann1);
	    annonces.put(ann2);
	    this.annoncesStr = annonces.toString();
		 
		this.sysCode = sysCode;	

        /*
         * parcours des annonces de 0 à nbAnnonces()
         * invariant : place l'id et le titre d'annonce (i-1) respectivement dans la (i-1) e case du tableau idTab et titleTab (0 < i < nbAnnonces())
         */
        for(int i = 0; i < nbAnnonces(); i++){
        	
            JSONObject ann = null;
			try {
				ann = annonces.getJSONObject(i);
			} catch (JSONException e) {
				e.printStackTrace();
			}
    		
			try {
				this.idTab[i] = ann.getInt("ressourceId");
				this.titleTab[i] = ann.getString("title");
			} catch (JSONException e) {
				e.printStackTrace();
			}
        } 
        
	}
	
	@Override
	public String getSysCode() {
		return sysCode;
	}
	
	@Override
	public int nbAnnonces() throws JSONException {
		JSONArray annonces = new JSONArray(annoncesStr);
		return annonces.length();
	}
	
	@Override
	public int[] getAllAnnoncesID() throws JSONException {
        return idTab; 
	}
	
	@Override
	public String[] getAllAnnoncesTitle() throws JSONException {
        return titleTab;          
	}
	
	@Override
	public Annonce getAnnonce(int resID) throws JSONException, IOException {
		boolean continuer = true;
		int i;
        /*
         * parcours des annonces de 0 à i (0 <= i <= nbAnnonces())
         * invariant : continuer = (idTab[i] = resID) 	pour 0 <= i <= nbAnnonces()
         */
        for(i = 0; i < nbAnnonces() && continuer; i++){	        	
			if(idTab[i] == resID){ continuer = false;}
        }
        if(continuer){
        	throw new IOException("l'id entré ne correspond à aucune annonce disponible.");
        }
        JSONArray annonces = new JSONArray(annoncesStr);
        JSONObject annObj = annonces.getJSONObject(i-1);
		String annStr = annObj.toString();
		Annonce annonce = new AnnonceWS(annStr);
		return annonce;
	}
	
	@Override
	public Annonce getAnnonce(String titre) throws JSONException, IOException {
		
		boolean continuer = true;
		int i;
        /*
         * parcours des annonces de 0 à i (0 <= i <= nbAnnonces())
         * invariant : continuer = (titleTab[i] = resID) 	pour 0 <= i <= nbAnnonces()
         */
        for(i = 0; i < nbAnnonces() && continuer; i++){	        	
			if(titleTab[i].equals(titre)){ continuer = false;}
        }
        if(continuer){
        	throw new IOException("le titre entré ne correspond à aucune annonce disponible.");
        }
        JSONArray annonces = new JSONArray(annoncesStr);
        JSONObject annObj = annonces.getJSONObject(i-1);
			 
		String annStr = annObj.toString();
		Annonce annonce = new AnnonceWS(annStr);
		return annonce;

	}
	

}


package impl.ws;

import java.io.IOException;
import java.io.Serializable;

import impl.ws.services.JsonConvertor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import api.Annonce;

/** 
 * implémention avec les données des webservices de Claroline.
 * @author Keil Laurent
 * @see api.Annonces
 */
public class AnnoncesWS implements api.Annonces, Serializable  {

	 /**
	  * Référence de sérialisation
	  */
	private static final long serialVersionUID = 2134578296274391048L;
	/**
	 * code de l'annonce
	 */
	private String sysCode;
	/**
	 * domaine de l'url
	 */
	private String domaine;
	/**
	 * url à accéder
	 */
	private String url;
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
	 * Constructeur de l'objet AnnoncesWS / place les champs d'annonces ressourceId et title des annonces dans leur tableau respectif.
	 * @param sysCode : le code du cours dans lequel on récupère des informations sur les annonces de ce cours.
	 * @throws Exception : si l'utilisateur n'est pas connecté.
	 */
	public AnnoncesWS(String sysCode) throws Exception {
		this.sysCode = sysCode;	
		
		this.domaine = "https://chouettecampus.info.fundp.ac.be/module/MOBILE/index.php?Method=";
		// url pour la requête
		this.url = domaine+"getAnnounceList&cidReq="+sysCode;
			// Creating JSON Parser instance
		JsonConvertor jParser = new JsonConvertor();
			 
			// getting JSON string from URL
		JSONArray annonces = jParser.getJSONArrayFromUrl(url);
		this.annoncesStr = annonces.toString();
        /*
         * parcours des annonces de 0 à nbAnnonces()
         * invariant : place l'id et le titre d'annonce (i-1) respectivement dans la (i-1) e case du tableau idTab et titleTab (0 < i < nbAnnonces()+1)
         */
        for(int i = 0; i < annonces.length(); i++){
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
	public Annonce getAnnonce(int resID) throws Exception {
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
		// url pour la requête
		String url = domaine+"getSingleAnnounce&cidReq="+sysCode+"&resID="+resID;
		
			// Creating JSON Parser instance
		JsonConvertor jParser = new JsonConvertor();
			 
			// getting JSON string from URL
		JSONObject ann = jParser.getJSONObjectFromUrl(url);
		String annStr = ann.toString();
		Annonce annonce = new AnnonceWS(annStr);
		return annonce;
	}
	
	@Override
	public Annonce getAnnonce(String titre) throws Exception {
		
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
		int resID = annObj.getInt("ressourceId");

		// url pour la requête
		String url = domaine+"getSingleAnnounce&cidReq="+sysCode+"&resID="+resID;

			// Creating JSON Parser instance
		JsonConvertor jParser = new JsonConvertor();
			 
			// getting JSON string from URL
		JSONObject ann = jParser.getJSONObjectFromUrl(url);
		String annStr = ann.toString();
		Annonce annonce = new AnnonceWS(annStr);
		return annonce;
	}
	
	
}

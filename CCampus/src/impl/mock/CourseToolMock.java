package impl.mock;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * implémention mock avec des données tests de l'interface.
 * @see api.CourseTool
 * @author Keil Laurent
 */
public class CourseToolMock implements api.CourseTool, Serializable  {

	 /**
	  * Référence de sérialisation
	  */
	private static final long serialVersionUID = 3907498111368813652L;
	/**
	 * code du cours
	 */
	private String sysCode;
	/**
	 * = true si il y a le module annonce pour le cours sysCode, false sinon.
	 */
	private boolean isAnn;
	/**
	 * = true si il y a au moins une notification (nouveauté) pour au moins une annonce pour le cours sysCode, false sinon.
	 */
	private boolean annNotif;
	/**
	 * = true si il y a le module document pour le cours sysCode, false sinon.
	 */
	private boolean isDnL;
	/**
	 * = true si il y a au moins une notification (nouveauté) pour au moins un document pour le cours sysCode, false sinon.
	 */
	private boolean dnlNotif;
	/**
	 * Chaine de caractère contenant le fichier au format JSON
	 */
	private String jsonStr;
	
	/**
	 * constructeur de l'objet CourseToolMock / post de données test pour le mock
	 * @param syscode : code du cours de l'utilisateur pour lequel on obtient les outils disponibes et nouveautés.
	 */
	public CourseToolMock(String syscode) {
	    JSONObject json = new JSONObject();
		try{
	    	json.put("sysCode", "H1");
	    	json.put("isAnn", true);
	    	json.put("annNotif", false);
	    	json.put("isDnL", true);
	    	json.put("dnlNotif", true);
	    }catch (JSONException e) {
	    	e.printStackTrace();
	    }
		this.jsonStr = json.toString();
	}


	@Override
	public String getSysCode() throws JSONException {
		try {	
			JSONObject json = new JSONObject(jsonStr);
			sysCode = json.getString("SysCode");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return sysCode;
	}
	
	@Override
	public boolean isAnn() throws JSONException {
		try {		
			JSONObject json = new JSONObject(jsonStr);
			isAnn = json.getBoolean("isAnn");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return isAnn;
	}
	
	@Override
	public boolean isDnL() throws JSONException {
		try {		
			JSONObject json = new JSONObject(jsonStr);
			isDnL = json.getBoolean("isDnL");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return isDnL;
	}
	
	@Override
	public boolean annNotif() throws JSONException {
		try {		
			JSONObject json = new JSONObject(jsonStr);
			annNotif = json.getBoolean("annNotif");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return annNotif;
	}
	
	@Override
	public boolean dnlNotif() throws JSONException {
		try {		
			JSONObject json = new JSONObject(jsonStr);
			dnlNotif = json.getBoolean("dnlNotif");	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return dnlNotif;
	}

}

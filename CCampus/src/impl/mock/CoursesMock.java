package impl.mock;

import java.io.IOException;
import java.io.Serializable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import api.Course;

/**
 * implémention mock avec des données tests de l'interface.
 * @see api.Courses
 * @author Keil Laurent
 */
public class CoursesMock implements api.Courses, Serializable  {

	/**
	 * Référence de sérialisation
	 */
	private static final long serialVersionUID = -3891557378317300500L;
	/**
	 * tableau d'id des cours
	 */
	private int[] idTab = new int[5000];	
	/**
	 * tableau de codes des cours
	 */
	private String[] syscodeTab = new String[5000];
	/**
	 * Chaine de caractère contenant le fichier au format JSON
	 */
	private String coursesStr;

	/**
	 * constructeur de l'objet CoursesMock / place les champs cours cours_id et sysCode des cours dans leur tableau respectif.
	 * @throws JSONException : si problème de format json
	 */
	public CoursesMock() throws JSONException {

		JSONArray courses = new JSONArray();
		JSONObject cours1 = new JSONObject();
		JSONObject cours2 = new JSONObject();
		
		try {
			cours1.put("cours_id", "1");
			cours1.put("sysCode", "H1");
			cours1.put("directory", "H1");
			cours1.put("officialCode", "H1");
			cours1.put("db", "c_H1");
			cours1.put("title", "histoire");
			cours1.put("titular", "super titulaire");
			cours1.put("language", "anglais");
			cours1.put("access", "public");
			cours1.put("status", "enable");
			cours1.put("sourceCourseId", "null");
			cours1.put("expirationDate", "null");
			cours1.put("creationDate", "1353360275");
			cours1.put("isCourseManager", "1");
			cours1.put("officialEmail", "laurent.keil@student.fundp.ac.be");
			cours1.put("notified", "true");

			cours2.put("cours_id", "2");
			cours2.put("sysCode", "SANDBOX");
			cours2.put("directory", "SANDBOX");
			cours2.put("officialCode", "SANDBOX");
			cours2.put("db", "c_SANDBOX");
			cours2.put("title", "le cours sandbox");
			cours2.put("titular", "super mega titulaire");
			cours2.put("language", "chinois");
			cours2.put("access", "public");
			cours2.put("status", "enable");
			cours2.put("sourceCourseId", "null");
			cours2.put("expirationDate", "null");
			cours2.put("creationDate", "1354315814");
			cours2.put("isCourseManager", "1");
			cours2.put("officialEmail", "");
			cours2.put("notified", "false");

		} catch (JSONException e) {
			e.printStackTrace();
		}
        courses.put(cours2);
        courses.put(cours1);
        
		this.coursesStr = courses.toString();
       
		/*
         * parcours des annonces de 0 à nbCours()
         * invariant : place l'id et le titre d'annonce (i-1) respectivement dans la (i-1) e case du tableau idTab et syscodeTab (0 < i < nbAnnonces()+1)
         */
        for(int i = 0; i < nbCours(); i++){
        	
            JSONObject c = null;
			try {
				c = courses.getJSONObject(i);
			} catch (JSONException e) {
				e.printStackTrace();
			}
    		
			try {
				this.idTab[i] = c.getInt("cours_id");
				this.syscodeTab[i] = c.getString("sysCode");
			} catch (JSONException e) {
				e.printStackTrace();
			}
        } 
        
	}
	
	@Override
	public int nbCours() throws JSONException {
		JSONArray courses = new JSONArray(coursesStr);
		return courses.length();
	}
	
	@Override
	public int[] getAllCoursesID() throws JSONException {
        return idTab;          
	}
	
	@Override
	public String[] getAllCoursesSyscode() throws JSONException {
        return syscodeTab;          
	}
	
	@Override
	public Course getCourse(int cid) throws JSONException, IOException {
		boolean continuer = true;
		int i;
		/*
         * parcours des cours de 0 à i (0 <= i <= nbCours())
         * invariant : continuer = (idTab[i] = cid) 	pour 0 <= i <= nbCours()
         */
		for(i = 0; i < nbCours() && continuer; i++){	        	
			if(idTab[i] == cid){ continuer = false;}
        }
        if(continuer){
        	throw new IOException("l'id entré ne correspond à aucun cours disponible.");
        }
		JSONArray courses = new JSONArray(coursesStr);
        JSONObject cours = courses.getJSONObject(i-1);
        String courseStr = cours.toString();
		Course course = new CourseMock(courseStr);
		return course;
	}
	
	@Override
	public Course getCourse(String syscode) throws JSONException, IOException {
		boolean continuer = true;
		int i;
		/*
         * parcours des cours de 0 à i (0 <= i <= nbCours())
         * invariant : continuer = (syscodeTab[i] = syscode) 	pour 0 <= i <= nbCours()
         */
		for(i = 0; i < nbCours() && continuer; i++){	        	
			if(syscodeTab[i].equals(syscode)){ continuer = false;}
        }
        if(continuer){
        	throw new IOException("le code entré ne correspond à aucun cours disponible.");
        }
		JSONArray courses = new JSONArray(coursesStr);
        JSONObject cours = courses.getJSONObject(i-1);
        String courseStr = cours.toString();
		Course course = new CourseMock(courseStr);
		return course;
	}		    	

}

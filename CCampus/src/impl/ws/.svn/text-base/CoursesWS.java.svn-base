package impl.ws;

import java.io.IOException;
import java.io.Serializable;

import impl.ws.services.JsonConvertor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import api.Course;

/**
 * implémention avec les données des webservices de Claroline.
 * @author Keil Laurent
 * @see api.Courses
 */
 class CoursesWS implements api.Courses, Serializable {

		 /**
		  * Référence de sérialisation
		  */
		private static final long serialVersionUID = 7041173118258020027L;
		/**
		 * domaine de l'url
		 */
		private String domaine;
		/**
		 * url à accéder
		 */
		private String url;
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
		 * constructeur de l'objet CoursesWS / place les champs cours cours_id et sysCode des cours dans leur tableau respectif.
		 * @throws Exception : si l'utilisateur n'est pas connecté.
		 */
		public CoursesWS() throws Exception {
			
			this.domaine = "https://chouettecampus.info.fundp.ac.be/module/MOBILE/index.php?Method=";
			 
	    	// url pour la requête
			this.url = domaine+"getCourseList";

	 		// Creating JSON Parser instance
			JsonConvertor jParser = new JsonConvertor();
	 		 
	 		// getting JSON string from URL
			JSONArray courses = jParser.getJSONArrayFromUrl(url);
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
		public Course getCourse(int cid) throws Exception {
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
			Course course = new CourseWS(courseStr);
			return course;
		}
		
		@Override
		public Course getCourse(String syscode) throws Exception {
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
			Course course = new CourseWS(courseStr);
			return course;
		}		

}

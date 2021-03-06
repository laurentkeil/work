
package test;

import static org.junit.Assert.*;
import impl.mock.SessionMock;
import api.Annonce;
import api.Annonces;
import api.Course;
import api.CourseTool;
import api.Courses;
import api.Doc;
import api.DocsAndFolders;
import api.Folder;
import api.Session;
import api.Update;
import api.Updates;

import main.FactorySession;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
* Unit test du projet CCampus sur les donn�es du mock.
* @author Keil Laurent
*/
public class TestCCampus {
		
	/**
	 * test de la connexion au serveur sur les WS.
	 */
	@BeforeClass
	public static void testLoginWS() {
		try{
			Session sess = FactorySession.getSession("claro", "Pee6eid0");
		} catch(Exception e) {
			fail("la session ne s'est pas ouverte correctement.");
		}
	}
	
	/**
	 * m�thode utilitaire � testLogoutWS, pour savoir si le test de connexion a r�ussit ou non. 
	 * @return true si la connexion au serveur a r�ussit, false en cas d'�chec.
	 */
	public static boolean Login() {
		try{
			Session sess = FactorySession.getSession("claro", "Pee6eid0");
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	/**
	 * test de d�connexion au serveur (si le test de connexion r�ussit) sur les WS.
	 */
	@AfterClass 
	public static void testLogoutWS() {
		if(Login()) {
			try{
				//ouverture de session
				Session sess = FactorySession.getSession("claro", "Pee6eid0");			
				//fermeture de session
				sess.closeSession();
			} catch(Exception e) {
				fail("la session ne s'est pas ferm�e correctement.");
			}
		}		
	}
	
	/**
	 * test des donn�es de l'utilisateur sur le mock.
	 */
	@Test 
	public void testUser() {
		try{
			Session sess = new SessionMock();
			assertEquals(sess.getUserData().getUserId(), 1);
			assertEquals(sess.getUserData().getUsername(), "claro");
		} catch(Exception e) {
			fail("les donn�es de l'utilisateur ne sont pas correctes.");
		}
	}
	
	/**
	 * test des donn�es des updates de l'utilisateur sur le mock.
	 */
	@Test 
	public void testUpdates() {
		try{
			Session sess = new SessionMock();
			Updates ups = sess.getUpdates();
			//test le nombre d'updates
			if(ups.nbUpdates() != 3){
				fail("le nombre d'updates n'est pas correct.");
			}
			else{
				Update[] upTab = ups.getUpdatesTab();
				/*
				* test sur le tableau d'updates et ses infos.
				*/
				for(int i = 0; i < ups.nbUpdates(); i++) {
					try{
						assertNotNull(upTab[i]);
					}catch(Exception e){
						fail("d�passement de borne du tableau d'updates");
					}
		        }
				if(upTab[0].getResID() != "2"){
					fail("le code de ressource n'est pas correct.");
				}
				if(upTab[0].getTagModule() != "CLDOC"){
					fail("le nom de module n'est pas correct.");
				}
				if(upTab[2].getSysCode() != "B"){
					fail("le code du cours n'est pas correct.");
				}
			}
								
		} catch(Exception e) {
			fail("les donn�es des updates ne sont pas correctes.");
		}
	}
	
	/**
	 * test des donn�es de cours de l'utilisateur sur le mock.
	 * Ce test regroupe les tests sur les outils de cours, les documents et dossiers, et les annonces.
	 */
	@Test 
	public void testCourses() {
		try{
			Session sess = new SessionMock();
			Courses cs = sess.getCourses();
			//test sur le nombre de cours.
			if(cs.nbCours() != 2){
				fail("le nombre de cours n'est pas correct.");
			}
			else{
				int[] idTab = cs.getAllCoursesID();
				String[] sysTab = cs.getAllCoursesSyscode();
				//test sur les tableaux de cours.
				for(int i = 0; i < cs.nbCours(); i++) {
					try{
						assertNotNull(idTab[i]);
						assertNotNull(sysTab[i]);
					}catch(Exception e){
						fail("d�passement de borne de tableau de cours");
					}
		        }
				
				//test sur le renvoi d'exception pour cause de mauvais input
				try{
					Course c = cs.getCourse(0);
					fail("une exception devrait �tre relev�e pour cause de mauvaise input d'id de cours.");
				}catch(Exception e){
				}
				try{
					Course c = cs.getCourse("mauvaisinput");
					fail("une exception devrait �tre relev�e pour cause de mauvaise input de code de cours.");
				}catch(Exception e){
				}
				
				//test sur l'input d'un cours
				try{
					Course c = cs.getCourse(2);
				}catch(Exception e){
					fail(e.getMessage());
				}
				try{
					Course c = cs.getCourse("SANDBOX");
				}catch(Exception e){
					fail(e.getMessage());
				}
				
				//test des donn�es d'un cours.
				Course c = cs.getCourse(2);
				try{
					assertEquals(c.getTitle(), "le cours sandbox");
				}catch(Exception e){
					fail("le titre du cours ne correspond pas");
				}
				
				/*
				 * TEST des donn�es des outils d'un cours.
				 */
				CourseTool ct = c.getCourseTool();
				try{
					assertEquals(ct.isAnn(), true);
				}catch(Exception e){
					fail("l'outil de pr�sence du module annonce d'un cours ne correspond pas");
				}
				try{
					assertEquals(ct.annNotif(), false);
				}catch(Exception e){
					fail("l'outil de notification d'annonce d'un cours ne correspond pas");
				}
				
				/*
				 * TEST sur les annonces 
				 */
				
				Annonces ans = c.getAnnonces();
				//test sur le nombre d'annonces.
				if(ans.nbAnnonces() != 2){
					fail("le nombre d'annonces n'est pas correct.");
				}
				else{
					int[] idansTab = ans.getAllAnnoncesID();
					String[] sysansTab = ans.getAllAnnoncesTitle();
					//test sur les tableaux de cours.
					for(int i = 0; i < ans.nbAnnonces(); i++) {
						try{
							assertNotNull(idansTab[i]);
							assertNotNull(sysansTab[i]);
						}catch(Exception e){
							fail("d�passement de borne de tableau d'annonces");
						}
			        }
					
					//test sur le renvoi d'exception pour cause de mauvais input
					try{
						Annonce an = ans.getAnnonce(3);
						fail("une exception devrait �tre relev�e pour cause de mauvaise input d'id d'annonce.");
					}catch(Exception e){
					}
					try{
						Annonce an = ans.getAnnonce("mauvaisinput");
						fail("une exception devrait �tre relev�e pour cause de mauvaise input de code d'annonce.");
					}catch(Exception e){
					}
					
					//test sur l'input d'une annonce
					try{
						Annonce an = ans.getAnnonce(4);
					}catch(Exception e){
						fail(e.getMessage());
					}
					try{
						Annonce an = ans.getAnnonce("chouette annonce 4");
					}catch(Exception e){
						fail(e.getMessage());
					}
					
					//test des donn�es d'une annonce.
					Annonce an = ans.getAnnonce(5);
					try{
						assertEquals(an.getContent(), "contenu du 5");
					}catch(Exception e){
						fail("le contenu de l'annonce ne correspond pas");
					}
					
				}
				
				/*
				 * TEST sur les documents et dossiers
				 */
				DocsAndFolders ds = c.getDocs();
				//test sur le nombre de documents et dossiers.
				if(ds.nbDocsAndFolders() != 3){
					fail("le nombre de documents et dossiers n'est pas correct.");
				}	
				else if(ds.nbDocs() != 2){
					fail("le nombre de documents n'est pas correct.");
				}	
				else if(ds.nbFolders() != 1){
					fail("le nombre de dossiers n'est pas correct.");
				}
				else{
					String[] docnameTab = ds.getDocsName();
					String[] foldnameTab = ds.getFoldersName();
					//test sur les tableaux de documents et dossiers.
					for(int i = 0; i < ds.nbDocs(); i++) {
						try{
							assertNotNull(docnameTab[i]);
						}catch(Exception e){
							fail("d�passement de borne de tableau de documents");
						}
			        }
					for(int i = 0; i < ds.nbFolders(); i++) {
						try{
							assertNotNull(foldnameTab[i]);
						}catch(Exception e){
							fail("d�passement de borne de tableau de dossiers");
						}
			        }
					
					//test sur le renvoi d'exception pour cause de mauvais input
					try{
						Folder f = ds.getFolder("mauvais input");
						fail("une exception devrait �tre relev�e pour cause de mauvaise input de nom de dossier.");
					}catch(Exception e){
					}
					try{
						Doc f = ds.getDoc("mauvais input");
						fail("une exception devrait �tre relev�e pour cause de mauvaise input de nom de document.");
					}catch(Exception e){
					}
					
					//test sur l'input d'un folder/d'un doc
					try{
						Folder f = ds.getFolder("chouette folder 2");
					}catch(Exception e){
						fail(e.getMessage());
					}
					try{
						Doc d = ds.getDoc("chouette document 1");
					}catch(Exception e){
						fail(e.getMessage());
					}
					
					//test des donn�es d'un document.
					Doc d = ds.getDoc("chouette document 2");
					try{
						assertEquals(d.getDescription(), "description 2");
					}catch(Exception e){
						fail("le description du document ne correspond pas");
					}
					
					//test des donn�es d'un dossier.
					Folder f = ds.getFolder("chouette folder 2");
					try{
						assertEquals(f.getPath(), "\\/repertoire1");
					}catch(Exception e){
						fail("le chemin du dossier ne correspond pas");
					}
					
				}
				
			}
								
		} catch(Exception e) {
			fail("les donn�es des cours ne sont pas correctes.");
		}
	}
	
}

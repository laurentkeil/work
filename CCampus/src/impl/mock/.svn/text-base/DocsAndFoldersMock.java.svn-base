package impl.mock;

import java.io.IOException;
import java.io.Serializable;

import impl.ws.DocWS;
import impl.ws.FolderWS;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import api.Doc;
import api.Folder;

/**
 * implémention mock avec des données tests de l'interface.
 * @see api.DocsAndFolders
 * @author Keil Laurent
 */
public class DocsAndFoldersMock implements api.DocsAndFolders, Serializable {

	 /**
	  * Référence de sérialisation
	  */
	private static final long serialVersionUID = 4312476549879719330L;
	/**
	 * code du cours
	 */
	private String syscode;
	/**
	 * un tableau de chaine de caractères contenant chaque name des nbFolders dossiers du cours de l'utilisateur.
	 */
	private String[] foldersNameTab = new String[5000];
	/**
	 * un tableau d'entiers contenant chaque emplacement des nbFolders dossiers du cours de l'utilisateur.
	 */
	private int[] foldersNameEmplTab = new int[5000];
	/**
	 * un tableau de chaine de caractères contenant chaque name des nbDocs documents du cours de l'utilisateur.
	 */
	private String[] docsNameTab = new String[5000];
	/**
	 * un tableau d'entiers contenant chaque emplacement des nbDocs documents du cours de l'utilisateur.
	 */
	private int[] docsNameEmplTab = new int[5000];

	/**
	 * le nombre de documents pour le cours (sysCode) de l'utilisateur connecté.
	 */
	private int nbDocs;
	/**
	 * le nombre de dossiers pour le cours (sysCode) de l'utilisateur connecté.
	 */
	private int nbFolders;
	
	/**
	 * Chaine de caractère contenant le fichier au format JSON
	 */
	private String docsStr;
		

	/**
	 * Constructeur de l'objet DocsAndFoldersMock / place les champs d'annonces ressourceId et title des annonces dans leur tableau respectif / place des données tests
	 * @param syscode : le code du cours dans lequel on récupère des informations sur les documents et dossiers de ce cours.
	 * @throws JSONException : si problème de format json
	 */
	public DocsAndFoldersMock(String syscode) throws JSONException {
		this.syscode = syscode;
		
		// getting JSON string from URL
		JSONArray docs = new JSONArray();
	
		JSONObject doc1 = new JSONObject();
		JSONObject doc2 = new JSONObject();
		JSONObject folder1 = new JSONObject();
		
    	try {
			doc1.put("name", "chouette document 1");
			doc1.put("type", 2 );
			doc1.put("path", "\\/Example_document.pdf");
			doc1.put("isFolder", false);
			doc1.put("size", "66854");
			doc1.put("date", "2012-11-19");
			doc1.put("extension", "pdf");
			doc1.put("url", "chouettecampus.info.fundp.ac.be\\/claroline\\/backends\\/download.php?url=L0V4YW1wbGVfZG9jdW1lbnQucGRm&cidReset=true&cidReq=H1");
			doc1.put("description", "null");
			doc1.put("visibility", true);
			doc1.put("notified", true);

			doc2.put("name", "chouette document 2");
			doc2.put("type", 2 );
			doc2.put("path", "\\/repertoire1\\/myfirstwebproject_-1-.rar");
			doc2.put("isFolder", false);
			doc2.put("size", "61245");
			doc2.put("date", "2012-11-20");
			doc2.put("extension", "rar");
			doc2.put("url", "chouettecampus.info.fundp.ac.be\\/claroline\\/backends\\/download.php?url=L3JlcGVydG9pcmUxL215Zmlyc3R3ZWJwcm9qZWN0Xy0xLS5yYXI%3D&cidReset=true&cidReq=H1");
			doc2.put("description", "description 2");
			doc2.put("visibility", true);
			doc2.put("notified", false);

			folder1.put("name", "chouette folder 2");
			folder1.put("type", 3 );
			folder1.put("path", "\\/repertoire1");
			folder1.put("isFolder", true);
			folder1.put("date", "2012-11-20");
			folder1.put("description", "rep 1");
			folder1.put("visibility", true);
			folder1.put("notified", false);
			
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
    	
        docs.put(folder1);
        docs.put(doc1);
        docs.put(doc2);
        
        this.docsStr = docs.toString();

		this.nbDocs = 0;
		this.nbFolders = 0;

		/*
         * parcours des annonces de 0 à nbDocsAndFolders()
         * invariant : place le nom et l'emplacement du dossier (i-1) respectivement dans la (i-1) e case du tableau foldersNameTab et foldersNameEmplTab (0 < i < nbFolders()+1)
         * 	et place le nom et l'emplacement du document (i-1) respectivement dans la (i-1) e case du tableau docsNameTab et docsNameEmplTab (0 < i < nbDocs()+1)
         */
        for(int i = 0; i < nbDocsAndFolders(); i++){
        	
            JSONObject doc = null;
			try {
				doc = docs.getJSONObject(i);
			} catch (JSONException e) {
				e.printStackTrace();
			}
    		
            // Storing each json item in variable
			try {
				boolean isFolder = doc.getBoolean("isFolder");
				if(isFolder){
					this.foldersNameTab[nbFolders] = doc.getString("name");
					this.foldersNameEmplTab[nbFolders] = i;
					this.nbFolders++;
				}else{
					this.docsNameTab[nbDocs] = doc.getString("name");
					this.docsNameEmplTab[nbDocs] = i;
					this.nbDocs++;
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
        }
       
	}
	
	@Override
	public String getSysCode() {
		return syscode;
	}
	
	@Override
	public int nbDocsAndFolders() throws JSONException {
		JSONArray docs = new JSONArray(docsStr);
		return docs.length();
	}
	
	@Override
	public int nbDocs() {
		return nbDocs;
	}
	
	@Override
	public int nbFolders() {
		return nbFolders;
	}

	@Override
	public String[] getFoldersName() throws JSONException {	
        return foldersNameTab;          
	}
	
	@Override
	public String[] getDocsName() throws JSONException {
        return docsNameTab;          
	}
	
	@Override
	public Folder getFolder(String name) throws JSONException, IOException, Exception {
		boolean continuer = true;
		int i,empl=0;
		/*
         * parcours des dossiers de 0 à i (0 <= i <= nbFolders())
         * invariant : continuer = (foldersNameTab[i] = name) 	pour 0 <= i <= nbFolders()
         */
		for(i = 0; i < nbFolders() && continuer; i++){	        	
			if(foldersNameTab[i].equals(name)){ continuer = false;}
        }
        if(continuer){
        	throw new IOException("le nom entré ne correspond à aucun dossier disponible.");
        }
		empl = foldersNameEmplTab[i-1];
		JSONArray docs = new JSONArray(docsStr);
        JSONObject folder1 = docs.getJSONObject(empl);
		Folder folder = new FolderWS(folder1.toString());
		return folder;
	}
	
	@Override
	public Doc getDoc(String name) throws JSONException, IOException, Exception {
		boolean continuer = true;
		int i,empl=0;
		/*
         * parcours des documents de 0 à i (0 <= i <= nbDocs())
         * invariant : continuer = (docsNameTab[i] = name) 	pour 0 <= i <= nbDocs()
         */
		for(i = 0; i < nbDocs() && continuer; i++){	    
			if(docsNameTab[i].equals(name)){ continuer = false;}
        }
        if(continuer){
        	throw new IOException("le nom entré ne correspond à aucun document disponible.");
        }
		empl = docsNameEmplTab[i-1];
		JSONArray docs = new JSONArray(docsStr);
        JSONObject doc1 = docs.getJSONObject(empl);		
		Doc doc = new DocWS(doc1.toString());
		return doc;
	}
   

}

package jeu;
import java.io.*;
import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.filter.*;
import java.util.List;
import java.util.Iterator;

public class JDOM
{
   static org.jdom2.Document document;
   static Element racine;

   static void afficheALL()
   {
      //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
      List listAutomates = racine.getChildren("automate");
      Iterator i = listAutomates.iterator();
      Element courant = (Element)i.next();
      List listTransitions;
      Iterator j;
      while(courant != null)
      {
    	  listTransitions = courant.getChildren("transition");
    	  j = listTransitions.iterator();
    	  courant = (Element)j.next();
    	  while(courant != null)
    	  {
    		  System.out.println(courant.getChild("depart").getText());
    		  System.out.println(courant.getChild("condition").getText());
    		  System.out.println(courant.getChild("priorite").getText());
    		  System.out.println(courant.getChild("action").getText());
    		  System.out.println(courant.getChild("arrivee").getText());
    		  if(j.hasNext()) {
    			  courant = (Element)j.next();
    		  }
    		  else {
    			  courant = null;
    		  }
    	  }
		  if(i.hasNext()) {
			  courant = (Element)i.next();
		  }
		  else {
			  courant = null;
		  }
      }
   }

   public void xmlMain()
   {
      //On crée une instance de SAXBuilder
      SAXBuilder sxb = new SAXBuilder();
      try
      {
         //On crée un nouveau document JDOM avec en argument le fichier XML
         //Le parsing est terminé ;)
         document = sxb.build(new File("test.xml"));
      }
      catch(Exception e){}

      //On initialise un nouvel élément racine avec l'élément racine du document.
      racine = document.getRootElement();
      //Méthode définie dans la partie 3.2. de cet article
      afficheALL();
   }
}
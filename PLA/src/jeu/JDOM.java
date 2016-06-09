package jeu;
import java.io.*;
import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.filter.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import automate.*;
public class JDOM
{
   static org.jdom2.Document document;
   static Element racine;

   static ArrayList<Automate> afficheALL()
   {
      //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
	  ArrayList<Automate> listeAuto = new ArrayList<Automate>();
      List listAutomates = racine.getChildren("automate");
      Iterator i = listAutomates.iterator();
      Element courant = (Element)i.next();
      List listTransitions;
      Iterator j;
      int courantDepart,courantCondition,courantPriorite,courantAction,courantArrivee,courantInitial;
      Transition courantTransition;
      Automate courantAutomate;
      while(courant != null)
      {
    	 // Automate courantAuto = new Automate();
    	  ArrayList<Transition> allTransitions = new ArrayList<Transition>();
    	  listTransitions = courant.getChildren("transition");
    	  j = listTransitions.iterator();
    	  courant = (Element)j.next();
    	  while(courant != null)
    	  {
    		  courantDepart = Integer.parseInt(courant.getChild("depart").getText());
    		  courantCondition = Integer.parseInt(courant.getChild("condition").getText());
    		  courantPriorite = Integer.parseInt(courant.getChild("priorite").getText());
    		  courantAction = Integer.parseInt(courant.getChild("action").getText());
    		  courantArrivee = Integer.parseInt(courant.getChild("arrivee").getText());
    		  courantTransition = new Transition(courantDepart,courantArrivee,courantCondition,courantPriorite,courantAction);
    		  allTransitions.add(courantTransition);
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
    	  // Constructeur à faire, il faut faire quelque chose pour Initial (pas encore géré) et pour états
    	  //courantAutomate = new Automate()
		  if(i.hasNext()) {
			  courant = (Element)i.next();
		  }
		  else {
			  courant = null;
		  }
      }
      return listeAuto;
   }

   public ArrayList<Automate> xmlMain()
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
      return afficheALL();
   }
}
(* LES TYPES *)
    
type cellule =
  | C (* case *)| N (* nord *) | S | E | O

type action =
  | Attendre
  | Deplacer of cellule
  | Attaquer of cellule
  | Cueillir
  | Couper
  | Convertir of cellule
  | Soigner of cellule

type condition =
  | Herbe of cellule
  | Allie of cellule
  | Ennemi of cellule
  | Nourriture of cellule
  | Bois of cellule

type etat = int
type priorite = int
type transition = etat * condition * priorite * action * etat
type automate = transition list * etat (*etat initial*)

(* EXEMPLE D'AUTOMATE *)

let paysan =
	[(1, Nourriture(N), Deplacer(N), 1);
	(1, Nourriture(S), Deplacer(S), 1);
	(1, Nourriture(E), Deplacer(E), 1);
	(1, Nourriture(O), Deplacer(O), 1);
	(1, Nourriture(C), Cueillir, 1);
	(1, Bois(N), Deplacer(N), 1);
	(1, Bois(S), Deplacer(S), 1);
	(1, Bois(E), Deplacer(E), 1);
	(1, Bois(O), Deplacer(O), 1);
	(1, Bois(C), Couper, 1);
	(1, Herbe(C), Deplacer(N), 1); (* déplacement dans une direction aléatoire *)
	(1, Herbe(C), Deplacer(S), 1);
	(1, Herbe(C), Deplacer(O), 1);
	(1, Herbe(C), Deplacer(E), 1);
	
	];;
	
	let guerrier =
	[(1, Ennemi(N), Attaquer(N), 1);
	(1, Ennemi(S), Attaquer(S), 1);
	(1, Ennemi(E), Attaquer(E), 1);
	(1, Ennemi(O), Attaquer(O), 1);
	(1, Herbe(C), Deplacer(N), 1); (* déplacement dans une direction aléatoire *)
	(1, Herbe(C), Deplacer(S), 1);
	(1, Herbe(C), Deplacer(O), 1);
	(1, Herbe(C), Deplacer(E), 1);
	];;

	let moine =
	[(1, Ennemi(N), Convertir(N), 1);
	(1, Ennemi(S), Convertir(S), 1);
	(1, Ennemi(E), Convertir(E), 1);
	(1, Ennemi(O), Convertir(O), 1);
	(1, Allie(N), Soigner(N), 1);
	(1, Allie(S), Soigner(S), 1);
	(1, Allie(E), Soigner(E), 1);
	(1, Allie(O), Soigner(O), 1);
	(1, Herbe(C), Deplacer(N), 1); (* déplacement dans une direction aléatoire *)
	(1, Herbe(C), Deplacer(S), 1);
	(1, Herbe(C), Deplacer(O), 1);
	(1, Herbe(C), Deplacer(E), 1);
	];;

    
   
(* ON PEUT GÉNÉRER CERTAINES PARTIES DE L'AUTOMATE *)

let attaquerNSEO depart arrivee  =
      List.map  (fun direction -> (depart, Ennemi(direction), Attaquer(direction), arrivee) ) [N;S;E;O];;

let guerrier2 =
  (attaquerNSEO 1 1) 
    @
  [(1, Herbe(C), Deplacer(N), 1); (* déplacement dans une direction aléatoire *)
	(1, Herbe(C), Deplacer(S), 1);
	(1, Herbe(C), Deplacer(O), 1);
	(1, Herbe(C), Deplacer(E), 1);
	];;


(* Traduction du tableau d'entiers en fichier xml *)

let rec transitions_to_xml liste_transitions fichier = match liste_transitions with
|[]-> ()
|(depart, condition, priorite, action, arrivee)::q -> output_string fichier "<transition>";
											output_string fichier "<depart>";
											output_string fichier (string_of_int depart);
											output_string fichier "</depart>";
											output_string fichier "<condition>";
											output_string fichier (string_of_int condition);
											output_string fichier "</condition>";
											output_string fichier "<priorite>";
											output_string fichier (string_of_int priorite);
											output_string fichier "</priorite>";
											output_string fichier "<action>";
											output_string fichier (string_of_int action);
											output_string fichier "</action>";
											output_string fichier "<arrivee>";
											output_string fichier (string_of_int arrivee);
											output_string fichier "</arrivee>";
											output_string fichier "</transition>";
											transitions_to_xml q fichier;;

let fic = open_out "automates.xml";;
output_string fic "<automate>";;
transitions_to_xml [(1,2,3,4,6);(5,6,7,8,9)] fic;;
output_string fic "</automate>";;


   
(* TRADUCTION DES CONDITIONS COMPLEXES EN ENTIER *)
  
let (cellule_to_int: cellule -> int) = function
  | C -> 0
  | N -> 1
  | S -> 2
  | E -> 3
  | O -> 4
  
  (*

let (condition_to_int: condition -> int) =  function
  | Vide -> 0
  | Ami(cellule) -> 1 + (cellule_to_int cellule) (* 1..5 *)
  | Ennemi(cellule) -> 6 + (cellule_to_int cellule) (* 6..10 *)
  | Comestible(cellule) -> 11 + (cellule_to_int cellule) (* 11..15 *)
  | _ -> 0

let (action_to_int: action -> int) = function
   | Attendre -> 0
   | Avancer -> 1
   | Reculer -> 2
   | Frapper -> 3
   | Prendre -> 4
   | Tourner_vers (cellule) -> 5 + (cellule_to_int cellule)
   | _ -> 0

   
   
  
let (traduction_transition: transition -> int * int * int * int) = fun (src,condition,action,tgt) ->
   (src, condition_to_int condition, action_to_int action, tgt)

let (traduction_automate: automate -> (int * int * int * int) list) = fun automate ->
   List.map traduction_transition automate ;;


let trad_aut1 = traduction_automate aut1 ;;

(* On obtient
   [ (1, 7, 6, 2); 
     (1, 8, 7, 2); 
     (1, 9, 8, 2); 
     (1, 10, 9, 2); 
     (2, 7, 3, 3);
     (3, 0, 1, 4); 
     (4, 0, 0, 1) ]

  à partir duquel on peut constuire le tableau des transitions et celui des actions.

 *)

   
(* LE SIMULATEUR examine le voisinage de la position (x,y) du personnage 
   
         ?      |  Ennemi(N)    |  ?
 ------------------------------------------------
  Comestible(O) | Comestible(C) | Comestible(E)
 ------------------------------------------------
         ?      |  Ennemi(S)    |  ?

qui correspond aux conditions 

    ?  | 7  | ?
    15 | 11 | 14
     ? | 8  | ? 

Supposons que l'automate du personnage soit dans l'état 1,
le simulateur cherche les transitions exécutables de l'automate 
dans l'état 1 sur les conditions/symboles {7,8,11,14,15}
il y en a deux transitions possibles :

 (1, 7, 6, 2)  et (1, 8, 7, 2);

Le simulateur en prend tire une parmi celle là est l'exécute.


*)
*)

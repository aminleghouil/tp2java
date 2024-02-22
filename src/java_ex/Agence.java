package java_ex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Agence {
private String nom;
private ListVoitures vs;
private Map<Client, ListVoitures> ClientVoitureLoue;
public Agence(String nom) {
	this.nom=nom;
	vs = new ListVoitures();
	}
public String getNom() { 
	return nom;
}
public void setNom(String nom) { 
	this.nom = nom;
}
public void ajoutVoiture(Voiture v) throws VoitureException{
		vs.ajoutVoiture(v);
	}
public void suppVoiture(Voiture v)throws VoitureException{
		vs.supprimeVoiture(v);
	}
public void loueClientVoiture(Client cl, Voiture v) throws VoitureException{
	ajoutVoiture(v);
	ClientVoitureLoue.put(cl, vs);
	
	}
public void retourClientVoiture(Client cl , Voiture v) throws VoitureException{
	suppVoiture(v);
	ClientVoitureLoue.remove(cl, vs);
	}
public List<Voiture> selectVoitureSelonCritere(Critere c) {
	List<Voiture> result = new ArrayList<>();

    for (Voiture voiture : vs.getVoitures()) {
        if (c.estSatisfaitPar(voiture)) {
            result.add(voiture);
        }
    }

    return result;
	}
public Set<Client> ensembleClientsLoueurs(){
	Set <Client> result = new  HashSet<>() ; 
	for (Client key : ClientVoitureLoue.keySet()) {
		if(ClientVoitureLoue.get(key).size()>=1) {
			result.add(key);
		}
	}
	return result;
	}
public Collection<ListVoitures> collectionVoituresLouees() {
	Collection<ListVoitures> result = new ArrayList<>();
	for (Client key : ClientVoitureLoue.keySet()) {
			result.add(ClientVoitureLoue.get(key));
	}
	return result;
	}
public void afficheLesClientsEtLeursListesVoitures(){
	for (Client key : ClientVoitureLoue.keySet()) {
		System.out.println(key+" List de voitures sont :");
		ClientVoitureLoue.get(key).affiche();
		}
	}

public Map<Client, ListVoitures> triCodeCroissant(){
	  Map<Client,ListVoitures > sortedMap = new TreeMap<>(Comparator.comparing(Client::getCode));
	  sortedMap.putAll( ClientVoitureLoue);
	  return sortedMap;
}
public Map<Client, ListVoitures> triNomCroissant(){
	Map<Client,ListVoitures > sortedMap = new TreeMap<>(Comparator.comparing(Client::getNom));
	sortedMap.putAll( ClientVoitureLoue);
	return sortedMap;
}}
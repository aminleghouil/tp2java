package java_ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListVoitures {
private List<Voiture> voitures;
public ListVoitures(List<Voiture> voitures) {
	this.voitures=voitures;
}

public ListVoitures() {
	voitures = new ArrayList<Voiture>();
	}
public List<Voiture> getVoitures() {
	return voitures;
	}
public void setVoitures(List<Voiture> voitures) {
	this.voitures = voitures; 
	}
public void ajoutVoiture(Voiture v) throws VoitureException{
	if (voitures.contains(v)) throw new VoitureException();
	voitures.add(v);
	}
public void supprimeVoiture(Voiture v) throws VoitureException{
	if (!voitures.contains(v)) throw new VoitureException();
	voitures.add(v);
	}
public Iterator<Voiture> iterateur(){
	return voitures.iterator();
}
public int size(){
	return voitures.size();
}
public void affiche(){
	
	for(Iterator<Voiture> i=iterateur();i.hasNext();) {
		System.out.println(i.next());
	}
}
}
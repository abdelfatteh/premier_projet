package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//@JsonIgnoreProperties(value= {"prixDachat","id"})
@Entity
public class produit {
	@Id @GeneratedValue
private int id ;
private String nom;
private double prix ;

private double prixDachat ;

public produit() {
	
}

public produit(int id, String nom, double prix,double prixDachat) {
	super();
	this.id = id;
	this.nom = nom;
	this.prix = prix;
	this.prixDachat =prixDachat;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public double getprixDachat() {
	return prixDachat;
}
public void setprixDachat(double prixDachat) {
	this.prixDachat = prixDachat;
}

@Override
public String toString() {
	return "produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", prixDachat=" + prixDachat + "]";
}

}

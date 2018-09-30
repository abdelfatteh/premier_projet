package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.produit;

import dao.produitdao;
@Repository
public class impelemtaionprod implements produitdao {
public static List<produit> produits = new ArrayList<produit>();
static {
	produits.add(new produit(5, new String("HP"), 900,700));
	produits.add(new produit(3, new String("SAMSUNG"), 938,760));
	produits.add(new produit(8, new String("TOSHIBA"), 800,690));
}
	@Override
	public List<produit> finAll() {
      
		return produits;
	}

	@Override
	public produit findBYID(int id) {
		for (produit produit:produits) {
			if (produit.getId()==id) {
				return produit ;
			}
		}
		return null;
	}

	@Override
	public produit save(produit produit) {
	produits.add(produit);
		return produit;
	}

}

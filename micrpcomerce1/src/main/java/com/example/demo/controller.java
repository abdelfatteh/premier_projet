package com.example.demo;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.deao.produitdao;
import com.example.demo.model.produit;

@RestController
public class controller {
@Autowired

private produitdao produitdao ;
@GetMapping(value="produits")
public List<produit> listproduits(){	
	return produitdao.findAll();
}
//ajouter un produit
@GetMapping(value="produit/{id}")
public produit afficheproduit (@PathVariable int id) {

	 produit produi = produitdao.findById(id);

    if(produi==null) throw new ProduitIntrouvableException(+ id + " n'exist pas");

    return produi;

}
	@PostMapping(value="/produits")
	public  ResponseEntity<Void> ajoutprod(@RequestBody produit produit) {
		produit produit1= produitdao.save(produit);
		if (produit==null) {
			return ResponseEntity.noContent().build();
		}
		URI Location=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(produit1 .getId())
				.toUri();
		return ResponseEntity.created(Location).build();
				
		
	}
	@GetMapping(value="test/produit/{prixlimit}")
	public List<produit> testdeRequest (@PathVariable int prixlimit) {

	return produitdao.findbprixgriterThan(500) ;

	}
}

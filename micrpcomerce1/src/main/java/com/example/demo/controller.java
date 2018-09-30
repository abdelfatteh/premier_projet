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
import com.example.demo.model.produit;
import dao.produitdao;

@RestController
public class controller {
@Autowired

private produitdao produitdao ;
@GetMapping(value="produits")
public List<produit> listproduits(){
	return produitdao.finAll();
}
@GetMapping(value="produit/{id}")
public produit afficheproduit (@PathVariable int id) {

return produitdao.findBYID(id) ;

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
}

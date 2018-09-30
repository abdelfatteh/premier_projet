package dao;

import java.util.List;

import com.example.demo.model.produit;

public interface produitdao {
public List<produit>finAll();
public produit findBYID(int id);
public produit save(produit produit);

}

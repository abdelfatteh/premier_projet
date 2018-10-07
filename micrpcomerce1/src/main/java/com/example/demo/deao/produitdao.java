package  com.example.demo.deao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.produit;

@Repository
public interface produitdao extends JpaRepository<produit ,Integer> {
produit findBYID(int id);
List<produit>findbprixgriterThan(int prixlimit);
@Query("SELECT id  , nom ,prix From produit p WHERE p.prix<p.prixlimit")	
List<produit> cherchemaxprix(@Param ("prixlimit")int prix);

}

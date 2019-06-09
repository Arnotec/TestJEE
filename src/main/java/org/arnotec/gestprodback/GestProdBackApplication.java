package org.arnotec.gestprodback;

import org.arnotec.gestprodback.dao.ProduitRepository;
import org.arnotec.gestprodback.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class GestProdBackApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(GestProdBackApplication.class, args);
        ProduitRepository produitDao = ctx.getBean(ProduitRepository.class);
        produitDao.save(new Produit("LX 5467",84000, 7));
        produitDao.save(new Produit("HP 654", 56000, 3));
        produitDao.save(new Produit("LX 5467", 15000, 5));

        List<Produit> produits = produitDao.findByMotCle("%H%");
        for(Produit p: produits){
            System.out.println("DESIGNATION = "+p.getDesignation());
            System.out.println("PRIX = "+p.getPrix());
            System.out.println("QUANTITE = "+p.getQuantite());
            System.out.println("---");
        }
    }

}

package org.arnotec.gestprodback;

import org.arnotec.gestprodback.dao.CategorieRepository;
import org.arnotec.gestprodback.dao.ProduitRepository;
import org.arnotec.gestprodback.entities.Categorie;
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
        CategorieRepository categorieDao = ctx.getBean(CategorieRepository.class);

        Categorie cat1 = new Categorie("Ordinateur");
        Categorie cat2 = new Categorie("Imprimante");
        categorieDao.save(cat1);
        categorieDao.save(cat2);

        produitDao.save(new Produit("LX 5467", 84000, 7, cat2));
        produitDao.save(new Produit("HP 654", 56000, 3, cat1));
        produitDao.save(new Produit("LX 6800", 15000, 5, cat2));

        List<Produit> produits = produitDao.findAll();
        for (Produit p : produits) {
            System.out.println("DESIGNATION = " + p.getDesignation());
            System.out.println("PRIX = " + p.getPrix());
            System.out.println("QUANTITE = " + p.getQuantite());
            System.out.println("CATEGORIE = " + p.getCategorie().getNomCategorie());
            System.out.println("---");
        }
    }

}

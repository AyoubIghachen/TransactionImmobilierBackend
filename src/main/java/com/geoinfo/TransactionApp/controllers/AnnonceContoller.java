package com.geoinfo.TransactionApp.controllers;

import com.geoinfo.TransactionApp.entities.Annonce;
import com.geoinfo.TransactionApp.enums.BienType;
import com.geoinfo.TransactionApp.enums.OperationType;
import com.geoinfo.TransactionApp.services.AnnonceService;
import com.geoinfo.TransactionApp.servicesImp.AnnonceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/annonces")
public class AnnonceContoller {

    @Autowired private AnnonceService annonceService;

    @PostMapping()
    public void Ajouter_annonce(@RequestBody Annonce annonce){
        annonceService.ajouterAnnonce(annonce);
    }

    @DeleteMapping("/{id}")
    public void Supprimer_annonce(@PathVariable long id){
        annonceService.supprimerAnnonce(id);
    }

    @PutMapping("/{id}")
    public void Modifier_annonce(@RequestBody Annonce annonce,@PathVariable long id){
        annonceService.modifierAnnonce(annonce,id);
    }

    @GetMapping
    List<Annonce> GetALlAnnonces(){
       return annonceService.getAllAnnonce();
    }

    @GetMapping("/{id}")
    Annonce GetAnnonce(@PathVariable long id){
        return annonceService.getAnnonce(id);
    }

    @PutMapping("/Reserve_annonce/{id_annonce}/{id_intermediaire}")
    public void Reserver_annonce(@PathVariable Long id_annonce,@PathVariable Long id_intermediaire){
        annonceService.reserverAnnonce(id_intermediaire,id_annonce);
    }

    @GetMapping("/Annonces_reservee_pour_intermediaire/{id}")
    List<Annonce> Get_annonces_reserve_for_intermediaire(@PathVariable long id){
        return  annonceService.getAlAnnoncesReseverByIntermediaire(id);
    }

    @GetMapping("/Annonces_rejeter_par_intermediaire/{id}")
    List<Annonce> Get_annonces_rejeter_for_intermediaire(@PathVariable long id){
        return  annonceService.getAlAnnoncesRejeterByIntermediaire(id);
    }


    @GetMapping("/Annonces_pas_encore_reserve")
    List<Annonce> Get_annonces_pas_encore_reservee(){
        return  annonceService.getAllAnnoncesPasEncoreReserve();
    }

    @GetMapping("/Annonces_publie")
    List<Annonce> Get_annonces_publie(){
        return  annonceService.getAllAnnoncesPublie();
    }

    @PutMapping("/Publier_annonce/{id_annonce}")
    public void Publier_annonce(@PathVariable Long id_annonce){
        annonceService.PublierAnnonce(id_annonce);
    }

    @PutMapping("/Rejeter_annonce/{id_annonce}")
    public void Rejeter_annonce(@PathVariable Long id_annonce, @RequestBody Map<String, String> body) {
        String motifRejet = body.get("motifRejet");
        annonceService.RejeterAnnonce(id_annonce, motifRejet);
    }


    @PutMapping("/Liberer_annonce/{id_annonce}")
    public void Liberer_annonce(@PathVariable Long id_annonce){
        annonceService.libererAnnonce(id_annonce);
    }

    // Categorie par prix

    @GetMapping("/prix/categorie1")
    public List<Annonce> getAnnoncesByPriceCategory1() {
        return annonceService.getAnnoncesByPriceCategories().get(0);
    }
    @GetMapping("/prix/categorie2")
    public List<Annonce> getAnnoncesByPriceCategory2() {
        return annonceService.getAnnoncesByPriceCategories().get(1);
    }
    @GetMapping("/prix/categorie3")
    public List<Annonce> getAnnoncesByPriceCategory3() {
        return annonceService.getAnnoncesByPriceCategories().get(2);
    }
    @GetMapping("/prix/categorie4")
    public List<Annonce> getAnnoncesByPriceCategory4() {
        return annonceService.getAnnoncesByPriceCategories().get(3);
    }
    @GetMapping("/prix/categorie5")
    public List<Annonce> getAnnoncesByPriceCategory5() {
        return annonceService.getAnnoncesByPriceCategories().get(4);
    }

    // Categorie par surface

    @GetMapping("/surface/categorie1")
    public List<Annonce> getAnnoncesBySurfaceCategory1() {
        return annonceService.getAnnoncesBySurfaceCategories().get(0);
    }
    @GetMapping("/surface/categorie2")
    public List<Annonce> getAnnoncesBySurfaceCategory2() {
        return annonceService.getAnnoncesBySurfaceCategories().get(1);
    }
    @GetMapping("/surface/categorie3")
    public List<Annonce> getAnnoncesBySurfaceCategory3() {
        return annonceService.getAnnoncesBySurfaceCategories().get(2);
    }
    @GetMapping("/surface/categorie4")
    public List<Annonce> getAnnoncesBySurfaceCategory4() {
        return annonceService.getAnnoncesBySurfaceCategories().get(3);
    }
    @GetMapping("/surface/categorie5")
    public List<Annonce> getAnnoncesBySurfaceCategory5() {
        return annonceService.getAnnoncesBySurfaceCategories().get(4);
    }


    @GetMapping("/annonces_vendre")
    public List<Annonce> getAnnoncesAvendres() {
        return annonceService.getAnnonceOperation(OperationType.VENDRE);
    }
    @GetMapping("/annonces_louer")
    public List<Annonce> getAnnoncesAlouer() {
        return annonceService.getAnnonceOperation(OperationType.LOUER);
    }

    @GetMapping("/annonces_maison")
    public List<Annonce> getAnnoncesMaison() {
        return annonceService.getAnnonceTypeBien(BienType.MAISON);
    }

    @GetMapping("/annonces_villa")
    public List<Annonce> getAnnoncesVilla() {
        return annonceService.getAnnonceTypeBien(BienType.VILLA);
    }

    @GetMapping("/annonces_apartement")
    public List<Annonce> getAnnoncesApartement() {
        return annonceService.getAnnonceTypeBien(BienType.APPARTEMENT);
    }




}

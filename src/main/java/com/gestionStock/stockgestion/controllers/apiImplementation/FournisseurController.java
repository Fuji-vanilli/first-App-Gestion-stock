package com.gestionStock.stockgestion.controllers.apiImplementation;

import com.gestionStock.stockgestion.DTOs.FournisseurDTO;
import com.gestionStock.stockgestion.controllers.api.FournisseurApi;
import com.gestionStock.stockgestion.services.servicesImplementation.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FournisseurController implements FournisseurApi{

    @Autowired
    private FournisseurService fournisseurService;

    public FournisseurController(
            FournisseurService fournisseurService){
        this.fournisseurService= fournisseurService;
    }

    @Override
    public FournisseurDTO create(FournisseurDTO fournisseurDTO) {
        return fournisseurService.create(fournisseurDTO);
    }

    @Override
    public FournisseurDTO getById(Integer id) {
        return fournisseurService.getById(id);
    }

    @Override
    public FournisseurDTO getByFirstName(String firstName) {
        return fournisseurService.getByFirstName(firstName);
    }

    @Override
    public List<FournisseurDTO> getAll() {
        return fournisseurService.getAll();
    }

    @Override
    public boolean delete(Integer id) {
        return fournisseurService.delete(id);
    }
}

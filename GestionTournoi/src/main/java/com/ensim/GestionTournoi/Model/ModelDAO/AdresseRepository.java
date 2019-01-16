package com.ensim.GestionTournoi.Model.ModelDAO;

import com.ensim.GestionTournoi.Model.Adresse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdresseRepository extends CrudRepository<Adresse, Long> {

}

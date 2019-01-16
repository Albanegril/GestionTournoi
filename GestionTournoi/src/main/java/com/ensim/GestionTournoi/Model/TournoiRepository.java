package com.ensim.GestionTournoi.Model;

import com.ensim.GestionTournoi.Model.Coupe;
import com.ensim.GestionTournoi.Model.Tournoi;
import org.springframework.data.repository.CrudRepository;


public interface TournoiRepository extends CrudRepository<Tournoi, Long>

GestionTournoi/src/main/java/com/ensim/GestionTournoi/Model/ModelDAO/TournoiRepository.java
public interface TournoiRepository extends CrudRepository<Coupe,Integer>
{

}

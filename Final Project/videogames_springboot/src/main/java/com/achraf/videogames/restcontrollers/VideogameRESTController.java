package com.achraf.videogames.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.achraf.videogames.services.VideogameService;
import com.achraf.videogames.entities.Videogame; 
@RestController
@RequestMapping("/api")
@CrossOrigin
public class VideogameRESTController {
@Autowired
VideogameService videogameService;
@RequestMapping(method = RequestMethod.GET)
public List<Videogame> getAllVideogames(){
	return videogameService.getAllVideogames();
}

@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Videogame getVideogameById(@PathVariable("id") Long id) {
return videogameService.getVideogame(id);
 }

@RequestMapping(method = RequestMethod.POST)
public Videogame createVideogame(@RequestBody Videogame videogame) {
return videogameService.saveVideogame(videogame);
}

@RequestMapping(method = RequestMethod.PUT)
public Videogame updateVideogame(@RequestBody Videogame videogame) {
return videogameService.updateVideogame(videogame);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteVideogame(@PathVariable("id") Long id)
{
videogameService.deleteVideogameById(id);
}
@RequestMapping(value="/vidgen/{idGen}",method = RequestMethod.GET)
public List<Videogame> getVideogamesByCatId(@PathVariable("idGen") Long idGen) {
return videogameService.findByGenreIdGen(idGen);
}
@RequestMapping(value="/vidByName/{nom}",method = RequestMethod.GET)
public List<Videogame> findByNomVideogameContains(@PathVariable("nom") String nom) {
return videogameService.findByNomVideogameContains(nom);
}
}

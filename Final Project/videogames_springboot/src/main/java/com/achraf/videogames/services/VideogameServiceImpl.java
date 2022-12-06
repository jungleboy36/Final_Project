package com.achraf.videogames.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.achraf.videogames.entities.Genre;
import com.achraf.videogames.entities.Videogame;
import com.achraf.videogames.repos.VideogameRepository;
@Service
public class VideogameServiceImpl implements VideogameService{
    @Autowired
	VideogameRepository videogameRepository ;
    @Override
	public Videogame saveVideogame(Videogame v) {
		return videogameRepository.save(v);
	}

	@Override
	public Videogame updateVideogame(Videogame v) {
		return videogameRepository.save(v);
	}

	@Override
	public void deleteVideogame(Videogame v) {
		videogameRepository.delete(v);
		
	}

	@Override
	public void deleteVideogameById(Long id) {
		videogameRepository.deleteById(id);
		
	}

	@Override
	public Videogame getVideogame(long id) {
		return videogameRepository.findById(id).get();
	}

	@Override
	public List<Videogame> getAllVideogames() {
		return videogameRepository.findAll();
	}
	@Override
	public List<Videogame> findByNomVideogame(String nom) {
	return videogameRepository.findByNomVideogame(nom);
	}
	@Override
	public List<Videogame> findByNomVideogameContains(String nom) {
	return videogameRepository.findByNomVideogameContains(nom);
	}
	@Override
	public List<Videogame> findByNomPrix(String nom, Double prix) {
		return videogameRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<Videogame> findByGenre(Genre genre) {
	return videogameRepository.findByGenre(genre);
	}
	@Override
	public List<Videogame> findByGenreIdGen(Long id) {
	return videogameRepository.findByGenreIdGen(id);
	}
	@Override
	public List<Videogame> findByOrderByNomVideogameAsc() {
	return videogameRepository.findByOrderByNomVideogameAsc();
	}
	@Override
	public List<Videogame> trierVideogamesNomsPrix() {
	return videogameRepository.trierVideogamesNomsPrix();
	}


}

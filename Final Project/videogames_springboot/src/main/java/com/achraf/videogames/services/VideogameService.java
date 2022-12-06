package com.achraf.videogames.services;

import java.util.List;

import com.achraf.videogames.entities.Genre;
import com.achraf.videogames.entities.Videogame;

public interface VideogameService {
Videogame saveVideogame(Videogame v);
Videogame updateVideogame(Videogame v);
void deleteVideogame(Videogame v);
void deleteVideogameById(Long id);
Videogame getVideogame(long id);
List<Videogame> getAllVideogames();
List<Videogame> findByNomVideogame(String nom);
List<Videogame> findByNomVideogameContains(String nom);
List<Videogame> findByNomPrix (String nom, Double prix);
List<Videogame> findByGenre (Genre genre);
List<Videogame> findByGenreIdGen(Long id);
List<Videogame> findByOrderByNomVideogameAsc();
List<Videogame> trierVideogamesNomsPrix();

}

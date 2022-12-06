package com.achraf.videogames;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.achraf.videogames.entities.Genre;
import com.achraf.videogames.entities.Videogame;
import com.achraf.videogames.repos.VideogameRepository;

@SpringBootTest
class VideogamesApplicationTests {

	@Autowired
	private VideogameRepository videogameRepository;
	@Test
	public void testCreateVideogame() {
	Videogame vid = new Videogame("League of Legends",20,new Date());
	videogameRepository.save(vid);
	}
	@Test
    public void testFindVideogame() {
    Videogame v = videogameRepository.findById(3L).get();
    System.out.println(v);
    }
	
	@Test
	public void testUpdateVideogame()
	{
	Videogame v = videogameRepository.findById(1L).get();
	v.setPrixVideogame(1000.0);
	videogameRepository.save(v);
	}
    
	@Test
	public void testDeleteVideogame()
	{
	videogameRepository.deleteById(1L);;
	}
	 
	@Test
	public void testListerTousVideogames()
	{
	List<Videogame> vids = videogameRepository.findAll();
	for (Videogame v : vids)
	{
	System.out.println(v);
	}
	}
	@Test
	public void testFindVideogameByNom() {
		List<Videogame> vid = videogameRepository.findByNomVideogame("Valorant");
		for(Videogame v :vid)
		System.out.println(v);
	}
	@Test
	public void testFindVideogameByNomContains() {
		List<Videogame> vid = videogameRepository.findByNomVideogameContains("Valo");
		for(Videogame v :vid)
		System.out.println(v);
	}
	
	@Test
	public void testfindByNomPrix()
	{
	List<Videogame> vid = videogameRepository.findByNomPrix("Phasmophobia", 20.0);
	 for (Videogame v : vid)
	  {
	   System.out.println(v);}
	}

	
	@Test
	public void testfindByGenre()
	{
	Genre gen = new Genre();
	gen.setIdGen(1L);
	List<Videogame> vid = videogameRepository.findByGenre(gen);
	for (Videogame v : vid)
	{
	System.out.println(v);
	}
	}
	
	@Test
	public void findByCategorieIdCat()
	{
	List<Videogame> vid = videogameRepository.findByGenreIdGen(1L);
	for (Videogame v : vid)
	{
	System.out.println(v);
	}
	 }
	
	@Test
	public void testfindByOrderByNomVideogameAsc()
	{
	List<Videogame> vid = videogameRepository.findByOrderByNomVideogameAsc();
	for (Videogame v : vid)
	{
	System.out.println(v);
	}
	}
	
	@Test
	public void testTrierProduitsNomsPrix()
	{
	List<Videogame> vid = videogameRepository.trierVideogamesNomsPrix();
	for (Videogame v : vid)
	{
	System.out.println(v);
	}
	}

}

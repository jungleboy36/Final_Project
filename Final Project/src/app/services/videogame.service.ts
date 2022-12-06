import { Injectable } from '@angular/core';
import { Genre } from '../model/genre.model';
import { Videogame } from '../model/videogame.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { GenreWrapper } from '../model/genreWrapped.model';
const httpOptions = {
  headers: new HttpHeaders( {'Content-Type': 'application/json'} )
};
@Injectable({
providedIn: 'root'
})
export class VideogameService {
  apiURL: string = 'http://localhost:8081/videogames/api';
  apiURLGen: string = 'http://localhost:8081/videogames/gen';
videogames! : Videogame[]; //un tableau de Videogame
videogame! : Videogame ;
genres! : Genre[];
constructor(private http : HttpClient) {
 
}
listeVideogames():Observable<Videogame[]>{
  return this.http.get<Videogame[]>(this.apiURL);}

ajouterVideogame( vid: Videogame):Observable<Videogame>{
 return this.http.post<Videogame>(this.apiURL,vid,httpOptions);
}

supprimerVideogame( id : number){
  //supprimer le Videogame prod du tableau Videogames
  const url =  `${this.apiURL}/${id}`;
  return this.http.delete(url , httpOptions);
  }

  consulterVideogame(id:number): Observable<Videogame>{
    const url =  `${this.apiURL}/${id}`;
    return this.http.get<Videogame>(url);
    }

    updateVideogame(vid:Videogame) : Observable<Videogame>
{
// console.log(p);
//this.supprimerVideogame(p);
//this.ajouterVideogame(p);
return this.http.put<Videogame>(this.apiURL, vid , httpOptions) ;
}

trierVideogames(){
  this.videogames = this.videogames.sort((n1,n2) => {
  if (n1.idVideogame! > n2.idVideogame!) {
  return 1;
  }
  if (n1.idVideogame! < n2.idVideogame!) {
  return -1;
  }
  return 0;
  });
  }
  listeGenres():Observable<GenreWrapper>{
    return this.http.get<GenreWrapper>(this.apiURLGen);
  }
  consulterGenre(id:number):Genre{
    return this.genres.find(gen =>gen.idGen == id) ! ;
  }

  rechercherParGenre(idGen: number):Observable< Videogame[]> {
    const url = `${this.apiURL}/vidgen/${idGen}`;
    return this.http.get<Videogame[]>(url);
    }

    rechercherParNom(nom: string):Observable< Videogame[]> {
      const url = `${this.apiURL}/vidByName/${nom}`;
      return this.http.get<Videogame[]>(url);
      }

    ajouterGenre(gen : Genre): Observable<Genre> {
  return this.http.post<Genre>(this.apiURLGen,gen,httpOptions);
    }

    supprimerGenre(id : number){
      const url = `${this.apiURLGen}/${id}`;
      return this.http.delete(url, httpOptions);
    }
}
import { Component, OnInit } from '@angular/core';
import { Videogame } from '../model/videogame.model';
import { AuthService } from '../services/auth.service';
import { VideogameService } from '../services/videogame.service';
import { interval } from 'rxjs';
@Component({
  selector: 'app-videogames',
  templateUrl: './videogames.component.html',
  styleUrls: []
})
export class VideogamesComponent implements OnInit {
// videogames: string[] ;
  videogames! : Videogame[];
  constructor(private videogameService : VideogameService,public authService: AuthService) { 
      //this.videogames =videogameService.listeVideogames();
      }
  //  this.videogames = ["Phasmophobia","Valorant","Dead by Daylight"];
  

  ngOnInit(): void {
   this.chargerVideogames();

  }

  chargerVideogames(){
    this.videogameService.listeVideogames().subscribe(vids =>{console.log(vids);
    this.videogames = vids ;});}

  supprimerVideogame(v: Videogame){
    let conf = confirm("Do you really want to delete this game ?");
    if (conf)
    this.videogameService.supprimerVideogame(v.idVideogame!).subscribe(() => {
      console.log("Jeu supprimé");
      this.chargerVideogames();
    });
  }

}

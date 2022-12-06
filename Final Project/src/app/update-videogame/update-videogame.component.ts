import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { VideogameService } from '../services/videogame.service';
import { Videogame } from '../model/videogame.model';
import { Genre } from '../model/genre.model';
@Component({
  selector: 'app-update-videogame',
  templateUrl: './update-videogame.component.html',
  styleUrls: []
})
export class UpdateVideogameComponent implements OnInit {
  currentVideogame = new Videogame();
  genres ! : Genre[];
  updatedGenId! : number ;
  constructor(private activatedRoute: ActivatedRoute,private router : Router,private videogameService : VideogameService) 
  { }

  ngOnInit(): void {
   this.videogameService.listeGenres().subscribe(gen =>{console.log(gen); this.genres = gen._embedded.genres ; });
   this.videogameService.consulterVideogame(this.activatedRoute.snapshot.params['id']).subscribe(vid =>{this.currentVideogame = vid; this.updatedGenId = this.currentVideogame.genre.idGen;});
   //console.log(this.currentVideogame);
  }

  updateVideogame()
{ //console.log(this.currentProduit);
  this.currentVideogame.genre = this.genres.find(gen => gen.idGen == this.updatedGenId)!;
this.videogameService.updateVideogame(this.currentVideogame).subscribe(vid => {this.router.navigate(["videogames"]);});

}
}

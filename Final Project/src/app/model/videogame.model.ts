import { Genre } from "./genre.model";

export class Videogame {
    idVideogame? : number;
    nomVideogame? : string;
    prixVideogame? : number;
    dateCreation? : Date ;
    genre! : Genre ;
    }

export class User{
   username?:string ;
   password?: string ;
   roles?:string[];
     }
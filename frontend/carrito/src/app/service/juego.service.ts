import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Juego} from 'interfaces';

@Injectable({
  providedIn: 'root'
})
export class JuegoService {

  url : string = "http://localhost:8080/"

  constructor(private http: HttpClient) { }

  showJuegos():Observable<Juego[]>{
    //console.log("El servicio juego esta corriendo");
    return this.http.get<any>(this.url+"productos/show");
  }
}

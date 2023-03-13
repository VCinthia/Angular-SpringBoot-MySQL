import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from 'interfaces';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  url: string = "http://localhost:8080/usuarios/"

  constructor(private http: HttpClient) { }

  showUsuario(): Observable<Usuario[]> {
    //console.log("El servicio usuario esta corriendo");
    return this.http.get<any>(this.url + "show");
  }

  showUsuarioById(id: number): Observable<Usuario> {
    return this.http.get<any>(this.url + id);
  }

}

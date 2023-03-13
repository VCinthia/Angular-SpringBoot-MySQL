import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Detalle } from 'interfaces';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DetalleService {
  url: string = "http://localhost:8080/detalles/"

  constructor(private http: HttpClient) { }

  showDetalle(): Observable<Detalle[]> {//MOSTRAR TODOS LOS DETALLES INDEP DE EL USUARIO
    console.log("El servicio juego esta corriendo");
    return this.http.get<any>(this.url + "show");
  }

  showDetalleById(id: number): Observable<Detalle> {
    return this.http.get<any>(this.url + id);
  }

  createDatosDetalle(detalle: Detalle): Observable<Detalle> {
    return this.http.post<any>(this.url + "create", detalle);
  }

  editDatosDetalle(detalle: Detalle): Observable<Detalle> {
    return this.http.put<any>(this.url + "save", detalle);
  }

  deleteDatosDetalle(id: number): Observable<Detalle> {
    return this.http.delete<any>(this.url + "delete/" + id);
  }

}

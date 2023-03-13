import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Orden } from 'interfaces';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrdenService {

  url: string = "http://localhost:8080/ordenes/"

  constructor(private http: HttpClient) { }

  showOrden(): Observable<Orden[]> {//MOSTRAR TODOS LAS ORDENES INDEP DE EL USUARIO
    //console.log("El servicio orden esta corriendo");
    return this.http.get<any>(this.url + "show");
  }

  showOrdenById(id: number): Observable<Orden> {
    return this.http.get<any>(this.url + id);
  }

  createDatosOrden(orden: Orden): Observable<Orden> {
    return this.http.post<any>(this.url + "create", orden);
  }

  editDatosOrden(orden: Orden): Observable<Orden> {
    return this.http.put<any>(this.url + "save", orden);
  }

  deleteDatosOrden(id: number): Observable<Orden> {
    return this.http.delete<any>(this.url + "delete/" + id);
  }

}

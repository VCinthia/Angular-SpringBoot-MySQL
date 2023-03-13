import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AutenticacionService {

  url = "http://localhost:8080/usuarios"

  currentUserSubject: BehaviorSubject<any>;
  constructor(private http:HttpClient) {
    console.log("El servicio de autenticación está corriendo");
    this.currentUserSubject= new BehaviorSubject<any>(JSON.parse(sessionStorage.getItem('currentUser')||'{}'))
  }

    IniciarSesion(credenciales:any):Observable<any>{
      return this.http.post(this.url, credenciales).pipe(map(data=>{
        sessionStorage.setItem('currentUser'||'{}', JSON.stringify(data));
        this.currentUserSubject.next(data);
          return data;
       }))
      }
        
    get UsuarioAutenticado (){
      return this.currentUserSubject.value;
    }

    public logout(){
      sessionStorage.removeItem('currentUser');
    }

    public isUserLogged():boolean{
      return sessionStorage.getItem('currentUser')!== null;
    }
}

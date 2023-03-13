import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Juego } from 'interfaces';
import { AutenticacionService } from 'src/app/service/autenticacion.service';
import { JuegoService } from 'src/app/service/juego.service';

@Component({
  selector: 'app-juegos',
  templateUrl: './juegos.component.html',
  styleUrls: ['./juegos.component.css']
})
export class JuegosComponent implements OnInit {
  productoList: Juego[] = [];
  isUserLogged: Boolean = false;

  productoForm: FormGroup;

  constructor(
    private datosJuego: JuegoService,
    private autenticacion: AutenticacionService,
    private formBuilder: FormBuilder) {
    this.productoForm = this.formBuilder.group({
      id: [''],
      nombre: [''],
      descripcion: [''],
      imagen: [''],
      precio: [''],
    });
  }

  ngOnInit(): void {
    this.isUserLogged = this.autenticacion.isUserLogged();
    this.reloadData();
  }

  private reloadData() {
    this.datosJuego.showJuegos().subscribe(
      (data) => {
        this.productoList = data;
      });
  }

  /* private clearForm(){
    this.productoForm.setValue({
      id: '',
      nombre: '',
      descripcion: '',
      imagen: '',
      precio: ''
    });
  }

  private loadForm(juego : Juego){
    this.productoForm.setValue({
      id : juego.id,
      nombre : juego.nombre,
      descripcion : juego.descripcion,
      imagen : juego.imagen,
      precio : juego.precio
    })
  } */

}

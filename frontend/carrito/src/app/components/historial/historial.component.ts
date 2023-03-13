import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Orden } from 'interfaces';
import { AutenticacionService } from 'src/app/service/autenticacion.service';
import { OrdenService } from 'src/app/service/orden.service';

@Component({
  selector: 'app-historial',
  templateUrl: './historial.component.html',
  styleUrls: ['./historial.component.css']
})
export class HistorialComponent implements OnInit {

  ordenList: Orden[] = [];
  isUserLogged: Boolean = false;

  ordenForm: FormGroup;

  date = document.querySelector('#fecha-carrito');
  
  constructor(
    private datosOrden: OrdenService,
    private autenticacion: AutenticacionService,
    private formBuilder: FormBuilder) {
    this.ordenForm = this.formBuilder.group({
      id: [''],
      esPromo: [''],
      fechaCreacion: [''],
      subtotal: [''],
      total: [''],
      usuario: [''],
    });
  }

  ngOnInit(): void {
    this.isUserLogged = this.autenticacion.isUserLogged();
    this.reloadData();
  }

  private reloadData() {
    this.datosOrden.showOrden().subscribe(
      (data) => {
        this.ordenList = data;
      });
  }

  private clearForm() {
    this.ordenForm.setValue({
      id: '',
      esPromo: '',
      fechaCreacion: '',
      subtotal: '',
      total: '',
      usuario: '',
    });
  }

  private loadForm(orden: Orden) {
    this.ordenForm.setValue({
      id: orden.id,
      esPromo: orden.esPromo,
      date: orden.fechaCreacion,
      subtotal: orden.subtotal,
      total: orden.total,
      usuario: orden.usuario
    });
  }

  onSubmit() {
    //console.log(this.ordenForm.value);
    let orden: Orden = this.ordenForm.value;
    if (this.ordenForm.get('id')?.value == '') {
      this.datosOrden.createDatosOrden(orden).subscribe(
        (nuevaOrden: Orden) => {
          this.ordenList.push(nuevaOrden);
        }
      );
    } else {
      this.datosOrden.editDatosOrden(orden).subscribe(
        () => {
          this.reloadData();
        })
    }
  }

  onCreateOrden() {
    this.clearForm();
  }

  onEditOrden(index: number) {
    let orden : Orden = this.ordenList[index];
    this.loadForm(orden);
  }

  onDeleteOrden(index: number) {
    let orden: Orden = this.ordenList[index];
    if (confirm("¿Está seguro que desea borrar la Orden?")) {
      this.datosOrden.deleteDatosOrden(orden.id).subscribe(() => {
        this.reloadData();
      })
    }
  }

}

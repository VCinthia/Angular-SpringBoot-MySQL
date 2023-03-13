import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Detalle } from 'interfaces';
import { AutenticacionService } from 'src/app/service/autenticacion.service';
import { DetalleService } from 'src/app/service/detalle.service';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css']
})

export class CarritoComponent implements OnInit {
  detalleList: Detalle[] = [];
  isUserLogged: Boolean = false;

  detalleForm: FormGroup;

  constructor(
    private datosDetalle: DetalleService,
    private autenticacion: AutenticacionService,
    private formBuilder: FormBuilder) {
    this.detalleForm = this.formBuilder.group({
      id: [''],
      cantidad: [''],
      subtotal: [''],
      ordenId: [''],
      productoId: [''],
    });
  }

  ngOnInit(): void {
    this.isUserLogged = this.autenticacion.isUserLogged();
    this.reloadData();
  }

  private reloadData() {
    this.datosDetalle.showDetalle().subscribe(
      (data) => {
        this.detalleList = data;
      });
  }

  private clearForm() {
    this.detalleForm.setValue({
      id: '',
      cantidad: '',
      subtotal: '',
      ordenId: '',
      productoId: '',
    });
  }

  private loadForm(detalle: Detalle) {
    this.detalleForm.setValue({
      id: detalle.id,
      cantidad: detalle.cantidad,
      subtotal: detalle.subtotal,
      ordenId: detalle.ordenId,
      productoId: detalle.productoId
    })
  }

  onSubmit() {
    //console.log(this.detalleForm.value);
    let detalle: Detalle = this.detalleForm.value;
    if (this.detalleForm.get('id')?.value == '') {
      this.datosDetalle.createDatosDetalle(detalle).subscribe(
        (nuevoDetalle: Detalle) => {
          this.detalleList.push(nuevoDetalle);
        }
      );
    } else {
      this.datosDetalle.editDatosDetalle(detalle).subscribe(
        () => {
          this.reloadData();
        })
    }
  }

  onCreateDetalle() {
    this.clearForm();
  }

  onEditDetalle(index: number) {
    let detalle : Detalle = this.detalleList[index];
    //if(detalle.cantidad>0)
    this.loadForm(detalle);
  }

  onDeleteDetalle(index: number) {
    let detalle: Detalle = this.detalleList[index];
    if (confirm("¿Está seguro que desea borrar el Detalle?")) {
      this.datosDetalle.deleteDatosDetalle(detalle.id).subscribe(() => {
        this.reloadData();
      })
    }
  }

}

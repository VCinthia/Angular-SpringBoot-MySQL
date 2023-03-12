import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CarritoComponent } from "./components/carrito/carrito.component";
import { ClientesComponent } from "./components/clientes/clientes.component";
import { HistorialComponent } from "./components/historial/historial.component";
import { JuegosComponent } from "./components/juegos/juegos.component";
import { LoginComponent } from "./components/login/login.component";
import { WebComponent } from "./components/web/web.component";

const routes : Routes = [
    { path : '', redirectTo: '/home', pathMatch: 'full' },
    { path : 'inicio', component : WebComponent },
    { path: 'juegos', component: JuegosComponent },
    { path: 'carrito', component: CarritoComponent },
    { path: 'historial', component: HistorialComponent },
    { path: 'clientes', component: ClientesComponent },
    { path: 'login', component: LoginComponent },
    { path: '**', component: WebComponent },
];

@NgModule({
    imports : [RouterModule.forRoot(routes)],
    exports : [RouterModule]
})

export class AppRoutingModule {}
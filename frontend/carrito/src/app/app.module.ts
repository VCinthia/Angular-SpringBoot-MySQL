import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { NavComponent } from './components/header/nav/nav.component';
import { BannerComponent } from './components/header/banner/banner.component';
import { BodyComponent } from './components/body/body.component';
import { FooterComponent } from './components/footer/footer.component';
import { WebComponent } from './components/web/web.component';
import { JuegosComponent } from './components/juegos/juegos.component';
import { AppRoutingModule } from './app-routing.module';
import { CarritoComponent } from './components/carrito/carrito.component';
import { HistorialComponent } from './components/historial/historial.component';
import { LoginComponent } from './components/login/login.component';
import { ClientesComponent } from './components/clientes/clientes.component';
import { JuegoService } from './service/juego.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InterceptorService } from './service/interceptor.service';
import { DetalleService } from './service/detalle.service';
import { UsuarioService } from './service/usuario.service';
import { OrdenService } from './service/orden.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavComponent,
    BannerComponent,
    BodyComponent,
    FooterComponent,
    WebComponent,
    JuegosComponent,
    CarritoComponent,
    HistorialComponent,
    LoginComponent,
    ClientesComponent
  ],
  imports: [
    BrowserModule,    
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [JuegoService, DetalleService, UsuarioService, OrdenService,
    { provide:HTTP_INTERCEPTORS, useClass: InterceptorService, multi: true },],
  bootstrap: [AppComponent]
})
export class AppModule { }

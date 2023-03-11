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
    LoginComponent
  ],
  imports: [
    BrowserModule,    
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

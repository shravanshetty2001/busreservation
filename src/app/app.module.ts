import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BusListRenderComponent } from './bus-list-render/bus-list-render.component';
import { SearReservationComponent } from './sear-reservation/sear-reservation.component';



@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    BusListRenderComponent,
    SearReservationComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

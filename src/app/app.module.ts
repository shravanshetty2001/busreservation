import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';

import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDialogModule } from '@angular/material/dialog';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegisterComponent } from './register/register.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { AdminComponent } from './admin/admin.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import {UserService} from './services/user.service'
import {HttpClientModule} from '@angular/common/http'
import { AdminregisterComponent } from './adminregister/adminregister.component';

import { SeatReservationComponent } from './seat-reservation/seat-reservation.component';
import { UnauthorizedUserDataFormComponent } from './unauthorized-user-data-form/unauthorized-user-data-form.component';
import { TicketFormComponent } from './ticket-form/ticket-form.component';

import { WalletComponent } from './wallet/wallet.component';
import { PaymentService } from './services/payment.service';


import { AddbusformComponent } from './addbusform/addbusform.component';
import { ViewbuslistComponent } from './viewbuslist/viewbuslist.component';
import { AddbustimetableComponent } from './addbustimetable/addbustimetable.component';
import { ViewbustimetableComponent } from './viewbustimetable/viewbustimetable.component';
import { AdminforgotpasswordComponent } from './adminforgotpassword/adminforgotpassword.component';
import { AdminupdatepasswordComponent } from './adminupdatepassword/adminupdatepassword.component';
import { CommonModule } from '@angular/common';
import { ResulCardComponent } from './resul-card/resul-card.component';
import { BusListRenderComponent } from './bus-list-render/bus-list-render.component';



@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginComponent,
    RegisterComponent,
    ForgotpasswordComponent,
    AdminComponent,
    AdmindashboardComponent,
    AdminregisterComponent,
    SeatReservationComponent,
    UnauthorizedUserDataFormComponent,
    TicketFormComponent,
    WalletComponent,
    AddbusformComponent,
    ViewbuslistComponent,
    AddbustimetableComponent,
    ViewbustimetableComponent,
    AdminforgotpasswordComponent,
    AdminupdatepasswordComponent,
    ResulCardComponent,
    BusListRenderComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MatDialogModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    HttpClientModule,
    FormsModule,
    CommonModule
  ],
  providers: [UserService,PaymentService],
  bootstrap: [AppComponent]
})
export class AppModule { }

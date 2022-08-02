import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddbusformComponent } from './addbusform/addbusform.component';
import { AddbustimetableComponent } from './addbustimetable/addbustimetable.component';
import { AdminComponent } from './admin/admin.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { AdminforgotpasswordComponent } from './adminforgotpassword/adminforgotpassword.component';
import { AdminregisterComponent } from './adminregister/adminregister.component';

import { BusListRenderComponent } from './bus-list-render/bus-list-render.component';
import { SeatReservationComponent } from './seat-reservation/seat-reservation.component';
import { TicketFormComponent } from './ticket-form/ticket-form.component';

import { AdminupdatepasswordComponent } from './adminupdatepassword/adminupdatepassword.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ViewbuslistComponent } from './viewbuslist/viewbuslist.component';
import { ViewbustimetableComponent } from './viewbustimetable/viewbustimetable.component';


const routes: Routes = [
  {path:'', component:DashboardComponent},
  {path:'adminlogin', component:AdminComponent},
  {path:'admindashboard', component:AdmindashboardComponent},
  {path:'adminregister', component:AdminregisterComponent},
  {path:'buslist', component:BusListRenderComponent},
  {path: 'seatbook', component:SeatReservationComponent},
  {path:'ticket', component: TicketFormComponent},
  {path:'addbus', component:AddbusformComponent},
  {path:'viewbus', component:ViewbuslistComponent},
  {path:'addbustimetable', component:AddbustimetableComponent},
  {path:'viewbustimetable', component:ViewbustimetableComponent},
  {path:'adminforgotpassword', component:AdminforgotpasswordComponent},
  {path:'resetpassword/:id', component:AdminupdatepasswordComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

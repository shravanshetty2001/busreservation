import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { AdminregisterComponent } from './adminregister/adminregister.component';
import { BusListRenderComponent } from './bus-list-render/bus-list-render.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SeatReservationComponent } from './seat-reservation/seat-reservation.component';
import { TicketFormComponent } from './ticket-form/ticket-form.component';

const routes: Routes = [
  {path:'', component:DashboardComponent},
  {path:'adminlogin', component:AdminComponent},
  {path:'admindashboard', component:AdmindashboardComponent},
  {path:'adminregister', component:AdminregisterComponent},
  {path:'buslist', component:BusListRenderComponent},
  {path: 'seatbook', component:SeatReservationComponent},
  {path:'ticket', component: TicketFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

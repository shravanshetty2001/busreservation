import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BusListRenderComponent } from './bus-list-render/bus-list-render.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SearReservationComponent } from './sear-reservation/sear-reservation.component';

const routes: Routes = [
  {path:'', component:DashboardComponent},
  {path:'buslist', component:BusListRenderComponent},
  {path: 'seatbook', component:SearReservationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

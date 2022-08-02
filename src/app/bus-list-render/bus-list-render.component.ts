import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UnauthorizedUserDataFormComponent } from '../unauthorized-user-data-form/unauthorized-user-data-form.component';

@Component({
  selector: 'app-bus-list-render',
  templateUrl: './bus-list-render.component.html',
  styleUrls: ['./bus-list-render.component.css']
})
export class BusListRenderComponent implements OnInit {


  constructor(
    private controlDialog:MatDialog,
    
  ) { }

  buslogo:String="assets/img/buslogo.jpeg"

  ngOnInit(): void {
   
  }


  bookingAction(){
    this.controlDialog.open(UnauthorizedUserDataFormComponent,{
      disableClose: true ,
      width: '31%',
      height: '45%'

    });
  }

}

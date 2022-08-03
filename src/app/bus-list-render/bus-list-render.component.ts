import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddBustimetableDto } from '../class/add-bustimetable-dto';
import { ResultService } from '../services/result.service';
import { UnauthorizedUserDataFormComponent } from '../unauthorized-user-data-form/unauthorized-user-data-form.component';
import { CommonModule } from '@angular/common';
import { Seat } from '../class/seat';
import { UserdetailDto } from '../classcomponents/UserdetailDto';
import { SeatReservationComponent } from '../seat-reservation/seat-reservation.component';

@Component({
  selector: 'app-bus-list-render',
  templateUrl: './bus-list-render.component.html',
  styleUrls: ['./bus-list-render.component.css']
})
export class BusListRenderComponent implements OnInit {
  
  
  searchResult: AddBustimetableDto[];



  constructor(
    private controlDialog:MatDialog,
    private resultservice: ResultService
  ) { }

  buslogo:String="assets/img/buslogo.jpeg"

  ngOnInit(): void {
    this.searchResult = this.resultservice.result;
    console.log(this.searchResult);
  }

  bookingAction(){

    let bid: Number = (Number)((<HTMLInputElement>document.getElementById("Id")).value);
    let price: any = (<HTMLInputElement>document.getElementById("price")).value
    console.log(price);
    
    this.resultservice.busno = bid;
    this.resultservice.price = price;

    if(sessionStorage.getItem("loginStatus")=='true'){

      this.controlDialog.open(SeatReservationComponent,{
        disableClose: true ,
        width: '60%',
        height: '56%'
      });

     
    }
    
    else{
      this.controlDialog.open(UnauthorizedUserDataFormComponent,{
        disableClose: true ,
        width: '31%',
        height: '45%'

      });
  
  }

}
}



import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddBustimetableDto } from '../class/add-bustimetable-dto';
import { ResultService } from '../services/result.service';
import { UnauthorizedUserDataFormComponent } from '../unauthorized-user-data-form/unauthorized-user-data-form.component';
import { CommonModule } from '@angular/common';

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
    this.controlDialog.open(UnauthorizedUserDataFormComponent,{
      disableClose: true ,
      width: '31%',
      height: '45%'

    });
  }

}

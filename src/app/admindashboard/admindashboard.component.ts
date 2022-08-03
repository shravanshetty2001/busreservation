import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent implements OnInit {

  constructor() {}
  addBus:String = "assets/img/addbus.jpg";
  viewBus:String = "assets/img/viewbus.png";
  addTimetable:String = "assets/img/addtimetable.png";
  viewTimetable:String = "assets/img/viewtimetable.png";

  ngOnInit(): void {
    
  }

}

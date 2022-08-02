import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-viewbustimetable',
  templateUrl: './viewbustimetable.component.html',
  styleUrls: ['./viewbustimetable.component.css']
})
export class ViewbustimetableComponent implements OnInit {

  constructor() { }
  buslogo: String = "assets/img/buslogo.jpeg";
  ngOnInit(): void {
  }

}

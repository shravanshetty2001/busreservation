import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-viewbuslist',
  templateUrl: './viewbuslist.component.html',
  styleUrls: ['./viewbuslist.component.css']
})
export class ViewbuslistComponent implements OnInit {

  constructor() { }
  buslogo: String = "assets/img/buslogo.jpeg";

  ngOnInit(): void {
  }

}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bus-list-render',
  templateUrl: './bus-list-render.component.html',
  styleUrls: ['./bus-list-render.component.css']
})
export class BusListRenderComponent implements OnInit {

  constructor() { }

  buslogo:String="assets/img/buslogo.jpeg"

  ngOnInit(): void {
  }

}

import { Component, OnInit } from '@angular/core';
import { BuslistDto } from '../class/buslist-dto';
import { Viewbus } from '../class/viewbus';
import { ViewbusService } from '../service/viewbus.service';

@Component({
  selector: 'app-viewbuslist',
  templateUrl: './viewbuslist.component.html',
  styleUrls: ['./viewbuslist.component.css']
})
export class ViewbuslistComponent implements OnInit {

  constructor(private service:ViewbusService) { }
  buslogo: String = "assets/img/buslogo.jpeg";
  view:Viewbus=new Viewbus();
  buslist:BuslistDto[]=[];

  admin:number;

  ngOnInit(): void {
    this.admin=JSON.parse(sessionStorage.getItem('adminlogininfo'))['id'];
    this.service.addBus(this.admin).subscribe(
      (datas) => {
        datas.map(data=>
          {
            let bus: BuslistDto={
              id:data.id,
              busType:data.busType,
              noSeats:data.noSeats,
              busNo:data.busNo,
              sleeper:data.sleeper,
              ac:data.ac,
              admin:data.admin

            }
            this.buslist.push(bus);
          }
          )

      }
      );
  }

}

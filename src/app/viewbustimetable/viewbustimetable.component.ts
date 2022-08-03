import { Component, OnInit } from '@angular/core';
import { AddBustimetableDto } from '../class/add-bustimetable-dto';
import { ViewbusService } from '../service/viewbus.service';

@Component({
  selector: 'app-viewbustimetable',
  templateUrl: './viewbustimetable.component.html',
  styleUrls: ['./viewbustimetable.component.css']
})
export class ViewbustimetableComponent implements OnInit {

  constructor(private service: ViewbusService) { }
  bustimetable:AddBustimetableDto[]=[];
  admin:number;
  ngOnInit(): void {
    this.admin=JSON.parse(sessionStorage.getItem('adminlogininfo'))['id'];
    this.service.addBusTt(this.admin).subscribe(
      (datas) => {
        datas.map(data=>
          {
            let bustimedata: AddBustimetableDto={
              sDatetime:data.sDatetime,
              dDatetime:data.dDatetime,
              sourcePlace:data.sourcePlace,
              desnPlace:data.desnPlace,
              blid:data.blid,
              sourceplaceid:data.sourceplaceid,
              desnplaceid:data.desnplaceid,
              price:data.price
  
            }
            this.bustimetable.push(bustimedata);
          }
          )
      }

    );
  }

}

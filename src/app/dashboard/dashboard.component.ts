import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AddBustimetableDto } from '../class/add-bustimetable-dto';
import { Place } from '../class/place';
import { PlacesService } from '../services/places.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  places: Place[] = [];
  addbustimetableDto: AddBustimetableDto = new AddBustimetableDto();
  checkavailabilityForm: FormGroup;
  sourceplace:String;
  desnplace:String;
  journeyDate:Date;
  
  constructor(
    private route: Router,
    private placeservices: PlacesService,
    private formBuilder : FormBuilder
  ) { }

  ngOnInit(): void {

    this.checkavailabilityForm = this.formBuilder.group({});

    this.placeservices.getPlaces().subscribe(
      
      (items)=>{
        console.log(items);
        items.map(item => {
          let place : Place = {
            pid:item.pid,
            placeName: item.placeName
          }
          this.places.push(place);
        }
      )

      }
      
    )
    console.log(this.places);
  }

  checkavailability( jd:String)
  {
    let dp:any = (<HTMLInputElement>document.getElementById("srcplace")).value;
    let sp:any = (<HTMLInputElement>document.getElementById("desntplace")).value;
    
    let bstb : AddBustimetableDto = {
      sDatetime: jd,
      sourcePlace: sp,
      desnPlace: dp,
      dDatetime: undefined,
      Blid: 0,
      sourceplaceid: 0,
      desnplaceid: 0,
      price: 0
    }
      console.log(bstb.sDatetime);
      console.log(bstb.desnPlace);
      console.log(bstb.sourcePlace);
  }

}

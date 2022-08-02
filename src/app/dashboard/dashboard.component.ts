import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AddBustimetableDto } from '../class/add-bustimetable-dto';
import { Place } from '../class/place';
import { CheckAvailabilityService } from '../services/check-availability.service';
import { PlacesService } from '../services/places.service';
import { ResultService } from '../services/result.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  places: Place[] = [];
  bustimetablelist: AddBustimetableDto[] = [];
  addbustimetableDto: AddBustimetableDto = new AddBustimetableDto();
  checkavailabilityForm: FormGroup;
  sourceplace:String;
  desnplace:String;
  journeyDate:Date;
  
  constructor(
    private route: Router,
    private placeservices: PlacesService,
    private resultservice: ResultService,
    private formBuilder : FormBuilder,
    private checkavailabilityservice: CheckAvailabilityService,
    
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

  checkavailability()
  {
    let sp:any = (<HTMLInputElement>document.getElementById("srcplace")).value;
    let dp:any = (<HTMLInputElement>document.getElementById("desntplace")).value;
    let jd:any = (<HTMLInputElement>document.getElementById("journeyDate")).value;
    
    let bstb : AddBustimetableDto = {
      sDatetime: jd,
      sourcePlace: sp,
      desnPlace: dp,
      dDatetime: undefined,
      blid: 0,
      sourceplaceid: 0,
      desnplaceid: 0,
      price: 0,
      id: undefined
    }
      this.checkavailabilityservice.getBusForUser(bstb).subscribe(
        (items)=>{
          console.log(items);
          items.map(item => {
            let ptr : AddBustimetableDto = {
              sDatetime: item.sDatetime,
              dDatetime: item.dDatetime,
              sourcePlace: item.sourcePlace,
              desnPlace: item.desnPlace,
              blid: item.blid,
              sourceplaceid: item.sourceplaceid,
              desnplaceid: item.desnplaceid,
              price: item.price,
              id: item.id
            }
            this.bustimetablelist.push(ptr);
            
          }
        )
          this.resultservice.result = this.bustimetablelist;
          this.route.navigate(['/buslist']);
        }
        
      );
  }
}

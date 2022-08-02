import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AddBustimetableDto } from '../class/add-bustimetable-dto';
import { AdminData } from '../class/admin-data';
import { Place } from '../class/place';
import { BustimetableService } from '../service/bustimetable.service';
import { PlacesService } from '../services/places.service';

@Component({
  selector: 'app-addbustimetable',
  templateUrl: './addbustimetable.component.html',
  styleUrls: ['./addbustimetable.component.css']
})
export class AddbustimetableComponent implements OnInit 
{

  registerForm: FormGroup;
  submitted = false;
  message: boolean;
  ermessage: String;
  addBtt: AddBustimetableDto = new AddBustimetableDto();
  constructor(private formBuilder: FormBuilder, private service: BustimetableService, private placeservices: PlacesService) { }
  places: Place[] = [];
  onSubmit() {

    this.submitted = true;
    //  this.message=false;
    if (this.registerForm.invalid) {
      console.log("invalid");
      return;
    }
    if (this.submitted) {
      console.log(JSON.stringify(this.addBtt));



      this.service.addBus(this.addBtt).subscribe(
        (data) => {
          console.log(data);
          alert("Bus time table Added Successfully");
        }
      );


    }
  }
  get f() { return this.registerForm.controls; }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      bustype: ['', [Validators.required]],
      sdate: ['', [Validators.required]],
      ddate: ['', [Validators.required]],
      source: [],
      desn: [],
      price: ['', [Validators.required]],
    });
    this.placeservices.getPlaces().subscribe(

      (items) => {
        console.log(items);
        items.map(item => {
          let place: Place = {
            pid: item.pid,
            placeName: item.placeName
          }
          this.places.push(place);
        }
        );

      
    })
  }
}

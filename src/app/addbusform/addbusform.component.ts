import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminData } from '../class/admin-data';
import { BuslistDto } from '../class/buslist-dto';
import { AddBusDtoService } from '../service/add-bus-dto.service';

@Component({
  selector: 'app-addbusform',
  templateUrl: './addbusform.component.html',
  styleUrls: ['./addbusform.component.css']
})
export class AddbusformComponent implements OnInit {
  addBusForm: FormGroup;
  submitted = false;
  message: boolean;
  ermessage: String;
  bus: BuslistDto=new BuslistDto();

  constructor(private formBuilder: FormBuilder, private service: AddBusDtoService, private router: Router) { }
  ngOnInit(): void {
    this.addBusForm = this.formBuilder.group({
      bustype: ['', [Validators.required]],
      nos: ['', [Validators.required, Validators.nullValidator]],
      busno: ['', [Validators.required]]
    });
  }
  get f() { return this.addBusForm.controls; }
  onSubmit() {
    console.log("submit");
    this.submitted = true;
    //  this.message=false;
    if (this.addBusForm.invalid) {
      console.log("invalid");
      return;
    }
    if (this.submitted) {
      let ad:AdminData=JSON.parse(sessionStorage.getItem('adminlogininfo'));
      this.bus.admin=ad.id;
      console.log(this.bus.admin);
      this.service.addBus(this.bus).subscribe(
        (data) => {
          console.log(data);
          this.dashboardredirect();
        }
      );
    }






  } dashboardredirect() {
      console.log("condition" + this.message);
      this.router.navigate(['/admindashboard']);
      alert("Bus Added Successfully");;
  }
}


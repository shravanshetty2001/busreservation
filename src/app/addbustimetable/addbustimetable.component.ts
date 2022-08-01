import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-addbustimetable',
  templateUrl: './addbustimetable.component.html',
  styleUrls: ['./addbustimetable.component.css']
})
export class AddbustimetableComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  message: boolean;
  ermessage: String;
  constructor(private formBuilder: FormBuilder) { }

  onSubmit()
  {
    this.submitted = true;
    //  this.message=false;
    if (this.registerForm.invalid) {
      return;
    }
  } 
  get f() { return this.registerForm.controls; }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      bustype: ['', [Validators.required]],
      sdate: ['', [Validators.required]],
      ddate: ['', [Validators.required]],
      source: ['', [Validators.required]],
      desn: ['', [Validators.required]],
      price: ['', [Validators.required,Validators.nullValidator]],
    });

}
}
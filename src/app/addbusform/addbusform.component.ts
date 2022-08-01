import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addbusform',
  templateUrl: './addbusform.component.html',
  styleUrls: ['./addbusform.component.css']
})
export class AddbusformComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;
  message: boolean;
  ermessage: String;
  constructor(private formBuilder: FormBuilder) { }
  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      bustype: ['', [Validators.required]],
      nos: ['', [Validators.required,Validators.nullValidator]],
      busno: ['', [Validators.required]],
      sleeper: ['', [Validators.required]],
      ac:['',[Validators.required]]
    });
  }

  onSubmit()
  {
    this.submitted = true;
    //  this.message=false;
    if (this.registerForm.invalid) {
      return;
    }
  } 
  get f() { return this.registerForm.controls; }





}

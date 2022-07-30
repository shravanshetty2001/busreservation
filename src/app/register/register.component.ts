import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Userdetail } from '../classcomponents/Userdetail';
import { UserdetailDto } from '../classcomponents/UserdetailDto';
import {UserService} from '../services/user.service'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  message:any;
  userdetailDto:UserdetailDto=new UserdetailDto();
  userdetails:Userdetail[];

  constructor(private formBuilder: FormBuilder,
    private controlRegisterDialog:MatDialogRef<RegisterComponent>,
    private userService:UserService
    ) { }

  ngOnInit(): void {
    this.registerForm=this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      name: ['', [Validators.required, Validators.minLength(6)]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      contact: ['',[Validators.required,Validators.pattern('^\\d{10}$')]]
    });
  }

  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }
    if (this.submitted) {
      console.log(this.userdetailDto.email);
      console.log(this.userdetailDto.password);
      this.registerData();
      this.closeRegisterDialog();
    }
  }

  closeRegisterDialog(){
    this.controlRegisterDialog.close();
  }

  public registerData(){
    this.userService.doRegistration(this.userdetailDto).subscribe(data=>{
      console.log(data);
    });
    
  }
  public getData(){
    this.userService.getUserList().subscribe(data=>{
     console.log(data);
    });
    
  }

}

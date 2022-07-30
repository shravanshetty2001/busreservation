import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { ForgotpasswordComponent } from '../forgotpassword/forgotpassword.component';
import { RegisterComponent } from '../register/register.component';
import {UserService} from '../services/user.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  registerForm: FormGroup;
  submitted = false;


  constructor(private formBuilder: FormBuilder,
              private controlLoginDialog:MatDialogRef<LoginComponent>,
              private controlDialog:MatDialog,
              private userService:UserService
              ) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
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
      
      this.closeLogin();
    }
  }

  closeLogin(){
    this.getData()
    this.controlLoginDialog.close();
  }
  
  openForgotPasswordDialog(){
    this.closeLogin();
    this.controlDialog.open(ForgotpasswordComponent,{ 
      disableClose: true ,
      width: '40%',
      height: '65%'
    });
  }

  openRegisterDialog(){
    this.controlLoginDialog.close();
    this.controlDialog.open(RegisterComponent,{ 
      disableClose: true ,
      width: '40%',
      height: '65%'
    });
  }

  public getData(){
    this.userService.getUserList().subscribe(data=>{
     console.log(data);
    });
    
  }


}

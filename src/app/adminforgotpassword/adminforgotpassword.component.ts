import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from '../class/admin';
import { Adminforgotpassword } from '../class/adminforgotpassword';

import { AdminforgotpasswordService } from '../service/adminforgotpassword.service';

@Component({
  selector: 'app-adminforgotpassword',
  templateUrl: './adminforgotpassword.component.html',
  styleUrls: ['./adminforgotpassword.component.css']
})
export class AdminforgotpasswordComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  message: boolean;
  ermessage: String;
  admin:Adminforgotpassword=new Adminforgotpassword();

  constructor(private formBuilder: FormBuilder,private service: AdminforgotpasswordService,private router:Router) { }

  ngOnInit(): void {
    this.registerForm= this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]]
    });
  }

  get f() { return this.registerForm.controls; }
  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if(this.submitted)
    {
      this.service.doForgotPassword(this.registerForm.value).subscribe(
        (data) => {
          this.message = data['status'];
          this.ermessage=data['errorMessage']
          this.dashboardredirect(this.message,this.ermessage);
        }
      );
    }
    if (this.registerForm.invalid) {
      return;
    }

    
    
  }
  
  
  dashboardredirect(_message: boolean, _ermessage: String) {
    if (this.message) {
      console.log("condition" + this.message);
      alert("Mail Sent Successfully. Check your mail which will redirect you to your password update page");
    }
    else {
      alert("Mail not sent: " + this.ermessage);
    };
  }

}

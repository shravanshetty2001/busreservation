import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminData } from '../class/admin-data';
import { AdminStatusdto } from '../class/admin-statusdto';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;
  us: AdminData;
  constructor(private formBuilder: FormBuilder, private service: AdminService, private router: Router) { }
  admin: AdminData = new AdminData();
  message: boolean;
  ermessage:String;
  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }
  get f() { return this.registerForm.controls; }
  onSubmit() {
    this.submitted = true;
    //  this.message=false;
    if (this.registerForm.invalid) {
      return;
    }
    if (this.submitted) {
      this.service.doLogin(this.admin).subscribe(
        (data) => {
          this.message = data['status'];
          this.ermessage=data['errorMessage'];
          // this.adminDto=data['adminDto'];
          // console.log(this.adminDto.email);
          let adminStatusdto:AdminStatusdto=data;
          this.us=adminStatusdto.admin;
          console.log(data);
          // console.log(this.us.email);
          console.log(this.message);
          this.dashboardredirect(this.message,this.ermessage,this.us);
        }
      );

    }

    }
    dashboardredirect(_message: boolean,_ermessage:String,_adminDto:AdminData) {
      if (this.message) {
        
        sessionStorage.setItem('adminlogininfo',JSON.stringify(this.us));
        sessionStorage.setItem('adminloginStatus',"true");
        this.us=JSON.parse(sessionStorage.getItem('adminlogininfo'));
        
        this.router.navigate(['/admindashboard']);
      }
      else {
        alert("Admin Registeration Failed" + this.ermessage);
      };
  }
  openForgotPasswordDialog() {

  }


}



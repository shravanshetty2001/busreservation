import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from '../class/admin';
import { AdminData } from '../class/admin-data';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;
  adminDto: AdminData;
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
          this.adminDto=data['adminDto'];
          console.log(this.message);
          this.dashboardredirect(this.message,this.ermessage,this.adminDto);
        }
      );

    }

    }
    dashboardredirect(_message: boolean,_ermessage:String,_adminDto:AdminData) {
      if (this.message) {
        this.router.navigate(['/admindashboard']);
        sessionStorage.setItem('username',this.adminDto.email);
        sessionStorage.setItem('status',this.message.toString());
        alert("Admin Logged In Successfully");
      }
      else {
        alert("Admin Registeration Failed" + this.ermessage);
      };
  }
  openForgotPasswordDialog() {

  }


}



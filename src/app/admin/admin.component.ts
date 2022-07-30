import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;
  constructor(private formBuilder: FormBuilder, private service: AdminService, private router: Router) { }
  admin: Admin = new Admin();
  message: any;
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
          this.message = data;
          dashboardredirect(this.message);
        }
      );

    }
  }
  openForgotPasswordDialog() {

  }


}
function dashboardredirect(message: any) {
  if (this.message == true) {
    console.log("condition" + this.message);
    this.router.navigate(['/admindashboard']);
    sessionStorage.setItem('loginStatus','true');
    sessionStorage.setItem('logininfo',JSON.stringify(this.admin));
    this.us=sessionStorage.getItem('logininfo');
  }
  else {

  };
}


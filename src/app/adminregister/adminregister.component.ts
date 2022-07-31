import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AdminData } from '../class/admin-data';
import { Adminregister } from '../class/adminregister';
import { AdminregisterService } from '../service/adminregister.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-adminregister',
  templateUrl: './adminregister.component.html',
  styleUrls: ['./adminregister.component.css']
})
export class AdminregisterComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;
  message: boolean;
  ermessage: String;
  constructor(private formBuilder: FormBuilder, private service: AdminregisterService,private router:Router) { }
  admin: AdminData = new AdminData();
  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      name: ['', [Validators.required, Validators.minLength(6)]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      contact: ['', [Validators.required, Validators.pattern('^\\d{10}$')]]
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
      this.service.doRegister(this.admin).subscribe(
        (data) => {
          this.message = data['status'];
          this.ermessage=data['errorMessage']
          this.dashboardredirect(this.message,this.ermessage);
        }
      );

    }
  }
  dashboardredirect(_message: boolean,_ermessage:String) {
    if (this.message) {
      console.log("condition" + this.message);
      this.router.navigate(['/adminlogin']);
      alert("Admin Registered Successfully");
    }
    else {
      alert("Admin Registeration Failed" + this.ermessage);
    };
  }
  

}

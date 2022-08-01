import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router, UrlCreationOptions } from '@angular/router';
import { Adminupdatepassword } from '../class/adminupdatepassword';
import { AdminupdatepasswordService } from '../service/adminupdatepassword.service';

@Component({
  selector: 'app-adminupdatepassword',
  templateUrl: './adminupdatepassword.component.html',
  styleUrls: ['./adminupdatepassword.component.css']
})
export class AdminupdatepasswordComponent implements OnInit {

  
  registerForm: FormGroup;
  admin:Adminupdatepassword=new Adminupdatepassword();
  
  submitted = false;
  message: boolean;
  ermessage: String;
  id: any;
  constructor(private formBuilder: FormBuilder, private service: AdminupdatepasswordService,private router:Router,private route:ActivatedRoute) { 
    this.id=this.route.snapshot.paramMap.get('id');
  }
  get f() { return this.registerForm.controls; }
  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }
  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if(this.submitted)
    {
      this.service.doUpdatePassword(this.registerForm.value,this.id).subscribe(
        (data) => {
         
          this.message = data['status'];
          this.ermessage=data['errorMessage'];
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
      alert("Password Updated");
      this.router.navigate(['/adminlogin']);
    }
    else {
      alert("Password not Updated " + this.ermessage);
    };
  }

}

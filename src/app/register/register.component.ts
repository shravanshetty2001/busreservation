import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { UserdetailDto } from '../classcomponents/UserdetailDto';
import { UserdetailRegisterDto } from '../classcomponents/UserdetailRegisterDto';
import { UserdetailStatusDto } from '../classcomponents/UserdetailStatusDto';
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
  userdetailRegisterDto:UserdetailRegisterDto=new UserdetailRegisterDto();
  userdetails:UserdetailDto[];
  userdetailStatusDto:UserdetailStatusDto;
  errorMessage:string;
  showAlert:boolean=false;


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
      console.log(this.userdetailRegisterDto.email);
      console.log(this.userdetailRegisterDto.password);
      this.registerData();
      
    }
  }

  closeRegisterDialog(){
    this.controlRegisterDialog.close();
  }

  public registerData(){
    this.userService.doRegistration(this.userdetailRegisterDto).subscribe(data=>{
      this.userdetailStatusDto=data
      this.doRegisterTask(this.userdetailStatusDto);
      console.log(data);
    });
    
  }

  public doRegisterTask(userdetailStatusDto:UserdetailStatusDto){
    if(this.userdetailStatusDto.status==true){
      sessionStorage.setItem('loginStatus','true');
      sessionStorage.setItem('logininfo',JSON.stringify(userdetailStatusDto.userdetailDto));
      window.location.reload();
    }
    else{
      this.errorMessage=userdetailStatusDto.errorMessge;
      this.showAlert=true;
    }
  }

  public getData(){
    this.userService.getUserList().subscribe(data=>{
     console.log(data);
    });
    
  }

}

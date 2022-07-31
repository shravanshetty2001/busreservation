import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { LoginComponent } from './login/login.component';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'busreservation';
  myImage: String = "assets/img/bookbus.png";
  btnStyle: string;
  loginStatus:String;

  constructor(private controlDialog:MatDialog) { 

  }
  ngOnInit() {
    if(sessionStorage.getItem("loginStatus")=='true'){
      this.loginStatus="Log Out"
    }
    else{
      this.loginStatus="Log in"
    }
  }

  openDialog(){
    this.controlDialog.open(LoginComponent,{ 
    disableClose: true ,
    width: '40%',
    height: '65%'
    });
  }

}

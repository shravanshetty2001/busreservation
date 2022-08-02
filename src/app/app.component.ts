import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { WalletComponent } from './wallet/wallet.component';


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

  constructor(private controlDialog:MatDialog,private router:Router) { 

  }
  ngOnInit() {
    if(sessionStorage.getItem("loginStatus")=='true' || sessionStorage.getItem("adminloginStatus")=='true'){
      this.loginStatus="Log Out"
    }
    else{
      this.loginStatus="Log in"
    }
  }

  loginButtonAction(){

    if(sessionStorage.getItem("loginStatus")=='true' || sessionStorage.getItem("adminloginStatus")=='true'){

      sessionStorage.clear();
      this.router.navigate(['/']);
  
    }
    else{
      this.controlDialog.open(LoginComponent,{ 
        disableClose: true ,
        width: '40%',
        height: '65%'
      });
    }
  }

  walletButtonAction(){
    this.controlDialog.open(WalletComponent,{ 
      disableClose: true ,
      width: '40%',
      height: '65%'
    });
  }

}

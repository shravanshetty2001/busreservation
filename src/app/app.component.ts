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

  constructor(private controlDialog:MatDialog) { }
  ngOnInit() {

  }

  openDialog(){
    this.controlDialog.open(LoginComponent,{ disableClose: true });
  }

}

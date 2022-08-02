import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { SeatReservationComponent } from '../seat-reservation/seat-reservation.component';

@Component({
  selector: 'app-unauthorized-user-data-form',
  templateUrl: './unauthorized-user-data-form.component.html',
  styleUrls: ['./unauthorized-user-data-form.component.css']
})
export class UnauthorizedUserDataFormComponent implements OnInit {

  submitted = false;
  errorMessage:string;
  registerForm: FormGroup;

  constructor( 
    private controlDialog:MatDialog,
    private formBuilder: FormBuilder,
    private controlLoginDialog:MatDialogRef<UnauthorizedUserDataFormComponent>,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  get f() { return this.registerForm.controls; }

  onSubmit( username: any, unemail: any, phoneno: any) {
    this.submitted = true;
    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return ;
    }
    if (this.submitted) {
      sessionStorage.setItem('unemail',unemail);
      sessionStorage.setItem('phoneno', phoneno);
      sessionStorage.setItem('username', username);
      this.controlLoginDialog.close();
      this.controlDialog.open(SeatReservationComponent,{
        disableClose: true ,
        width: '60%',
        height: '56%'
      });
      // this.router.navigate(['/seatbook']);
    }
  }

  closeLogin(){
    this.controlLoginDialog.close();
  }
  

}

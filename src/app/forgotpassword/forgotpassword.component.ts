import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';


@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent implements OnInit {

  forgotForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder,private controlDialog:MatDialogRef<ForgotpasswordComponent>) { }

  ngOnInit(): void {
    this.forgotForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]]
    });
  }

  get f() { return this.forgotForm.controls; }
  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.forgotForm.invalid) {
      return;
    }
    if (this.submitted) {
      this.closeForgotPassword();
    }
  }

  closeForgotPassword(){
    this.controlDialog.close();
  }

}

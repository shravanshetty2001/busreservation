import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { PaymentDto } from '../classcomponents/PaymentDto';
import { UserdetailDto } from '../classcomponents/UserdetailDto';
import { PaymentService } from '../services/payment.service';



@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit {


  isLogin:boolean;
  paymentDto:PaymentDto=new PaymentDto();
  amt:number;

  constructor(private controlWalletDialog:MatDialogRef<WalletComponent>,
              private paymentService:PaymentService
    ) { }
  balance:number;

  ngOnInit(): void {
    if(sessionStorage.getItem("loginStatus")=='true'){
      this.isLogin=true;
      this.updateUserBalance();
    }
    else{
      this.isLogin=false;
    }
  }

  

  closeWallet(){
    this.controlWalletDialog.close();
  }

  updateUserBalance(){
    this.paymentService.getBalance().subscribe(
      (data)=>{this.balance=data; console.log(data)}
    );
  }

  addMoney(amount:string){
    this.amt=Number(amount);
    let us:UserdetailDto=JSON.parse(sessionStorage.getItem('logininfo'));
    //let paymentDto:PaymentDto = new PaymentDto(amt,us.id,true);
    console.log(this.amt);
    this.paymentDto.amount=this.amt;
    this.paymentDto.type=true;
    this.paymentDto.userId=us.id;
    console.log(this.paymentDto.amount);
    this.paymentService.addMoney(this.paymentDto).subscribe(
      (data)=>{
        console.log(data);
        this.controlWalletDialog.close();
      }
    );
  }


}

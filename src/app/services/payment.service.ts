import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PaymentDto } from '../classcomponents/PaymentDto';
import { PaymentStatusDto } from '../classcomponents/PaymentStatusDto';
import { UserdetailDto } from '../classcomponents/UserdetailDto';

@Injectable()
export class PaymentService {

  constructor(private httpClient:HttpClient) { }

  private baseURL = "http://localhost:8089";

  public getBalance():Observable<number>{
    let userdetailDto:UserdetailDto=JSON.parse(sessionStorage.getItem('logininfo'));
    return this.httpClient.get<number>(this.baseURL+"/balance/"+userdetailDto.id);
  }

  public addMoney(paymentDto:PaymentDto):Observable<PaymentStatusDto>{
    return this.httpClient.post<PaymentStatusDto>(this.baseURL+"/makePayment",paymentDto);
  }

}

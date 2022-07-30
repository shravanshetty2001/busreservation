import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserdetailDto } from '../classcomponents/UserdetailDto';
import { Userdetail } from '../classcomponents/Userdetail';
import { LoginDto } from '../classcomponents/LoginDto';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient:HttpClient) { }

  private baseURL = "http://localhost:8080";
  public doRegistration(userdetailDto:UserdetailDto): Observable<Object>{

    return this.httpClient.post(this.baseURL+"/userdetail",userdetailDto);

  }

  public getUserList(): Observable<Userdetail[]>{
    return this.httpClient.get<Userdetail[]>('http://localhost:8080/userdetail');
  }

  public doLogin(loginDto:LoginDto): Observable<Userdetail>{
    return this.httpClient.post<Userdetail>(this.baseURL+'/userlogin',loginDto);
  }



}

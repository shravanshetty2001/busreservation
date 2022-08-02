import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserdetailRegisterDto } from '../classcomponents/UserdetailRegisterDto';
import { UserdetailDto } from '../classcomponents/UserdetailDto';
import { LoginDto } from '../classcomponents/LoginDto';
import {UserdetailStatusDto} from '../classcomponents/UserdetailStatusDto';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient:HttpClient) { }

  private baseURL = "http://localhost:8089";
  public doRegistration(userdetailRegisterDto:UserdetailRegisterDto): Observable<UserdetailStatusDto>{

    return this.httpClient.post<UserdetailStatusDto>(this.baseURL+"/userdetail",userdetailRegisterDto);

  }

  public getUserList(): Observable<UserdetailDto[]>{
    return this.httpClient.get<UserdetailDto[]>('http://localhost:8089/userdetail');
  }

  public doLogin(loginDto:LoginDto): Observable<UserdetailStatusDto>{
    return this.httpClient.post<UserdetailStatusDto>(this.baseURL+'/userlogin',loginDto);
  }



}

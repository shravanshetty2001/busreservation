import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminStatusdto } from '../class/admin-statusdto';

@Injectable({
  providedIn: 'root'
})
export class AdminforgotpasswordService {
  private baseUrl='http://localhost:8089/admin/forgotpassword';
  constructor(private http:HttpClient) { }
  public doForgotPassword(email:string):Observable<AdminStatusdto>
  {
    return this.http.post<AdminStatusdto>(this.baseUrl,email);
  }
}

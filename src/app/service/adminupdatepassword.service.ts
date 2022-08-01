import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminStatusdto } from '../class/admin-statusdto';

@Injectable({
  providedIn: 'root'
})
export class AdminupdatepasswordService {
  private baseUrl='http://localhost:8089/resetpassword/';
  constructor(private http:HttpClient) { }
  public doUpdatePassword(password:string,id:any):Observable<AdminStatusdto>
  {
    return this.http.post<AdminStatusdto>(this.baseUrl+id,password);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Admin } from '../class/admin';
import { Observable } from 'rxjs';
import { AdminStatusdto } from '../class/admin-statusdto';
@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private baseUrl='http://localhost:8089/admin/verify';

  constructor(private http:HttpClient) { 
  }
  public doLogin(admin:Admin):Observable<AdminStatusdto>
  {
    console.log(admin);
    return this.http.post<AdminStatusdto>(this.baseUrl,admin);
  }

}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Admin } from './admin';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private baseUrl='http://localhost:8089/admin/verify';

  constructor(private http:HttpClient) { 
  }
  public doLogin(admin:Admin):Observable<Boolean>
  {
    return this.http.post<Boolean>(this.baseUrl,admin);
  }

}

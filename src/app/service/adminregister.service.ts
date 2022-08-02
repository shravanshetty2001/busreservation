import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminData } from '../class/admin-data';
import { AdminStatusdto } from '../class/admin-statusdto';
import { Adminregister } from '../class/adminregister';

@Injectable({
  providedIn: 'root'
})
export class AdminregisterService {

  private baseUrl='http://localhost:8089/admin/register';

  constructor(private http:HttpClient) { 
  }
  public doRegister(admindata:AdminData):Observable<AdminStatusdto>
  {
    return this.http.post<AdminStatusdto>(this.baseUrl,admindata);
  }
}

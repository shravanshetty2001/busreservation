import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AddbustimetableComponent } from '../addbustimetable/addbustimetable.component';
import { AddBustimetableDto } from '../class/add-bustimetable-dto';
import { BuslistDto } from '../class/buslist-dto';

@Injectable({
  providedIn: 'root'
})
export class ViewbusService {


  constructor(private http:HttpClient) { }
  private baseUrl='http://localhost:8089/viewbus';
  private baseUrl2='http://localhost:8089/viewbustimetable/';

  public addBus(bustt:number):Observable<BuslistDto[]>
  {

    return this.http.post<BuslistDto[]>(this.baseUrl,bustt);
  }
  public addBusTt(bustt:number):Observable<AddBustimetableDto[]>
  {

    return this.http.post<AddBustimetableDto[]>(this.baseUrl2,bustt);
  }
}

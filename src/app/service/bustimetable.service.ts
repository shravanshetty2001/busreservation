import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AddBustimetableDto } from '../class/add-bustimetable-dto';

@Injectable({
  providedIn: 'root'
})
export class BustimetableService {

  constructor(private http:HttpClient) { }
  private baseUrl='http://localhost:8089/bustimetable';

  public addBus(bustt:AddBustimetableDto):Observable<AddBustimetableDto>
  {
    console.log(bustt);
    return this.http.post<AddBustimetableDto>(this.baseUrl,bustt);
  }



}

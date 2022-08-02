import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AddBustimetableDto } from '../class/add-bustimetable-dto';

@Injectable({
  providedIn: 'root'
})
export class CheckAvailabilityService {

  private getBustimetableUrl: String = "http://localhost:8089/getbustimetable";

  constructor(private http: HttpClient) { }

  public getBusForUser( bstbdto: AddBustimetableDto ) : Observable <AddBustimetableDto[]> {
    console.log("srcplace ",bstbdto.sourcePlace);
    console.log("dsnplce: ",bstbdto.desnPlace);
    console.log("stime: ",bstbdto.sDatetime);
   
    return this.http.post<AddBustimetableDto[]>(`${this.getBustimetableUrl}`, bstbdto);
  }

}

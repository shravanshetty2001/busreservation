import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Seat } from '../class/seat';


@Injectable({
  providedIn: 'root'
})
export class BookseatService {

  private baseUrl: String = "http://localhost:8089/bookings/unauthorizedUser/makebooking";
  constructor( private http: HttpClient ) 
  {

  }

  public bookSeat( seat:Seat ) : Observable <Seat> {
    console.log("email: ",seat.email);
    console.log("seatno: ",seat.seatno);
    console.log("phoneno: ", seat.phoneno);
    return this.http.post<Seat>(`${this.baseUrl}`, seat);
  }

}

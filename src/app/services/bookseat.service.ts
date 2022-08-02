import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Seat } from '../class/seat';
import { TicketDto } from '../class/ticket-dto';


@Injectable({
  providedIn: 'root'
})
export class BookseatService {

  private unAuthMakeBookingUrl: String = "http://localhost:8089/bookings/unauthorizedUser/makebooking";
  private authMakeBookingUrl: String = "http://localhost:8089/bookings/authorizedUser/makebooking";
  constructor( private http: HttpClient ) 
  {

  }

  public bookSeat( seat:Seat ) : Observable <TicketDto> {
    console.log("email: ",seat.email);
    console.log("seatno: ",seat.seatno);
    console.log("phoneno: ", seat.phoneno);
    console.log("Name: ", seat.username);
    return this.http.post<TicketDto>(`${this.unAuthMakeBookingUrl}`, seat);
  }

  public authusrbookSeat( seat:Seat ):Observable<TicketDto>{
    return this.http.post<TicketDto>(`${this.authMakeBookingUrl}`, seat);
  }

}

import { Injectable } from '@angular/core';
import { TicketDto } from '../class/ticket-dto';

@Injectable({
  providedIn: 'root'
})
export class ResultService {

  result: any;
  busno : any;
  price: Number;
  ticket: any;

  constructor() { }

}

import { Component, OnInit } from '@angular/core';
import { TicketDto } from '../class/ticket-dto';
import { ResultService } from '../services/result.service';

@Component({
  selector: 'app-ticket-form',
  templateUrl: './ticket-form.component.html',
  styleUrls: ['./ticket-form.component.css']
})
export class TicketFormComponent implements OnInit {

  ticket: any;

  constructor(
    private resultservice: ResultService
  ) { }

  ngOnInit(): void {
    
    this.ticket = this.resultservice.ticket;
    console.log("ticket-form----", JSON.stringify(this.ticket));
  }

  // getTicket(){
  //   this.ticket = this.resultservice.ticket;
  //   console.log("ticket-form----", JSON.stringify(this.ticket));
  //   console.log("ticket-form----", JSON.stringify(this.resultservice.ticket));
  // }

}

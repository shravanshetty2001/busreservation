import { Component, OnInit, Input, Output, EventEmitter, OnDestroy } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';

import { Subscription } from 'rxjs';
import { Seat } from '../class/seat';
import { TicketDto } from '../class/ticket-dto';
import { UserdetailDto } from '../classcomponents/UserdetailDto';
import { BookseatService } from '../services/bookseat.service';
import { ResultService } from '../services/result.service';
import { TicketFormComponent } from '../ticket-form/ticket-form.component';

@Component({
  selector: 'app-seat-reservation',
  templateUrl: './seat-reservation.component.html',
  styleUrls: ['./seat-reservation.component.css']
})

export class SeatReservationComponent {

  // @Input('bus') bus:Bus;
  // @Output('closeModal') closeModal = new EventEmitter()
  showSeatList: Seat[] = [];
  ticket: TicketDto;
  total = 0;
  fillupSeat = [];
  alert = false;
  noSeatSelected = false;
  

  subscription: Subscription;


  seat: Seat;
  ticketobj: TicketDto;

  constructor(
    private route: Router,
    private BookSeatService: BookseatService,
    private resultservice: ResultService,
    private controlDialog:MatDialog,
  ) { }

  

  ngOnInit() {
    // this.getbookSeat();
  }

  Seat(e) {

    let seats = [];
    seats = this.showSeatList.map(item => {
      return item.seatno;
    })

    let id = document.getElementById(e);

    let btid:any = this.resultservice.busno;
    let pr:any = this.resultservice.price;

    if ((this.fillupSeat.indexOf(String(e)) < 0) && (seats.indexOf(e) < 0)) {
      if ((this.showSeatList.length != 1)) {
        id.innerHTML = `<img src="../assets/img/fseat.png" alt="">`


        if(sessionStorage.getItem("loginStatus")=='true'){

          let us:UserdetailDto=JSON.parse(sessionStorage.getItem('logininfo'));
  
          let seat: Seat = {
            seatno: e,
            email: us.email,
            phoneno: us.contactNo,
            bustimetable: btid,
            username: us.name,
            userId: us.id
          }
        
          this.showList(seat);
        }
        
        else{
        
          let seat: Seat = {
            seatno: e,
            email: sessionStorage.getItem('unemail'),
            phoneno: sessionStorage.getItem('phoneno'),
            bustimetable: btid,
            username: sessionStorage.getItem('username'),
            userId: null
          }
          this.showList(seat);
        
        }
        this.totalFare(pr);
      }
      else {
        this.alert = true;
      }
    }

  }

  showList(seat) {
    this.showSeatList.push(seat)
  }

  totalFare(fare) {
    this.total += fare;
  }

  confirmJourney() {

    // let seat: Seat = {} as Seat;
    if ((this.showSeatList.length == 0)) {
      this.noSeatSelected = true;
    }
    else {

      if(sessionStorage.getItem("loginStatus")=='true'){

        let us:UserdetailDto=JSON.parse(sessionStorage.getItem('logininfo'));

        this.showSeatList.map(seat => {
          console.log(seat.email);
          console.log(seat.seatno);
          this.BookSeatService.authusrbookSeat(seat).subscribe(
            (item)=>{
              console.log("item",item);
              let ticketobj: TicketDto = {
                seatno: item.seatno,
                route: item.route,
                sourceplace: item.sourceplace,
                destplace: item.destplace,
                date: item.date,
                time: item.time,
                name: item.name,
                phoneno: item.phoneno,
                bookedOn: item.bookedOn,
                price: item.price
              }
              this.resultservice.ticket = ticketobj;
              console.log("ticket",this.resultservice.ticket);
              // console.log("ticketobj: ",ticketobj);
              // this.ticket = Object.assign({},ticketobj);
              this.controlDialog.open(TicketFormComponent,{
                disableClose: true ,
                width: '90%',
                height: '80%'
              });
            }
            
          );
        });

        
        
        // console.log("service ticket",this.resultservice.ticket);
       
      }
      
      else{
        this.showSeatList.map(seat => {
          console.log(seat.email);
          console.log(seat.seatno);
          this.BookSeatService.bookSeat(seat).subscribe(
            (item)=>{
              let ticketobj: TicketDto = {
                seatno: item.seatno,
                route: item.route,
                sourceplace: item.sourceplace,
                destplace: item.destplace,
                date: item.date,
                time: item.time,
                name: item.name,
                phoneno: item.phoneno,
                bookedOn: item.bookedOn,
                price: item.price
              }
              // this.ticket = ticketobj;
            }
          );
        });
        this.resultservice.ticket = this.ticket;
        console.log(this.ticket);
      }

     
    }

    ;
    //  let route:Journey_Route= JSON.parse(localStorage.getItem("route"))



    //   let journey :Journey={
    //     bus:this.bus,
    //     seats:seats,
    //     fare:Number(this.total),
    //     journey_route:route
    //   }

    // localStorage.setItem("journey",JSON.stringify(journey))
    // this.route.navigate(['user-form']);
    // this.closeModal.emit();


  }


  // getbookSeat(){

  //   let route:Journey_Route= JSON.parse(localStorage.getItem("route"))
  //   let busid=this.bus.$key;
  //   let key = String(new Date(route.date).getTime());
  //   console.log(busid,key)
  // this.subscription=this.BusService.getFillupseat(key,busid)
  // .subscribe(res=>{
  //   for(key in res){
  //     for(let i in res[key].seats){
  //       this.fillupSeat.push(res[key].seats[i])
  //       this.changeSeatColor(res[key].seats[i])
  //     }
  //   }
  // })
  // }

  changeSeatColor(seatNo) {
    let id = document.getElementById(seatNo)
    id.innerHTML = `  <img src="../assets/img/bookseat.png">`
    id.removeEventListener("click", this.Seat);


  }

  // ngOnDestroy(){
  //   this.subscription.unsubscribe();
  // }


}

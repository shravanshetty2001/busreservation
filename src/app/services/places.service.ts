import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Place } from '../class/place';

@Injectable({
  providedIn: 'root'
})
export class PlacesService {


  private addPlaceUrl: String = "http://localhost:8089/addplace";
  private getPlaceUrl: String = "http://localhost:8089/getplaces";



  constructor( private http: HttpClient ) 
  {

  }

  public addPlace( place:Place ) : Observable <Place> {
    console.log("email: ",place.pid);
    console.log("seatno: ",place.placeName);
   
    return this.http.post<Place>(`${this.addPlaceUrl}`, place);
  }

  public getPlaces() : Observable <Place[]> {
    return this.http.get<Place[]>(`${this.getPlaceUrl}`);
  } 

}

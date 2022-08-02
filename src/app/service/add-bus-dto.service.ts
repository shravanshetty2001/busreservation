import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BuslistDto } from '../class/buslist-dto';

@Injectable({
  providedIn: 'root'
})
export class AddBusDtoService {
  private baseUrl='http://localhost:8089/Buslist';
  constructor(private http:HttpClient) { }
  public addBus(bus:BuslistDto):Observable<BuslistDto>
  {
    console.log(bus);
    return this.http.post<BuslistDto>(this.baseUrl,bus);
  }
}

import { Payment } from "./Payment";

export class Userdetail{

    constructor(
        id:number,
        name:string,
        email:string,
        password:string,
        contactNo:string,
        balance:number,
        payment:Payment[]){}
    id:number
    name:string
    email:string
    password:string
    contactNo:string
    balance:number
    payment:Payment[]



}
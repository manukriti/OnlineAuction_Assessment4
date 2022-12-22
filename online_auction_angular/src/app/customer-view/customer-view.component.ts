import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer-service';

@Component({
  selector: 'app-customer-view',
  templateUrl: './customer-view.component.html',
  styleUrls: ['./customer-view.component.css']
})
export class CustomerViewComponent implements OnInit{
  customerID!: number;
  customer!: Customer;
  constructor(private route: ActivatedRoute,private customerService: CustomerService){

  }
  ngOnInit(): void{
this.customerID = this.route.snapshot.params['customerID'];
this.customer = new Customer();
this.customerService.getCustomerById(this.customerID).subscribe(data=>{
  this.customer=data;
})
  }
}

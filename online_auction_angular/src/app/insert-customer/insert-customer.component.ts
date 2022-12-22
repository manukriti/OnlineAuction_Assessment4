import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer-service';

@Component({
  selector: 'app-insert-customer',
  templateUrl: './insert-customer.component.html',
  styleUrls: ['./insert-customer.component.css']
})
export class InsertCustomerComponent implements OnInit{
  customer: Customer = new Customer();
  constructor(private customerService: CustomerService, private router: Router){

  }
  ngOnInit(): void {
  
  }
  insertTheCustomer(){
    this.customerService.insertCustomer(this.customer).subscribe(data =>{
    console.log(data);
    this.goToCustomerList()
    },
    error => console.log(error)
    )
  }
  goToCustomerList(){
    this.router.navigate(['/customer'])
    }
    onSubmit(){
      console.log(this.customer);
  this.insertTheCustomer();
}
    
}

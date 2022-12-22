import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer-service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit{
  customerID!: number;
  customer: Customer = new Customer();
  constructor(private customerService: CustomerService, private router: ActivatedRoute, private routes: Router){

  }

  ngOnInit(): void{
    this.customerID = this.router.snapshot.params['customerID'];
    this.customerService.getCustomerById(this.customerID).subscribe(data => {
      this.customer = data
    },error => console.log(error)
    );
  }
  goToCustomerList(){
    this.routes.navigate(['/customer'])
    }


  onSubmit(){
    console.log(this.customer);
    this.customerService.updateCustomer(this.customerID,this.customer).subscribe(data =>{
      this.goToCustomerList();
    },error => console.log(error));
  }
}

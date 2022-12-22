import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Seller } from '../seller';
import { SellerService } from '../seller.service';

@Component({
  selector: 'app-insert-seller',
  templateUrl: './insert-seller.component.html',
  styleUrls: ['./insert-seller.component.css']
})
export class InsertSellerComponent implements OnInit{
  seller: Seller = new Seller();
  constructor(private sellerService: SellerService, private router: Router){

  }
ngOnInit(): void {
  
}
insertTheSeller(){
  this.sellerService.insertSeller(this.seller).subscribe(data =>{
  console.log(data);
  this.goToSellerList()
  },
  error => console.log(error)
  )
}
goToSellerList(){
this.router.navigate(['/seller'])
}
onSubmit(){
  console.log(this.seller);
  this.insertTheSeller();
}
}

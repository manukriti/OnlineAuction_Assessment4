import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Seller } from '../seller';
import { SellerService } from '../seller.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent {
  sellers!: Seller[];
  sellerID!: number;
  seller: Seller = new Seller();
  constructor(private sellerService: SellerService,private router: ActivatedRoute, private routes: Router){

  }
  ngOnInit(): void {
    this.getSeller();
   
  }
  private getSeller(){
    this.sellerService.getSellerList().subscribe(data => {
      this.sellers=data;
    })
  }
  
 productDeletion(sellerID:number){
  this.sellerService.deleteProduct(sellerID,this.seller).subscribe(data=>{
    console.log(data);
    this.getSeller()
  })
 }
 viewProduct(sellerID:number){
  this.routes.navigate(['view-product',sellerID]);
}
 }

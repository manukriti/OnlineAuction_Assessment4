import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Seller} from '../seller'
import { SellerService } from '../seller.service';

@Component({
  selector: 'app-sellerlist',
  templateUrl: './sellerlist.component.html',
  styleUrls: ['./sellerlist.component.css']
})
export class SellerlistComponent implements OnInit{
  sellers!: Seller[];
  constructor(private sellerService: SellerService, private router:Router){

  }
  ngOnInit(): void {
    this.getSellers();
  }
  private getSellers(){
    this.sellerService.getSellerList().subscribe(data => {
      this.sellers=data;
    })
  }

  updateProduct(sellerId:number){
    this.router.navigate(['update-product',sellerId]);
  }

  deleteTheSeller(sellerID:number){
    this.sellerService.deleteSeller(sellerID).subscribe(data=>{
      console.log(data);
      this.getSellers()
    })
   }

viewTheSeller(sellerID:number){
  this.router.navigate(['seller-details',sellerID]);
}
}

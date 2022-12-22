import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Seller } from '../seller';
import { SellerService } from '../seller.service';


@Component({
  selector: 'app-bidding',
  templateUrl: './bidding.component.html',
  styleUrls: ['./bidding.component.css']
})
export class BiddingComponent implements OnInit{
  sellerID!: number;
  seller!: Seller;
  constructor(private route: ActivatedRoute,private sellerService: SellerService){

  }
  ngOnInit(): void{
this.sellerID = this.route.snapshot.params['sellerID'];
this.seller = new Seller();
this.sellerService.getSellerById(this.sellerID).subscribe(data=>{
  this.seller=data;
})
  }

  productBid(){
  console.log(this.seller);
    this.sellerService.updateBidder(this.sellerID,this.seller).subscribe(data =>{
     
     
    },error => console.log(error));
  
  }
}

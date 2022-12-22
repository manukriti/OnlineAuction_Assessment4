import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Seller } from '../seller';
import { SellerService } from '../seller.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit{

  sellerID!: number;
  seller: Seller = new Seller();
  constructor(private sellerService: SellerService, private router: ActivatedRoute, private routes: Router){

  }

  ngOnInit(): void{
    this.sellerID = this.router.snapshot.params['sellerID'];
    this.sellerService.getSellerById(this.sellerID).subscribe(data => {
      this.seller = data
    },error => console.log(error)
    );
  }
  goToProductList(){
    this.routes.navigate(['/customer'])
    }


  onSubmit(){
    console.log(this.seller);
    this.sellerService.updateProduct(this.sellerID,this.seller).subscribe(data =>{
      this.goToProductList();
    },error => console.log(error));
  }
}

import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SellerlistComponent } from './sellerlist/sellerlist.component';
import { InsertSellerComponent } from './insert-seller/insert-seller.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { SellerDetailsComponent } from './seller-details/seller-details.component';
import { ViewProductComponent } from './view-product/view-product.component';
import { InsertCustomerComponent } from './insert-customer/insert-customer.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerViewComponent } from './customer-view/customer-view.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { ProductBidComponent } from './product-bid/product-bid.component';
import { BiddingComponent } from './bidding/bidding.component';


@NgModule({
  declarations: [
    AppComponent,
    SellerlistComponent,
    InsertSellerComponent,
    UpdateProductComponent,
    ProductDetailsComponent,
    SellerDetailsComponent,
    ViewProductComponent,
    InsertCustomerComponent,
    CustomerListComponent,
    CustomerViewComponent,
    UpdateCustomerComponent,
    ProductBidComponent,
    BiddingComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

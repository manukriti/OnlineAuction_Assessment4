package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.SellerCustomException;
import com.example.demo.model.Seller;
import com.example.demo.repository.SellerRepository;

@RestController
@RequestMapping("/rest/onlineauction")
@CrossOrigin(origins = "http://localhost:4200/")
public class SellerController {

	@Autowired
	private SellerRepository sellerRepo;
	
	//get all sellers
	@GetMapping("/seller")
	public List<Seller> getAllSeller(){
		return sellerRepo.findAll();
	}
	
	//insert a seller
	@PostMapping("/seller")
	public Seller createSeller(@RequestBody Seller seller) {
		return sellerRepo.save(seller);
	}
	
	//get seller by id 
	@GetMapping("/seller/{sellerID}")
	public ResponseEntity<Seller> getSellerById(@PathVariable Integer sellerID) {
		Seller seller = sellerRepo.findById(sellerID).orElseThrow(()-> new SellerCustomException("Seller not exist with id:"+sellerID));
		return ResponseEntity.ok(seller);
	}
	
	//update product
	@PutMapping("/seller/{sellerID}")
	public ResponseEntity<Seller> updateProduct(@PathVariable Integer sellerID, @RequestBody Seller sellerDetails){
		Seller seller = sellerRepo.findById(sellerID).orElseThrow(()-> new SellerCustomException("Seller not exist with id:"+sellerID));
		seller.setProductID(sellerDetails.getProductID());
		seller.setProductName(sellerDetails.getProductName());
		seller.setProductDescription(sellerDetails.getProductDescription());
		seller.setProductStartamt(sellerDetails.getProductStartamt());
		seller.setProductPrice(sellerDetails.getProductPrice());
		seller.setProductBiddingdate(sellerDetails.getProductBiddingdate());
		seller.setProductCategory(sellerDetails.getProductCategory());
		Seller updatedProduct = sellerRepo.save(seller);
		return ResponseEntity.ok(updatedProduct);
	}
	
	//get product by id 
		@GetMapping("/seller/product/{sellerID}")
		public ResponseEntity<Seller> getProductById(@PathVariable Integer sellerID) {
			Seller seller = sellerRepo.findById(sellerID).orElseThrow(()-> new SellerCustomException("Product not exist with id:"+sellerID));
			return ResponseEntity.ok(seller);
		}
		
	//delete product
	@PutMapping("/seller/product/{sellerID}")
	public ResponseEntity<Seller> deleteProduct(@PathVariable Integer sellerID, @RequestBody Seller sellerDetails){
		Seller seller = sellerRepo.findById(sellerID).orElseThrow(()-> new SellerCustomException("Product not exist with id:"+sellerID));
		seller.setProductID(null);
		seller.setProductName(null);
		seller.setProductDescription(null);
		seller.setProductStartamt(null);
		seller.setProductPrice(null);
		seller.setProductBiddingdate(null);
		seller.setProductCategory(null);
		Seller updatedProduct = sellerRepo.save(seller);
		return ResponseEntity.ok(updatedProduct);
	}
	
	//delete seller
	@DeleteMapping("/seller/{sellerID}")
	public ResponseEntity<Map<String,Boolean>> deleteSeller(@PathVariable Integer sellerID){
		Seller seller = sellerRepo.findById(sellerID).orElseThrow(()-> new SellerCustomException("Seller not exist with id:"+sellerID));
		sellerRepo.delete(seller);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	//bid product
		@PutMapping("/seller/product/bid/{sellerID}")
		public ResponseEntity<Seller> updateProductBid(@PathVariable Integer sellerID, @RequestBody Seller bidDetails){
			Seller bidder = sellerRepo.findById(sellerID).orElseThrow(()-> new SellerCustomException("Seller not exist with id:"+sellerID));
			bidder.setBiddedBy("bidded");
			Seller updatedProductBid = sellerRepo.save(bidder);
			return ResponseEntity.ok(updatedProductBid);
		}
}

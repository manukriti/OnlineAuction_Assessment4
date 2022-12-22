import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertSellerComponent } from './insert-seller.component';

describe('InsertSellerComponent', () => {
  let component: InsertSellerComponent;
  let fixture: ComponentFixture<InsertSellerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsertSellerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsertSellerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

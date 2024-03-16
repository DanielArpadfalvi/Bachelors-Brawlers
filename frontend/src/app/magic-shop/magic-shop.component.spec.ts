import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MagicShopComponent } from './magic-shop.component';

describe('MagicShopComponent', () => {
  let component: MagicShopComponent;
  let fixture: ComponentFixture<MagicShopComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MagicShopComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MagicShopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

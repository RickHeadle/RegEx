import {ComponentFixture, TestBed} from '@angular/core/testing';

import {UpdateRegexComponent} from './update-regex.component';

describe('UpdateRegexComponent', () => {
  let component: UpdateRegexComponent;
  let fixture: ComponentFixture<UpdateRegexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateRegexComponent]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateRegexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

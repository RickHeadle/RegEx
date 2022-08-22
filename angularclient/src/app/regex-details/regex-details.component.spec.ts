import {ComponentFixture, TestBed} from '@angular/core/testing';

import {RegexDetailsComponent} from './regex-details.component';

describe('RegexDetailsComponent', () => {
  let component: RegexDetailsComponent;
  let fixture: ComponentFixture<RegexDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RegexDetailsComponent]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegexDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

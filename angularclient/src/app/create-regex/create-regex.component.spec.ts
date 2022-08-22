import {ComponentFixture, TestBed} from '@angular/core/testing';

import {CreateRegexComponent} from './create-regex.component';

describe('CreateRegexComponent', () => {
  let component: CreateRegexComponent;
  let fixture: ComponentFixture<CreateRegexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateRegexComponent]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateRegexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

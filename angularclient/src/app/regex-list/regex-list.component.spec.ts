import {ComponentFixture, TestBed} from '@angular/core/testing';

import {RegexListComponent} from './regex-list.component';

describe('RegexListComponent', () => {
  let component: RegexListComponent;
  let fixture: ComponentFixture<RegexListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RegexListComponent]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegexListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

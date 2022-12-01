import {TestBed} from '@angular/core/testing';

import {RegExService} from './regex.service';

describe('RegexService', () => {
  let service: RegExService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegExService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

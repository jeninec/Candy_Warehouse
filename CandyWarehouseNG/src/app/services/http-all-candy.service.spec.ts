import { TestBed } from '@angular/core/testing';

import { HttpAllCandyService } from './http-all-candy.service';

describe('HttpAllCandyService', () => {
  let service: HttpAllCandyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpAllCandyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

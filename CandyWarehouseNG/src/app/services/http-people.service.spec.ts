import { TestBed } from '@angular/core/testing';

import { HttpPeopleService } from './http-people.service';

describe('HttpPeopleService', () => {
  let service: HttpPeopleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpPeopleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { LivroRestService } from './livro-rest.service';

describe('LivroRestService', () => {
  let service: LivroRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LivroRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

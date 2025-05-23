import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Livro } from "../model/livro";
import { Observable } from "rxjs";
import { environment } from '../../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class LivroRestService {

  private URL_LIVROS = environment.URL_LIVROS;

  constructor(private http: HttpClient) { }

  cadastrar(desastre: Livro): Observable<Livro> {
    delete desastre.id;
    return this.http.post<Livro>(this.URL_LIVROS, desastre);
  }

  listar(): Observable<Livro[]> {
    return this.http.get<Livro[]>(this.URL_LIVROS);
  }

  remover(id: string): Observable<any> {
    return this.http.delete(`${this.URL_LIVROS}/${id}`);
  }

  pesquisarPorId(idEdicao: string): Observable<Livro> {
    return this.http.get<Livro>(`${this.URL_LIVROS}/${idEdicao}`);
  }

  atualizar(desastre: Livro): Observable<Livro> {
    return this.http.put<Livro>(`${this.URL_LIVROS}/${desastre.id}`, desastre);
  }
}
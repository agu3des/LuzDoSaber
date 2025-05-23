import { Component } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { Livro } from '../../shared/model/livro';
import { LivroRestService } from "../../shared/services/livro-rest.service";
//import { LivroFirestoreService } from "../../shared/services/livro-firestore.service";
import { MensagemSweetService } from "../../shared/services/mensagem-sweet.service";

@Component({
  selector: 'app-manutencao',
  standalone: false,
  templateUrl: './manutencao.component.html',
  styleUrls: ['./manutencao.component.css']
})
export class ManutencaoComponent {

  livro: Livro;
  nomeBotaoAcao: string;
  estahCadastrando: boolean;


  constructor(
    private livroService: LivroRestService, 
    private mensagemService: MensagemSweetService,
    private roteador: Router, 
    private rotaAtivada: ActivatedRoute
  ) {
    this.nomeBotaoAcao = 'Cadastrar';
    this.estahCadastrando = true;
    this.livro = new Livro();

    const idEdicao = this.rotaAtivada.snapshot.paramMap.get('id');
    if (idEdicao) {
      this.nomeBotaoAcao = 'Atualizar';
      this.estahCadastrando = false;
      this.livroService.pesquisarPorId(idEdicao).subscribe(
        livroPesquisado => this.livro = livroPesquisado
      );
    }
  }

  cadastrarOuAtualizar() {
    if (this.estahCadastrando) {
      this.livroService.cadastrar(this.livro).subscribe(
        livroCadastrado => {
          this.mensagemService.sucesso('Livro cadastrado com sucesso!');
          this.roteador.navigate(['/listagem-livros']);
        }
      );
    } else {
      this.livroService.atualizar(this.livro).subscribe(
        livroAtualizado => {
          this.mensagemService.sucesso('Livro atualizado com sucesso!');
          this.roteador.navigate(['/listagem-livros']);
        }
      );
    }
  }

}

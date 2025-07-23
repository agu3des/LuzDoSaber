import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { Livro } from '../../shared/model/livro';
import { LIVROS } from '../../shared/model/LIVROS';
import { LivroRestService } from "../../shared/services/livro-rest.service";
//import { LivroFirestoreService } from "../../shared/services/livro-firestore.service";
import { MatDialog } from '@angular/material/dialog';
import { ConfirmationDialogComponent } from '../../layout/confirmation-dialog/confirmation-dialog.component';



@Component({
  selector: 'app-listagem',
  standalone: false,
  
  templateUrl: './listagem.component.html',
  styleUrl: './listagem.component.css'
})
export class ListagemComponent implements OnInit {
  LIVROS: Livro[] = [];

  constructor(private livroService: LivroRestService, private roteador: Router, private dialog: MatDialog) {
  }

  trackLivroId(index: number, item: any): number {
    return item.id; 
  }

  getDisasterIcon(tipo: string): string {
    switch (tipo.toLowerCase()) {
      case 'enxurrada':
        return 'water'; 
      case 'deslizamento':
        return 'terrain';  
      case 'incendio':
        return 'fireplace';  
      case 'seca':
        return 'invert_colors';  
      case 'inundacao':
        return 'waves';  
      case 'vendaval':
        return 'storm';  
      case 'granizo':
        return 'ac_unit';  
      default:
        return 'warning';  
    }
  }
  
  ngOnInit() {
    this.livroService.listar().subscribe(
        livros => this.LIVROS = livros
    );
  }

  confirmRemove(livro: Livro) {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '300px',
      data: { message: `Are you sure you want to delete ${livro.id}?` }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.remover(livro);
      }
    });
  }


  remover(livroARemover: Livro) {
    if (livroARemover.id) {
      this.livroService.remover(livroARemover.id).subscribe(
          () => {
            console.log('removido');
            const livroIndx = this.LIVROS.findIndex(livro => livro.id === livroARemover.id);
            this.LIVROS.splice(livroIndx, 1);
          }
      );
    }
  }

  alterar(livro: Livro) {
    this.roteador.navigate([`edicao-livro`, livro.id]);
  }

}
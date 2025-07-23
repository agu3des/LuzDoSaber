import { Component } from '@angular/core';

@Component({
  selector: 'app-home-page',
  standalone: false,
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent {

  noticias = [
    {
      data: 'Mar 16, 2020',
      titulo: 'Calendário de eventos literários em 2023 (no Brasil e no exterior)',
      description: 'Segundo a pesquisa Retratos da Leitura no Brasil...',
      link: 'https://www.folhape.com.br/cultura/mulheres-buscam-maior-representatividade-na-literatura/216267/'
    },
    {
      data: '15/04/2025',
      titulo: 'Novo Romance de Autor Premiado',
      link: 'https://example.com/noticia1',
      description: 'Confira os detalhes sobre o lançamento do novo livro de João da Silva.'
    },
    {
      data: '14/04/2025',
      titulo: 'Bienal do Livro 2025 Começa em Maio',
      link: 'https://example.com/noticia2',
      description: 'O maior evento literário do Brasil terá autores nacionais e internacionais.'
    },
  ];

  indicacoes = [
    {
      title: 'Anne de Green Gables',
      img: 'assets/anne-de-green-gables.jpg',
      description: 'Uma jovem menina, ruiva e órfã, foi adotada...',
      link: 'https://www.amazon.com.br/Anne-green-gables-Lucy-Montgomery/dp/8538092669'
    },
    {
      title: '1984 - George Orwell',
      img: 'assets/1984.jpg',
      description: 'Uma distopia sobre vigilância e controle governamental.'
    },
    {
      title: 'O Conto da Aia - Margaret Atwood',
      img: 'assets/contodaaia.jpg',
      description: 'Um romance distópico com críticas sociais e políticas.'
    },
  ];

}

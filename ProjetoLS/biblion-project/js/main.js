import { books } from './books.js';
import { BooksCards } from './components/BooksCards.js';
 
const booksGrid = document.querySelector('.books');
 
booksGrid.innerHTML = books
  .map((books) => BooksCards(books))
  .join('');


  //Aqui é onde os documentos, as funções são chamadas e com a função map, elas são "iteradas". 
  //Esse documento é chamado no arquivo livraria.js.
import { formatCurrency } from '../lib/format.js';

export function BooksCards(books) {
  return `
    <div
      id="book-${books.id}"
      class="bg-white dark:bg-gray-700 shadow-md rounded-lg p-4"
    >
      <div class="flex justify-between menor">
          <p><img class="foto" src="${books.image}" width="100px"></img></p>
          <div class="flex-col">
            <h3 class="p-2 mt-4 text-lg font-semibold text-gray-700 dark:text-white">
              ${books.name}
            </h3>
            <p class="p-2 text-sm text-gray-500 dark:text-white">
              <span class="font-bold">Preço:</span>
              ${formatCurrency(books.value)}
            </p>
            <p class="p-2 text-sm text-gray-500 dark:text-white">
            <span class="font-bold">Autor(a):</span>
            ${books.autor}
          </p>
            <p class="p-2 text-sm text-gray-500 dark:text-white">
              <span class="font-bold">Editora:</span>
              ${books.editora}
            </p>
          </div>
      </div>
    </div>
  `;
};

//Aqui é onde aplica o estilo dos livros na página.
//Books são os livros cadastrados no documento books.js
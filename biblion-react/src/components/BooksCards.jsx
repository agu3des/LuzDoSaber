'use cliente';

import { useBook } from '@/context/BooksContext';
import { formatCurrency } from '@/lib/format';
import { useRouter } from 'next/navigation';

export default function BooksCards({
    id,
    name,
    value,
    autor,
    editora,
    image
  }) {

    const router = useRouter();

    const goToItem = (event) => {
      event.preventDefault();
      router.push('/item');
    }

    const {
      books,
      } = useBook();

  return  ( 
    <div className="bg-white dark:bg-gray-700 shadow-md rounded-lg p-4">
      <div className="max-sm:flex max-sm:text-center">
        <img className="foto sm:mx-auto" src={image} width="100px" />
        <div className="flex-col text-center">
          <h3 className="p-2 mt-4 text-lg font-semibold text-gray-700 dark:text-white">{name}
          </h3>
          <p className="p-2 text-sm text-gray-500 dark:text-white max-sm:hidden">
            <span className="font-bold">ISBN:</span> {id}
          </p>
          <p className="p-2 text-sm text-gray-500 dark:text-white">
            <span className="font-bold">Preço:</span> {formatCurrency(value)}
          </p>
          <p className="p-2 text-sm text-gray-500 dark:text-white max-sm:hidden">
            <span className="font-bold">Autor(a):</span> {autor}
          </p>
          <p className="p-2 text-sm text-gray-500 dark:text-white max-sm:hidden">
            <span className="font-bold">Editora:</span> {editora}
          </p>

          <button 
            onClick= {goToItem}
            OnChange={() => handleSelectBook(book.id)}
            className="mt-1 ml-1 py-3 px-4 inline-flex justify-center items-center gap-2 rounded-md border border-transparent font-semibold bg-[#debcbe] text-white hover:bg-pink-500 focus:outline-none focus:ring-2 focus:ring-gray-500 focus:ring-offset-2 transition-all text-sm dark:bg-gray-800 dark:hover:bg-gray-600 dark:focus:ring-offset-gray-800"
          >
            Veja mais sobre {name}
          </button>
        </div>
      </div>
    </div>
  );
}
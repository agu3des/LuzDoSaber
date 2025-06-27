'use client';

import { useEffect } from 'react';
import BooksCards from '@/components/BooksCards';
import { useBook } from '@/context/BooksContext';


export default function Home() {
  const {
    books,
    loadBooks,
  } = useBook();

useEffect(() => {
  loadBooks();
}, []);

  return (
    <>
      <main>
        <div className="grid grid-cols-3 max-sm:grid-cols-1 gap-3 pt-3 pb-3 pl-4 pr-4">
          {books.map((book) => (<BooksCards {...book} key={book.id} />))}
        </div>
      </main>
    </>
  );
}

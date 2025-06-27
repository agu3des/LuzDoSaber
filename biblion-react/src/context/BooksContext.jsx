'use client';

import React, { createContext, useState, useContext } from 'react';
import Storage from '@/services/supabase';
import { validEmail } from '@/lib/regex';

export const BookContext = createContext({});

export function BookProvider({ children }) {
  const initialBookFormData = {
    id: '',
    name: '',
    value: '',
    autor: '',
    editora: '',
    image: '',
  };

  const [books, setBook] = useState([]);

  const [isShowBookForm, setIsShowBookForm] = useState(false);

  const [bookFormData, setBookFormData] = useState(initialBookFormData);

  const [email, setEmail] = useState('');

  const [emailErr, setEmailErr] = useState(false);

  const [currentIndex, setCurrentIndex] = useState(0);

  const handleNext = () => {
    if (currentIndex < books.length - 1) {
      setCurrentIndex(currentIndex + 1);
    }
  };

  const handlePrevious = () => {
    if (currentIndex > 0) {
      setCurrentIndex(currentIndex - 1);
    }
  };

  const handleCreateBook = async () => {
    setBookFormData(initialBookFormData);

    toggleShowBookForm();
  };

  const toggleShowBookForm = () => {
    setIsShowBookForm(!isShowBookForm);
  };

  const loadBooks = async () => {
    const books = await Storage.read('books');

    setBook(books);
  };

  const createBook = async (book) => {
    const newBook = await Storage.create('books', book);

    setBook([...books, newBook]);
  };

  const removeBook = (id) => {
    const newBooks = books.filter(
      (book) => book.id !== id
    );

    setBook(newBooks);

    Storage.remove('books', id);
  };

  const validate = async () => {
     if (!validEmail.test(email)) {
        setEmailErr(true);
     }
  }
  
  return (
    <BookContext.Provider
      value={{
        books,
        setBook,
        isShowBookForm,
        setIsShowBookForm,
        bookFormData,
        setBookFormData,
        email,
        setEmail,
        emailErr,
        setEmailErr,
        currentIndex, 
        setCurrentIndex,
        handleNext,
        handlePrevious,
        toggleShowBookForm,
        loadBooks,
        createBook,
        removeBook,
        handleCreateBook,
        validate,

      }}
    >
      {children}
    </BookContext.Provider>
  );
}

export function useBook() {
  return useContext(BookContext);
}

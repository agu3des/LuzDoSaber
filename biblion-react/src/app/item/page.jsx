'use client'

import React from "react";
import { useBook } from '@/context/BooksContext';
import { useEffect } from 'react';
import BooksItem from '@/components/BooksItem';

export default function Home(){
    const {
        books,
        loadBooks,
        currentIndex, 
        handleNext,
        handlePrevious,
        } = useBook();
    
useEffect(() => {
    loadBooks();
}, []);

    return (
        <>
            <main>
                <div className="bg-white text-center">
                    <button className="mt-1 mb-2 p-3 inline-flex w-80 justify-center items-center rounded-md border border-transparent font-semibold bg-[#debcbe] text-white hover:bg-pink-500 focus:outline-none focus:ring-2 focus:ring-gray-500 focus:ring-offset-2 transition-all text-sm dark:bg-gray-800 dark:hover:bg-gray-600 dark:focus:ring-offset-gray-800" onClick={handlePrevious} disabled={currentIndex === 0}>
                        Previous
                    </button>
                    <BooksItem {...books[currentIndex]} key={books[currentIndex].id} />
                    <button className="mt-1 mb-2 p-3 inline-flex w-80 justify-center items-center rounded-md border border-transparent font-semibold bg-[#debcbe] text-white hover:bg-pink-500 focus:outline-none focus:ring-2 focus:ring-gray-500 focus:ring-offset-2 transition-all text-sm dark:bg-gray-800 dark:hover:bg-gray-600 dark:focus:ring-offset-gray-800" onClick={handleNext} disabled={currentIndex === books.length - 1}>
                        Next
                    </button>
                </div>
            </main>
        </>
    );
}
'use client';

import React from "react";
import '@/app/globals.css';
import '@supabase/supabase-js';
import { formatCurrency } from '@/lib/format';


export default function Home({
    id,
    name,
    value,
    autor,
    editora,
    image
    }) {

    return (
    <>
    <div className="bg-white text-center">
        <div className="pt-6">
        {/* Image gallery */}
        <div className="mx-auto mt-6 ">
            <div>
                <img
                    src={image}
                    className="m-auto h-full rounded-md object-cover max-sm:w-40"
                    width="300px"
                />
            </div>
        </div>
        {/* Product info */}
        <div className="mx-auto max-w-2xl px-4 pb-16 pt-10 sm:px-6 lg:grid lg:max-w-7xl lg:grid-cols-3 lg:grid-rows-[auto,auto,1fr] lg:gap-x-8 lg:px-8 lg:pb-24 lg:pt-16">
            <div className="lg:col-span-2 lg:border-r lg:border-gray-200 lg:pr-8">
            <h1 className="text-2xl font-bold tracking-tight text-black sm:text-3xl">
                {name}
            </h1>
            </div>
            {/* Options */}
            <div className="mt-4 lg:row-span-3 lg:mt-0">
            <h2 className="sr-only">Product information</h2>
            <p className="text-3xl tracking-tight text-gray-900">{formatCurrency(value)}</p>
            {/* Reviews */}
            <div className="mt-6">
                <h3 className="sr-only">Reviews</h3>
                <div className="flex items-center">
                <div className="flex items-center">
                    {/* Active: "text-gray-900", Default: "text-gray-200" */}
                    <svg
                    className="text-gray-900 h-5 w-5 flex-shrink-0"
                    viewBox="0 0 20 20"
                    fill="currentColor"
                    aria-hidden="true"
                    >
                    <path
                        fillRule="evenodd"
                        d="M10.868 2.884c-.321-.772-1.415-.772-1.736 0l-1.83 4.401-4.753.381c-.833.067-1.171 1.107-.536 1.651l3.62 3.102-1.106 4.637c-.194.813.691 1.456 1.405 1.02L10 15.591l4.069 2.485c.713.436 1.598-.207 1.404-1.02l-1.106-4.637 3.62-3.102c.635-.544.297-1.584-.536-1.65l-4.752-.382-1.831-4.401z"
                        clipRule="evenodd"
                    />
                    </svg>
                    <svg
                    className="text-gray-900 h-5 w-5 flex-shrink-0"
                    viewBox="0 0 20 20"
                    fill="currentColor"
                    aria-hidden="true"
                    >
                    <path
                        fillRule="evenodd"
                        d="M10.868 2.884c-.321-.772-1.415-.772-1.736 0l-1.83 4.401-4.753.381c-.833.067-1.171 1.107-.536 1.651l3.62 3.102-1.106 4.637c-.194.813.691 1.456 1.405 1.02L10 15.591l4.069 2.485c.713.436 1.598-.207 1.404-1.02l-1.106-4.637 3.62-3.102c.635-.544.297-1.584-.536-1.65l-4.752-.382-1.831-4.401z"
                        clipRule="evenodd"
                    />
                    </svg>
                    <svg
                    className="text-gray-900 h-5 w-5 flex-shrink-0"
                    viewBox="0 0 20 20"
                    fill="currentColor"
                    aria-hidden="true"
                    >
                    <path
                        fillRule="evenodd"
                        d="M10.868 2.884c-.321-.772-1.415-.772-1.736 0l-1.83 4.401-4.753.381c-.833.067-1.171 1.107-.536 1.651l3.62 3.102-1.106 4.637c-.194.813.691 1.456 1.405 1.02L10 15.591l4.069 2.485c.713.436 1.598-.207 1.404-1.02l-1.106-4.637 3.62-3.102c.635-.544.297-1.584-.536-1.65l-4.752-.382-1.831-4.401z"
                        clipRule="evenodd"
                    />
                    </svg>
                    <svg
                    className="text-gray-900 h-5 w-5 flex-shrink-0"
                    viewBox="0 0 20 20"
                    fill="currentColor"
                    aria-hidden="true"
                    >
                    <path
                        fillRule="evenodd"
                        d="M10.868 2.884c-.321-.772-1.415-.772-1.736 0l-1.83 4.401-4.753.381c-.833.067-1.171 1.107-.536 1.651l3.62 3.102-1.106 4.637c-.194.813.691 1.456 1.405 1.02L10 15.591l4.069 2.485c.713.436 1.598-.207 1.404-1.02l-1.106-4.637 3.62-3.102c.635-.544.297-1.584-.536-1.65l-4.752-.382-1.831-4.401z"
                        clipRule="evenodd"
                    />
                    </svg>
                    <svg
                    className="text-gray-200 h-5 w-5 flex-shrink-0"
                    viewBox="0 0 20 20"
                    fill="currentColor"
                    aria-hidden="true"
                    >
                    <path
                        fillRule="evenodd"
                        d="M10.868 2.884c-.321-.772-1.415-.772-1.736 0l-1.83 4.401-4.753.381c-.833.067-1.171 1.107-.536 1.651l3.62 3.102-1.106 4.637c-.194.813.691 1.456 1.405 1.02L10 15.591l4.069 2.485c.713.436 1.598-.207 1.404-1.02l-1.106-4.637 3.62-3.102c.635-.544.297-1.584-.536-1.65l-4.752-.382-1.831-4.401z"
                        clipRule="evenodd"
                    />
                    </svg>
                </div>
                <p className="sr-only">4 out of 5 stars</p>
                <a
                    href="#"
                    className="ml-3 text-sm font-medium text-[#debcbe] hover:text-pink-500 dark:text-gray-800"
                >
                    117 reviews
                </a>
                </div>
            </div>

            <form>  
                <button
                type="submit"
                className="mt-10 flex w-full items-center justify-center rounded-md border border-transparent bg-[#debcbe] px-8 py-3 text-base font-medium text-white hover:bg-pink-500 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2 dark:bg-gray-800 dark:hover:bg-gray-600 dark:focus:ring-offset-gray-800"
                >
                Add to bag
                </button>
            </form>
            </div>
            <div className="py-10 lg:col-span-2 lg:col-start-1 lg:border-r lg:border-gray-200 lg:pb-16 lg:pr-8 lg:pt-6">
            {/* Description and details */}
            <div>
                <h3 className="sr-only">Description</h3>
                <div className="space-y-6">
                <p className="text-base text-gray-900">
                    Isbn: {id}
                </p>
                <p className="text-base text-gray-900">
                    Preço: {value}
                </p>
                <p className="text-base text-gray-900">
                    Autor: {autor}
                </p>
                <p className="text-base text-gray-900">
                    Editora: {editora}
                </p>
                </div>
            </div>
            <div className="mt-10">
                <h2 className="text-sm font-medium font-semibold text-gray-900">Details</h2>
                <div className="mt-4 space-y-6">
                <p className="text-sm text-gray-600">
                    The 6-Pack includes two black, two white, and two heather gray
                    Basic Tees. Sign up for our subscription service and be the
                    first to get new, exciting colors, like our upcoming "Charcoal
                    Gray" limited release.
                </p>
                </div>
            </div>
            </div>
        </div>
        </div>
    </div>
    </>
 )
}

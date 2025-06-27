import { Oswald } from 'next/font/google'
import './globals.css'
import Header from '@/components/Header'
import Footer from '@/components/Footer'
import { BookProvider } from '@/context/BooksContext'


const oswald = Oswald({style: 'normal', weight: '400', preload: false, display: 'swap', serif: false})


export const metadata = {
  title: 'Livraria Biblion',
  description: 'Aplicação de uma livraria de livros',
}

export default function RootLayout({ children }) {
  return (
    <html lang="en">   
      <head>
        <link rel="icon" href="/public/favicon.ico" type="image/icon" />
      </head>
      <body className={oswald.className}>
        <BookProvider>
          <Header />
          <div>
            {children}
          </div>
          <Footer />
        </BookProvider>
      </body>
    </html>
  )
}

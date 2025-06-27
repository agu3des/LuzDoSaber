import React from "react";

export function Biblion({className='w-4'}) {
    return (
        <img
          src="/img/logoBiblion.svg"
          className={className}
          alt="Picture of the author"
        />
    )
}

export function BiblionLogo({className='lg:flex'}) {
    return (
        <img
          src="/img/logo-livro.png"
          className={className}
          alt="Picture of the author"
        />
    )
}

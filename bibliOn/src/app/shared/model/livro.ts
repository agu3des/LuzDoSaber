export class Livro {

    id?: string;
    titulo = '';
    autor = '';
    anoPublicacao?: number;
    genero = '';
    editora = '';
    isbn = '';
    imagemUrl = '';
    numeroPaginas?: number;
    avaliacao: number;

    constructor(id?: string, livro: Livro = {titulo: '', autor: '', genero: '', editora: '', isbn: '', imagemUrl: '', numeroPaginas: 0, avaliacao: 0    }) {
        this.id = id;
        this.titulo = livro.titulo;
        this.autor = livro.autor;
        this.anoPublicacao = livro.anoPublicacao;
        this.genero = livro.genero;
        this.editora = livro.editora;
        this.isbn = livro.isbn;
        this.imagemUrl = livro.imagemUrl;
        this.anoPublicacao = livro.anoPublicacao;
        this.avaliacao = livro.avaliacao;
    }
}

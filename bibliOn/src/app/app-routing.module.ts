import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ListagemComponent } from "./livro/listagem/listagem.component";
import { ManutencaoComponent } from "./livro/manutencao/manutencao.component";

import { HomePageComponent } from './home/home-page/home-page.component';
import { OriginComponent } from './home/origin/origin.component';
import { OngsComponent } from './home/ongs/ongs.component';

import { LoginModalComponent } from './layout/login/login.component';
import { MenuComponent } from './layout/menu/menu.component';
import { CatalogComponent } from './livro/catalog/catalog.component';

export const routes: Routes = [
    { 
        path: '', redirectTo: '/app-home-page', pathMatch: 'full' 
    },
    {
        path: 'app-menu',
        component: MenuComponent
    },
    {
        path: 'listagem-livros',
        component: ListagemComponent
    },
    {
        path: 'cadastro-livro',
        component: ManutencaoComponent
    },
    {
        path: 'edicao-livro/:id',
        component: ManutencaoComponent
    },
    {
        path: 'app-origin',
        component: OriginComponent
    },    
    {
        path: 'app-ongs',
        component: OngsComponent
    }, 
    {
        path: 'app-home-page',
        component: HomePageComponent
    },
    {
        path: 'app-login',
        component: LoginModalComponent
    },
        {
        path: 'app-catalog',
        component: CatalogComponent
    },    
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }


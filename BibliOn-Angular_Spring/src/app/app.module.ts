import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { FirestoreModule } from "./firestore/firestore.module";

import { FormsModule } from "@angular/forms";
import { ReactiveFormsModule } from '@angular/forms';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

import { MatFormFieldModule} from "@angular/material/form-field";
import { MatIconModule } from "@angular/material/icon";
import { MatBadgeModule } from "@angular/material/badge";
import { MatInputModule } from "@angular/material/input";
import { MatButton, MatButtonModule } from "@angular/material/button";
import { MatCardModule } from "@angular/material/card";

import { HomeModule } from "./home/home.module";
import { LayoutModule } from "./layout/layout.module";
import { LivroModule } from "./livro/livro.module";

import { MensagemIF } from './shared/model/MensagemIF';
import { MensagemSweetService } from './shared/services/mensagem-sweet.service';
import { ErroInterceptor } from './interceptor/erro-interceptor';

import {HTTP_INTERCEPTORS, provideHttpClient, withInterceptors, withInterceptorsFromDi} from "@angular/common/http";


import { LivroRestService } from './shared/services/livro-rest.service';

import { MatDialogRef, MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';
import { ConfirmationDialogComponent } from './layout/confirmation-dialog/confirmation-dialog.component';


@NgModule({
    declarations: [
        AppComponent,
        ConfirmationDialogComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        AppRoutingModule,
        FirestoreModule,
        MatFormFieldModule,
        MatIconModule,
        MatBadgeModule,
        MatInputModule,
        MatButtonModule,
        MatCardModule,
        HomeModule,
        LayoutModule,
        LivroModule,
        MatDialogModule
    ],
    providers: [
        provideAnimationsAsync(),
        provideHttpClient(),
        provideHttpClient(withInterceptorsFromDi()),
        {
            provide: HTTP_INTERCEPTORS,
            useClass: ErroInterceptor,
            multi: true
        },
        {
        provide: MensagemIF,
        useClass: MensagemSweetService
        },
        {
        provide: LivroRestService,
        useClass: LivroRestService
        },
    ],
    exports: [
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
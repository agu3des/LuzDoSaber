import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from "@angular/router";
import { AppRoutingModule } from '../app-routing.module';


import { HomePageComponent } from './home-page/home-page.component';
import { OriginComponent } from './origin/origin.component';
import { OngsComponent } from './ongs/ongs.component';

import { VolunteerModule } from '../volunteer/volunteer.module';

import { FormsModule } from "@angular/forms";
import { ReactiveFormsModule } from '@angular/forms';
import { MatButton, MatButtonModule } from "@angular/material/button";
import { MatFormField, MatFormFieldModule } from "@angular/material/form-field";
import { MatInput, MatInputModule } from "@angular/material/input";
import { MatCardModule } from "@angular/material/card";
import { MatIcon, MatIconModule } from "@angular/material/icon";
import { MatBadge, MatBadgeModule } from "@angular/material/badge";
import { MatSelectModule } from '@angular/material/select'; 
import { MatProgressBarModule } from '@angular/material/progress-bar';





@NgModule({
  declarations: [
    HomePageComponent,
    OriginComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatIconModule,
    MatBadgeModule,
    MatSelectModule,
    MatProgressBarModule,
    VolunteerModule
  ],
  exports: [    
    HomePageComponent,
    OriginComponent,
  ]
})
export class HomeModule { 


}

import { Routes } from '@angular/router';
import {DocumentListComponent} from "./document-list/document-list.component";
import {DocumentEditComponent} from "./document-edit/document-edit.component";
import { HomeComponent} from "./home/home.component";

export const routes: Routes = [{
  path: 'documents',
  component: DocumentListComponent
},
  {
    path: 'documents/:id',
    component: DocumentEditComponent
  },
  {
    path: 'documents/new',
    component: DocumentEditComponent
  },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {
    path: 'home',
    component: HomeComponent
  }
];

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovieCreateComponent } from './components/movie/movie-create/movie-create.component';
import { HomeComponent } from './views/home/home.component';
import { MovieCrudComponent } from './views/movie-crud/movie-crud.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'movies', component: MovieCrudComponent },
  { path: 'create', component: MovieCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

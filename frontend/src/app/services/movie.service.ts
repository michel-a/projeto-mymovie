import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { Movie } from '../entities/Movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  baseUrl = 'http://localhost:8081/api/movies';

  constructor(
    private snackBar: MatSnackBar,
    private http: HttpClient
  ) { }

  create(movie: Movie): Observable<Movie> {
    return this.http.post<Movie>(this.baseUrl, movie);
  }

  showMessage(msg: string): void {
    this.snackBar.open(msg, 'X', {
      duration: 3000,
      horizontalPosition: 'right',
      verticalPosition: 'top'
    });
  }
}

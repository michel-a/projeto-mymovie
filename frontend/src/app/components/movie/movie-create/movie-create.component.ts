import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from 'src/app/entities/Movie';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-movie-create',
  templateUrl: './movie-create.component.html',
  styleUrls: ['./movie-create.component.css']
})
export class MovieCreateComponent implements OnInit {

  movie: Movie = {
    translatedTitle: '',
    originalTitle: '',
    releaseYear: '',
    genre: '',
    audio: '',
    size: 0,
    duration: 0
  }

  constructor(
    private movieService: MovieService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  createMovie(): void {
    this.movieService.create(this.movie).subscribe(response => {
      console.log(response);
      this.movieService.showMessage('Filme salvo!');
      this.router.navigate(['/movies']);
    });
    
  }

  cancel(): void {
     this.router.navigate(['/movies']);
  }
}

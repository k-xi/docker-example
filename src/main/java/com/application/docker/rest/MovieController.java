package com.application.docker.rest;

import com.application.docker.dto.MovieDto;
import com.application.docker.persistence.model.Movie;
import com.application.docker.service.IMovieService;
//import com.application.docker.service.impl.GitHubArtifactUploader;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MovieController {

  private IMovieService movieService;

  //private GitHubArtifactUploader gitHubArtifactUploader;

  @PostMapping("api/v1/movie")
  public ResponseEntity get(@RequestBody final MovieDto movieDto) {
    Movie movie = getMovieToCreate(movieDto);
    Movie createdMovie = movieService.create(movie);

    try {
     // gitHubArtifactUploader.uploadArtifact();
    } catch(Exception ex){
      System.out.println("Errorrr");
    }
    return ResponseEntity.ok(MovieDto.builder()
        .movieName(createdMovie.getMovieName())
        .category(createdMovie.getCategory())
        .build());
  }

  private Movie getMovieToCreate(MovieDto movieDto) {
    return Movie.builder()
        .movieName(movieDto.getMovieName())
        .category(movieDto.getCategory())
        .build();
  }

  @GetMapping("/health")
  @ResponseStatus(HttpStatus.OK)
  private String getMovieToCreate() {
    return "Healthy";
  }

}

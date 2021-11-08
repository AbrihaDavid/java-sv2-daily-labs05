package day01;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cinema {

    private List<Movie> movies = new ArrayList<>();

    public void addMovie (Movie movie){
        movies.add(movie);
    }

    public List<String> findMovieByTime (LocalDateTime time){
        List<String> selectedMovies = new ArrayList<>();
        for (Movie m: movies){
            for (int i = 0; i < m.getDates().size(); i++){
                if (m.getDates().get(i).equals(time)){
                    selectedMovies.add(m.getTitle());
                }
            }
        }
      return selectedMovies;
    }

    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        cinema.addMovie(new Movie("Titanic", Arrays.asList(
                LocalDateTime.of(2021,11,8,12,45),
                LocalDateTime.of(2021,11,8,22,25)
        )));
        cinema.addMovie(new Movie("Jurassic Park", Arrays.asList(
                LocalDateTime.of(2021,11,8,19,45),
                LocalDateTime.of(2021,11,8,20,25),
                LocalDateTime.of(2021,11,8,22,25)
        )));

        System.out.println(cinema.findMovieByTime(LocalDateTime.of(2021,11,8,10,45))); // []
        System.out.println(cinema.findMovieByTime(LocalDateTime.of(2021,11,8,19,45))); // [Jurassic Park]
        System.out.println(cinema.findMovieByTime(LocalDateTime.of(2021,11,8,22,25))); // [Titanic, Jurassic Park]
    }
}

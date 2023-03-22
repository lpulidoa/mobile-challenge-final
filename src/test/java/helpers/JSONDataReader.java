package helpers;

import com.google.gson.Gson;
import data.entities.Movie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JSONDataReader {
    private final String moviesFilePath = "src/test/resources/testdataresources/movies.JSON";
    private List<Movie> movieList;

    public JSONDataReader() {
        movieList = getMovieData();
    }

    private List<Movie> getMovieData() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(moviesFilePath));
            Movie[] movies = gson.fromJson(bufferReader, Movie[].class);
            return Arrays.asList(movies);
        }catch(FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + moviesFilePath);
        }finally {
            try { if(bufferReader != null) bufferReader.close();}
            catch (IOException ignore) {}
        }
    }

    public final Movie getMovieByName(String movieName){
        return movieList.stream().filter(x -> x.getName().equalsIgnoreCase(movieName)).findAny().get();
    }
}

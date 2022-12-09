package org.example.travel.di;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SetterExample {

    private MovieFinder movieFinder;
    private final MovieExporter movieExporter;

    public SetterExample(MovieExporter movieExporter) {
        this.movieExporter = movieExporter;
    }

    @Autowired(required = false)
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public void find() {
        log.info("Finding Movie {}, movieExporter --{}", movieFinder, movieExporter);
    }
}

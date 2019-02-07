package com.maithmuzic.common.db.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.util.List;
import java.util.stream.Collectors;

public enum Genre {
    Pop;

    public static class GenreConverter implements DynamoDBTypeConverter<String, Genre> {

        @Override
        public String convert(Genre genre) {
            return genre.name();
        }

        @Override
        public Genre unconvert(String genre) {
            return Genre.valueOf(genre);
        }
    }

    public static class GenresListConverter implements DynamoDBTypeConverter<List<String>, List<Genre>> {

        @Override
        public List<String> convert(List<Genre> genres) {
            return genres.stream().map(g -> g.name()).collect(Collectors.toList());
        }

        @Override
        public List<Genre> unconvert(List<String> genres) {
            return genres.stream().map(r -> Genre.valueOf(r)).collect(Collectors.toList());
        }
    }
}

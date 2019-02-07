package com.maithmuzic.common.db.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.util.List;
import java.util.stream.Collectors;

public enum Language {
    hi;

    public static class LanguageConverter implements DynamoDBTypeConverter<String, Language> {

        @Override
        public String convert(Language language) {
            return language.name();
        }

        @Override
        public Language unconvert(String language) {
            return Language.valueOf(language);
        }
    }

    public static class LanguagesListConverter implements DynamoDBTypeConverter<List<String>, List<Language>> {

        @Override
        public List<String> convert(List<Language> languages) {
            return languages.stream().map(l -> l.name()).collect(Collectors.toList());
        }

        @Override
        public List<Language> unconvert(List<String> languages) {
            return languages.stream().map(r -> Language.valueOf(r)).collect(Collectors.toList());
        }
    }
}

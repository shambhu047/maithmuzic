package com.maithmuzic.core;

import com.maithmuzic.common.db.DAO;
import com.maithmuzic.common.db.models.*;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        DAO dao = DAO.getInstance();

        String country = "in";

        Language language = Language.hi;
        ArrayList<Language> languages = new ArrayList<>();
        languages.add(language);

        Genre genre = Genre.Pop;
        ArrayList<Genre> genres = new ArrayList<>();
        genres.add(genre);

        ArrayList<String> tags = new ArrayList<>();
        tags.add("maithmuzic");

        UserGroup userGroup = new UserGroup();
        userGroup.setRoles(new ArrayList<>());
        dao.mapper.save(userGroup);

        Singer singer = new Singer();
        singer.setName("Mohit Chauhan");
        singer.setLanguages(languages);
        singer.setCountry(country);
        singer.setGenres(genres);
        singer.setTags(tags);
        dao.mapper.save(singer);

        User user = new User();
        user.setUsername("SomeUniqueId");
        dao.mapper.save(user);

        Musician musician = new Musician();
        musician.setName("A R Rahaman");
        musician.setCountry(country);
        musician.setGenres(genres);
        musician.setLanguages(languages);
        musician.setTags(tags);
        dao.mapper.save(musician);

        Lyricist lyricist = new Lyricist();
        lyricist.setName("Javed Akhtar");
        lyricist.setCountry(country);
        lyricist.setGenres(genres);
        lyricist.setLanguages(languages);
        lyricist.setTags(tags);

        Album album = new Album();
        album.setName("Some Album");
        album.setGenres(genres);
        album.setLanguage(language);
        dao.mapper.save(album);

        Song song = new Song();
        song.setTitle("Guncha Koi mere naam kar gaya");
        song.setAlbumId("Some Album Id");
        dao.mapper.save(song);
    }
}

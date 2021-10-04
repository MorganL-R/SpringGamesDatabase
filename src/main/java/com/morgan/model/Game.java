package com.morgan.model;


import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@JsonIncludeProperties({"id", "title", "genre", "releaseYear", "ageRating", "developer"})
public class Game {
    @Id
    @Column(name = "game_id")
    @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column
    private String genre;
    @Column
    private String developer;
    @Column
    private int ageRating;
    @Column
    private int releaseYear;


    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", ageRating=" + ageRating +
                ", releaseYear='" + releaseYear + '\'' +
                ", developer='" + developer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return ageRating == game.ageRating &&
                Objects.equals(id, game.id) &&
                Objects.equals(title, game.title) &&
                Objects.equals(genre, game.genre) &&
                Objects.equals(releaseYear, game.releaseYear) &&
                Objects.equals(developer, game.developer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, ageRating, releaseYear, developer);
    }
}

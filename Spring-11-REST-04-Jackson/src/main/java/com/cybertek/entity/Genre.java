package com.cybertek.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(value={"hibernateLazyInitializer"}, ignoreUnknown = true)
public class Genre extends BaseEntity {


    private String name;

    @ManyToMany(mappedBy = "genreList")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore //above, mappedBy, so can use JasonIgnore here
    private List<Movie> movieList = new ArrayList<>();

    public Genre(String name) {
        this.name = name;
    }

}

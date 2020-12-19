package com.cybertek.entity;

import com.cybertek.enums.MovieState;
import com.cybertek.enums.MovieType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Movie extends BaseEntity{
    private String name;

    @Column(columnDefinition = "DATE") //Jave 8
    private LocalDate releaseDate;

    private Integer duration;

    @Column(columnDefinition = "text") //sets no limitation in character limit
    private String summary;

    @Enumerated(EnumType.STRING) //if no annotation it will be ORDINAL
    private MovieType type;
    @Enumerated(EnumType.STRING)//if no annotation it will be ORDINAL
    private MovieState state;

    private BigDecimal price;






}

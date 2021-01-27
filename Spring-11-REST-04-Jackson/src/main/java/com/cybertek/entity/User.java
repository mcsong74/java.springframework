package com.cybertek.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_account")
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(value={"hibernateLazyInitializer"}, ignoreUnknown = true)
//if there is Fetching type Lazy spring will add one field automatically which is LazyInitializer. Ignore the field,
// and do not try to de-serialize
public class User extends BaseEntity { //User is reserve name in SQL table

    private String email;
    private String password;
    private String username;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "account_details_id")
    @JsonManagedReference //
    private Account account;

    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}

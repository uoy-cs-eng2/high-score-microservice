package uk.ac.york.eng2.highscores.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import io.micronaut.data.annotation.DateCreated;
import io.micronaut.serde.annotation.Serdeable;

@Entity
@Serdeable
public class Score {

    @Id
    @GeneratedValue
    private Long id;

    @DateCreated
    @Column(nullable = false)
    private Instant created;

    @Column(nullable = false)
    private String user;

    @Min(0)
    @Column(nullable = false)
    private Integer score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}

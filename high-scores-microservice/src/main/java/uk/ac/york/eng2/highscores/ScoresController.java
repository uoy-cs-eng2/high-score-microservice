package uk.ac.york.eng2.highscores;

import java.net.URI;
import java.util.List;

import javax.validation.constraints.Min;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import jakarta.inject.Inject;
import uk.ac.york.eng2.highscores.domain.Score;
import uk.ac.york.eng2.highscores.repositories.ScoresRepository;

@Controller("/scores")
public class ScoresController {

    @Inject
    ScoresRepository repo;

    @Get("/{id}")
    public Score getScore(long id) {
        return repo.findById(id).orElse(null);
    }

    @Post("/")
    public HttpResponse<Void> postScore(@Body Score score) {
        repo.save(score);
        return HttpResponse.created(URI.create("/" + score.getId()));
    }

    @Get("/top10")
    public List<Score> topTenScores() {
        return repo.findTop10OrderByScoreDesc();
    }

    @Get("/top{?user,n}")
    public List<Score> topScoresByUser(@Nullable @QueryValue String user, @Min(1) @QueryValue(defaultValue = "10") int n) {
        if (user != null) {
            return repo.findByUserOrderByScoreDesc(user, Pageable.from(0, n));
        } else {
            return repo.findOrderByScoreDesc(Pageable.from(0, n));
        }
    }

}

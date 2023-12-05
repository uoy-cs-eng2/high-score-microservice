package uk.ac.york.eng2.highscores.repositories;

import java.util.List;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.CrudRepository;
import uk.ac.york.eng2.highscores.domain.Score;

@Repository
public interface ScoresRepository extends CrudRepository<Score, Long> {
    List<Score> findTop10OrderByScoreDesc();

    List<Score> findByUserOrderByScoreDesc(String user, Pageable pageable);

    List<Score> findOrderByScoreDesc(Pageable pageable);
}

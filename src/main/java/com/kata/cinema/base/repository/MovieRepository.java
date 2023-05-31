package com.kata.cinema.base.repository;

import com.kata.cinema.base.models.entitys.Movie;
import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.RARS;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, JpaSpecificationExecutor<Movie> {

    @EntityGraph(value = "movieGraph")
    Movie getMovieById(Long id);

    boolean existsMovieById(Long id);

    @Query("SELECT m FROM Movie m WHERE m.name = :name AND m.dateRelease BETWEEN :startDate AND :endDate "
        + "AND m.genre IN :genres AND m.rars = :rars AND m.mpaa = :mpaa")
    Page<Movie> searchMovies (
            String name,
            LocalDate startDate,
            LocalDate endDate,
            List<String> genres,
            RARS rars,
            MPAA mpaa,
            Pageable pageable
    );

    @EntityGraph(attributePaths = {"scores"})
    List<Movie> findByNameContaining(String name);
}

package com.kata.cinema.base.repository;

import com.kata.cinema.base.models.dto.response.FolderPersonPositionalResponseDto;
import com.kata.cinema.base.models.entitys.FolderPersonPositional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface FolderPersonPositionalRepository extends JpaRepository<FolderPersonPositional, Long>  {

    @Query("SELECT new com.kata.cinema.base.models.dto.response.FolderPersonPositionalResponseDto( " +
            "fpp.id, " +
            "fpp.person, " +
            "fpp.folder, " +
            "fpp.positional) " +
            "FROM FolderPersonPositional fpp WHERE fpp.folder.id = :folderId AND fpp.person.id = :personId")
    FolderPersonPositionalResponseDto getByFolderIdAndPersonId(@Param("folderId") Long folderId, @Param("personId") Long personId);
    
    @Query("SELECT fpp.positional FROM FolderPersonPositional fpp ORDER BY fpp.id DESC LIMIT 1")
    Integer getLastPersonPosition();
}

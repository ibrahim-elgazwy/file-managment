package com.files.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.files.domain.File;

@Repository
public interface FilesRepository extends JpaRepository<File, Long> {

}

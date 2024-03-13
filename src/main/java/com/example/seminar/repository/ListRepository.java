package com.example.seminar.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.seminar.model.DBFile;

@Repository
public interface ListRepository extends JpaRepository<DBFile, Long>{

	
}

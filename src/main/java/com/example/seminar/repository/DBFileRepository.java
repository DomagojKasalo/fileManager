package com.example.seminar.repository;

import com.example.seminar.model.DBFile;
import com.example.seminar.model.fileI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {
	
	
	@Query(value = "SELECT files.id as id, file_name as fileName, file_type as fileType, first_name as firstName FROM files, user "
			+ "WHERE files.user_id = user.id", nativeQuery = true)

	public Page<fileI> findAllC(Pageable pageable);
	
}
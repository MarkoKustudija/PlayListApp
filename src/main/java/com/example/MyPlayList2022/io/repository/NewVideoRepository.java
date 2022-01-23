package com.example.MyPlayList2022.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MyPlayList2022.io.entity.NewVideoEntity;

@Repository
public interface NewVideoRepository extends JpaRepository<NewVideoEntity, Long> {

	NewVideoEntity findByName(String name);

}

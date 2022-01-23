package com.example.MyPlayList2022.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MyPlayList2022.io.entity.PlayListEntity;
import com.example.MyPlayList2022.io.entity.VideoEntity;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Long> {

	Iterable<VideoEntity> findAllByPlayList(PlayListEntity playListEntity);

	VideoEntity findByVideoId(String videoId);

}

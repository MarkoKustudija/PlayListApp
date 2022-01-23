package com.example.MyPlayList2022.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MyPlayList2022.io.entity.PlayListEntity;
import com.example.MyPlayList2022.io.entity.VideoEntity;
import com.example.MyPlayList2022.shared.VideoDto;

@Repository
public interface PlayListRepository extends JpaRepository<PlayListEntity,Long> {

	PlayListEntity findByName(String name);

	PlayListEntity findByplaylistId(String id);

	PlayListEntity save(VideoDto videoDto);

}

package com.example.MyPlayList2022.service;

import com.example.MyPlayList2022.shared.PlayListDto;

public interface PlayListService {

	PlayListDto create(PlayListDto playListDto);

	PlayListDto getPlayList(String id);

//	PlayListDto addNewVideo(String id, PlayListDto playListDto);

}

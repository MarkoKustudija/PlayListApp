package com.example.MyPlayList2022.service;

import com.example.MyPlayList2022.shared.PlayListDto;
import com.example.MyPlayList2022.ui.request.NewVideo;

public interface PlayListService {

	PlayListDto create(PlayListDto playListDto);

	PlayListDto getPlayList(String id);

	boolean addNewVideo(String id, NewVideo newVideoDetails);

}

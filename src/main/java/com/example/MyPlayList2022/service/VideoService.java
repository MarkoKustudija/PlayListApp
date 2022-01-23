package com.example.MyPlayList2022.service;

import java.util.List;

import com.example.MyPlayList2022.shared.VideoDto;

public interface VideoService {

	List<VideoDto> getVideosFromPlayList(String id);

	VideoDto updateVideo(String id, VideoDto videoDto);

	VideoDto deleteVideo(String videoId);

	boolean addNewVideo(String name);


}

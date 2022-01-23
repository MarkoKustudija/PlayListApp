package com.example.MyPlayList2022.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyPlayList2022.service.VideoService;
import com.example.MyPlayList2022.shared.VideoDto;
import com.example.MyPlayList2022.ui.response.VideoRest;

@RestController
@RequestMapping("api/v1/videos")
public class VideoController {
	
	@Autowired
	VideoService videoService;
	
	// Get all videos
	@GetMapping
	public List<VideoRest> getVideos() {
		
		List<VideoRest> returnValue  = new ArrayList<>();
		List<VideoDto> videos = videoService.getVideos();
		
		for(VideoDto videoDto : videos) {
			VideoRest videoRest = new VideoRest();
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.map(videoDto, videoRest);
			returnValue.add(videoRest);
		}
		
		return returnValue;
		
	}
	
	// delete one video  by Id from play list
	@DeleteMapping(path = "/{videoId}")
	public VideoRest deleteVideo(@PathVariable String videoId) {
		
		VideoRest returnValue = new VideoRest();
		VideoDto videoDto = videoService.deleteVideo(videoId);
		
		ModelMapper modelMapper = new ModelMapper();
		returnValue = modelMapper.map(videoDto, VideoRest.class);
		
		return returnValue;
		
	}

	
}

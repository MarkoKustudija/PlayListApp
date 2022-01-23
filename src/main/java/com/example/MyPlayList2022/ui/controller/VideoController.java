package com.example.MyPlayList2022.ui.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyPlayList2022.service.PlayListService;
import com.example.MyPlayList2022.service.VideoService;
import com.example.MyPlayList2022.shared.VideoDto;
import com.example.MyPlayList2022.shared.utils.Utils;
import com.example.MyPlayList2022.ui.response.VideoRest;

@RestController
@RequestMapping("api/v1/videos")
public class VideoController {
	
	@Autowired
	VideoService videoService;
	
	@Autowired
	PlayListService playListService;
	
	@Autowired
	Utils utils;
	
	
	
	/**  http://localhost:8080/api/v1/videos/{id}  */
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

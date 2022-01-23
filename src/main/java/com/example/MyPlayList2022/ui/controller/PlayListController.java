package com.example.MyPlayList2022.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyPlayList2022.service.PlayListService;
import com.example.MyPlayList2022.service.VideoService;
import com.example.MyPlayList2022.shared.PlayListDto;
import com.example.MyPlayList2022.shared.VideoDto;
import com.example.MyPlayList2022.ui.request.PlayListRequestDetailsModel;
import com.example.MyPlayList2022.ui.request.VideoRequestDetailsModel;
import com.example.MyPlayList2022.ui.response.PlayListRest;
import com.example.MyPlayList2022.ui.response.VideoRest;


@RestController
@RequestMapping(value = "/api/v1/playlist")
public class PlayListController {
	
	@Autowired
	PlayListService playListService;
	
	@Autowired
	VideoService videoService;
	
	@PostMapping
	public PlayListRest create(@RequestBody PlayListRequestDetailsModel playListDetails) {
		
		if(playListDetails.getName().isEmpty())
			throw new IllegalStateException("Missing required field");
		
		PlayListRest returnValue = new PlayListRest();
		PlayListDto playListDto = new PlayListDto();
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(playListDetails, playListDto);
		
		
		PlayListDto newPlayList = playListService.create(playListDto);
		returnValue = modelMapper.map(newPlayList, PlayListRest.class);
		
		return returnValue;
	}
	
	@GetMapping(path = "/{id}")
	public PlayListRest getPlayList(@PathVariable String id) {
		
		PlayListRest returnValue = new PlayListRest();
		PlayListDto playListDto = playListService.getPlayList(id);
		
		ModelMapper modelMapper = new ModelMapper();
		returnValue = modelMapper.map(playListDto, PlayListRest.class);
		
		return returnValue;
		
		
	}
	
	@GetMapping(path ="/{id}/videos")
	public List<VideoRest> getVideosFromPlayList(@PathVariable String id) {
		
		List<VideoRest> returnValue = new ArrayList<>();
		List<VideoDto> videos = videoService.getVideosFromPlayList(id);
		
		for(VideoDto videoDto : videos) {
			VideoRest restModel = new VideoRest();
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.map(videoDto, restModel);
			returnValue.add(restModel);
		}
		return returnValue;
		
		
	}
	
	@PutMapping(path = "/{id}/videos/{videoId}")
	public VideoRest updateVideo(@PathVariable String videoId, @RequestBody VideoRequestDetailsModel videoDetails) {
		
		VideoRest returnValue = new VideoRest();
		VideoDto videoDto =  new VideoDto();
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(videoDetails, videoDto);
		
		VideoDto newVideo = videoService.updateVideo(videoId, videoDto);
		returnValue = modelMapper.map(newVideo, VideoRest.class);
		
		return returnValue;
		
	}
	
	
	
	
//	@PutMapping(path = "/{id}/addVideo")
//	public PlayListRest addNewVideo(@PathVariable String id, @RequestBody VideoRequestDetailsModel videoDetails) {
//		
//		PlayListRest returnValue = new PlayListRest();
//		PlayListDto playListDto =  new PlayListDto();
//		
//		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.map(videoDetails, playListDto);
//		
//		PlayListDto newVideo = playListService.addNewVideo(id, playListDto);
//		returnValue = modelMapper.map(newVideo,PlayListRest.class);
//		
//		return returnValue;
//		
//	}
	
	
	
	

	
	

}

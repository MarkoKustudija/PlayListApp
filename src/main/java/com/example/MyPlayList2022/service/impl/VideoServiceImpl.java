package com.example.MyPlayList2022.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyPlayList2022.io.entity.PlayListEntity;
import com.example.MyPlayList2022.io.entity.VideoEntity;
import com.example.MyPlayList2022.io.repository.PlayListRepository;
import com.example.MyPlayList2022.io.repository.VideoRepository;
import com.example.MyPlayList2022.service.VideoService;
import com.example.MyPlayList2022.shared.VideoDto;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	VideoRepository videoRepository;
	
	@Autowired
	PlayListRepository playListRepository;

	@Override
	public List<VideoDto> getVideosFromPlayList(String id) {
		
		List<VideoDto> returnValue = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		
		PlayListEntity playListEntity = playListRepository.findByplaylistId(id);
		if(playListEntity == null) return returnValue;
		
		Iterable<VideoEntity> videos = videoRepository.findAllByPlayList(playListEntity);
		
		for(VideoEntity videoEntity : videos) {
			VideoDto videoDto = new VideoDto();
			modelMapper.map(videoEntity, videoDto);
			returnValue.add(videoDto);
		}
		
		return returnValue;
	}

//	@Override
//	public VideoDto addNewVideo(String id, VideoDto videoDto) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public VideoDto updateVideo(String videoId,VideoDto videoDto) {
		
		VideoDto returnValue = new VideoDto();
		VideoEntity videoEntity = videoRepository.findByVideoId(videoId);
		
		if(videoEntity == null)
			throw new IllegalStateException("Video doesn't exist!");
		
		ModelMapper modelMapper = new ModelMapper();
		
//		videoEntity.setId(videoDto.getId());
		videoEntity.setName(videoDto.getName());
		
		VideoEntity savedVideo = videoRepository.save(videoEntity);
		returnValue = modelMapper.map(savedVideo, VideoDto.class);
		
		
		return returnValue;
	}

	@Override
	public VideoDto deleteVideo(String videoId) {
		
		VideoDto returnValue = new VideoDto();
		VideoEntity videoEntity = videoRepository.findByVideoId(videoId);
		
		if(videoEntity == null)
			throw new IllegalStateException("Video doesn't exist!");
		
		ModelMapper modelMapper = new ModelMapper();
		
		videoRepository.delete(videoEntity);
		
		returnValue = modelMapper.map(videoEntity, VideoDto.class);
			
		return returnValue;
	}

	@Override
	public List<VideoDto> getVideos() {

		List<VideoDto> returnValue = new ArrayList<>();
		Iterable<VideoEntity> videos = videoRepository.findAll();
		
		for(VideoEntity videoEntity : videos) {
			VideoDto videoDto = new VideoDto();
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.map(videoEntity, videoDto);
			returnValue.add(videoDto);
		}
		
		return returnValue;
	}

}

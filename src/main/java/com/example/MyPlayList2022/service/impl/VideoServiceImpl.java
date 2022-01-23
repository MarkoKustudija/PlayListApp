package com.example.MyPlayList2022.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyPlayList2022.io.entity.NewVideoEntity;
import com.example.MyPlayList2022.io.entity.PlayListEntity;
import com.example.MyPlayList2022.io.entity.VideoEntity;
import com.example.MyPlayList2022.io.repository.NewVideoRepository;
import com.example.MyPlayList2022.io.repository.PlayListRepository;
import com.example.MyPlayList2022.io.repository.VideoRepository;
import com.example.MyPlayList2022.service.VideoService;
import com.example.MyPlayList2022.shared.VideoDto;
import com.example.MyPlayList2022.shared.utils.Utils;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	VideoRepository videoRepository;
	
	@Autowired
	PlayListRepository playListRepository;
	
	@Autowired
	NewVideoRepository newVideoRepository;
	
	@Autowired
	Utils utils;
	
	@Override
	public boolean addNewVideo(String name) {
		
		boolean returnValue = false;
		
		ModelMapper modelMapper = new ModelMapper();
		VideoEntity videoEntity = videoRepository.findByName(name);
		
		if(videoEntity != null)
			throw new IllegalStateException("Record already exist!");
		
		VideoEntity newVideo = new VideoEntity();
		newVideo.setName(name);

		PlayListEntity playListEntity = new PlayListEntity();
		modelMapper.map(newVideo, playListEntity);
		
	    playListEntity.setPlaylistId(utils.generatePlayListId(30));
	    
	    playListRepository.save(playListEntity);
		
		NewVideoEntity newVideoEntity = new NewVideoEntity();
		newVideoEntity.setName(name);
		newVideoEntity.setPlayList(playListEntity);;
		
		newVideoRepository.save(newVideoEntity);
		
	
		return returnValue;
	}
	
	
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


	@Override
	public VideoDto updateVideo(String videoId,VideoDto videoDto) {
		
		VideoDto returnValue = new VideoDto();
		VideoEntity videoEntity = videoRepository.findByVideoId(videoId);
		
		if(videoEntity == null)
			throw new IllegalStateException("Video doesn't exist!");
		
		ModelMapper modelMapper = new ModelMapper();
		
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
	
		

}

package com.example.MyPlayList2022.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyPlayList2022.io.entity.NewVideoEntity;
import com.example.MyPlayList2022.io.entity.PlayListEntity;
import com.example.MyPlayList2022.io.repository.NewVideoRepository;
import com.example.MyPlayList2022.io.repository.PlayListRepository;
import com.example.MyPlayList2022.io.repository.VideoRepository;
import com.example.MyPlayList2022.service.PlayListService;
import com.example.MyPlayList2022.shared.PlayListDto;
import com.example.MyPlayList2022.shared.VideoDto;
import com.example.MyPlayList2022.shared.utils.Utils;
import com.example.MyPlayList2022.ui.request.NewVideo;

@Service
public class PlayListServiceImpl implements PlayListService {

	@Autowired
	PlayListRepository playListRepository;

	@Autowired
	NewVideoRepository newVideoRepository;

	@Autowired
	VideoRepository videoRepository;

	@Autowired
	Utils utils;

	@Override
	public PlayListDto create(PlayListDto playListDto) {

		PlayListDto returnValue = new PlayListDto();

		if (playListRepository.findByName(playListDto.getName()) != null)
			throw new IllegalStateException("Record already exist in db!");

		ModelMapper modelMapper = new ModelMapper();

		for (int i = 0; i < playListDto.getVideos().size(); i++) {
			VideoDto videoDto = playListDto.getVideos().get(i);
			videoDto.setVideoId(utils.generateVideoId(30));
			videoDto.setPlayList(playListDto);
			playListDto.getVideos().set(i, videoDto);
		}

		PlayListEntity playListEntity = modelMapper.map(playListDto, PlayListEntity.class);
		playListEntity.setPlaylistId(utils.generatePlayListId(30));

		PlayListEntity cretedPlayList = playListRepository.save(playListEntity);
		returnValue = modelMapper.map(cretedPlayList, PlayListDto.class);

		return returnValue;
	}

	@Override
	public PlayListDto getPlayList(String id) {

		PlayListDto returnValue = new PlayListDto();

		PlayListEntity playListEntity = playListRepository.findByplaylistId(id);

		if (playListEntity == null)
			throw new IllegalStateException("Record doesnt' exist!");

		ModelMapper modelMapper = new ModelMapper();
		returnValue = modelMapper.map(playListEntity, PlayListDto.class);

		return returnValue;
	}

	@Override
	public boolean addNewVideo(String id, NewVideo newVideoDetails) {

		boolean returnValue = false;

		PlayListEntity playListEntity = playListRepository.findByplaylistId(id);

		if (playListEntity == null)
			throw new IllegalStateException("Record doesn't exist!");

		if (newVideoRepository.findByName(newVideoDetails.getName()) != null)
			throw new IllegalStateException("Record already exist!");

		NewVideoEntity newVideoEntity = new NewVideoEntity();
		newVideoEntity.setName(newVideoDetails.getName());
		newVideoEntity.setPlayList(playListEntity);

		newVideoRepository.save(newVideoEntity);

		return returnValue;
	}

}

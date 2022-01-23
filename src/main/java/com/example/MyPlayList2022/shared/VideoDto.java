package com.example.MyPlayList2022.shared;

import java.io.Serializable;

public class VideoDto implements Serializable{
	
	
	private static final long serialVersionUID = 7088465934580581862L;
	
	private Long id;
	private String videoId;
	private String name;
	private PlayListDto playList;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PlayListDto getPlayList() {
		return playList;
	}
	public void setPlayList(PlayListDto playList) {
		this.playList = playList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

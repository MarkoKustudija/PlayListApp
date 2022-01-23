package com.example.MyPlayList2022.ui.request;

import java.util.List;

public class PlayListRequestDetailsModel {
	
	private String name;
	private List<VideoRequestDetailsModel> videos;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<VideoRequestDetailsModel> getVideos() {
		return videos;
	}
	public void setVideos(List<VideoRequestDetailsModel> videos) {
		this.videos = videos;
	}
	
	
	

}

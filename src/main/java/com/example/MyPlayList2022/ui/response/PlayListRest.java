package com.example.MyPlayList2022.ui.response;

import java.util.List;

public class PlayListRest {

	private String playlistId;
	private String name;
	private List<VideoRest> videos;

	public String getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(String playlistId) {
		this.playlistId = playlistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<VideoRest> getVideos() {
		return videos;
	}

	public void setVideos(List<VideoRest> videos) {
		this.videos = videos;
	}

}

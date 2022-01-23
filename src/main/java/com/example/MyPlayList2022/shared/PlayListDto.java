package com.example.MyPlayList2022.shared;


import java.io.Serializable;
import java.util.List;



public class PlayListDto implements Serializable{
	
	
	private static final long serialVersionUID = -5072409824115829937L;
	
	private Long id;
	private String playlistId;
	private String name;
	private List<VideoDto> videos;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

	public List<VideoDto> getVideos() {
		return videos;
	}
	public void setVideos(List<VideoDto> videos) {
		this.videos = videos;
	}
	

	
	
	
	
	

}

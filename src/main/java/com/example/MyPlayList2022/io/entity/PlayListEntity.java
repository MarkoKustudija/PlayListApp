package com.example.MyPlayList2022.io.entity;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "playlist")
public class PlayListEntity implements Serializable{
	
	
	private static final long serialVersionUID = -6496181835481989763L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String playlistId;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "playList", cascade = CascadeType.ALL)
	private List<VideoEntity> videos;
	
	
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

	public List<VideoEntity> getVideos() {
		return videos;
	}
	public void setVideos(List<VideoEntity> videos) {
		this.videos = videos;
	}
	
	
	
	

	
}

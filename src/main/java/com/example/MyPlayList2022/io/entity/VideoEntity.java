package com.example.MyPlayList2022.io.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "videos")
public class VideoEntity  implements Serializable{
	

	private static final long serialVersionUID = -8253963190379636213L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String videoId;
	@Column
	private String name;

	@ManyToOne
	@JoinColumn(name = "playlist_id")
	private PlayListEntity playList;

	

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
	
	public PlayListEntity getPlayList() {
		return playList;
	}

	public void setPlayList(PlayListEntity playList) {
		this.playList = playList;
	}

	

}

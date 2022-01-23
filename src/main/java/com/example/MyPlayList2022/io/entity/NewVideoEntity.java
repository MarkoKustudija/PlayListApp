package com.example.MyPlayList2022.io.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "newVideos")
public class NewVideoEntity implements Serializable{
	
	
	private static final long serialVersionUID = -6220566035469654828L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToOne
	@JoinColumn(name = "playlist_id")
	private PlayListEntity playList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

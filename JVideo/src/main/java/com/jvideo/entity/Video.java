package com.jvideo.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Video {
	int id;
	String youtubeId;
	String title;
	String poster;
	String description;
	Date createDate;
	int viewCount;
	boolean active;
}

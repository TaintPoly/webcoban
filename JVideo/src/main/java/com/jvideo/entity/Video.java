package com.jvideo.entity;

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
	int viewCount;
	boolean active;
}

package com.ssafy.fit.test;

import java.io.IOException;
import java.util.List;

import com.ssafy.fit.model.Video;

public interface VideoDao {
	List<Video> selectVideo() throws IOException;
	
	Video selectVideoByNo(int no);
	
}

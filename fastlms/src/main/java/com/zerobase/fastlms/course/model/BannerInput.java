package com.zerobase.fastlms.course.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BannerInput {
	String bannerName;
	String alterText;
	
    String filename;
    String urlFilename;
    
    String target;
    Integer sortValue;
    Boolean frontYn;
    LocalDateTime regDt;
}

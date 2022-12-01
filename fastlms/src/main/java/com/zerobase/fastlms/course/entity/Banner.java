package com.zerobase.fastlms.course.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Banner {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long no;
	
	String bannerName;
	String alterText;
	
    String filename;
    String urlFilename;
    
    String target;
    Integer sortValue;
    Boolean frontYn;
    LocalDateTime regDt;
}

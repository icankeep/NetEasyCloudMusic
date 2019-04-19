package com.passer.crawl.domain;

import lombok.Data;

/**
* @Description: <p>
* @author: passer<p>
* @version：2019年4月19日 上午8:53:31<p>
*/
@Data
public class Comment {
	private Long time;
	private String content;
	private User user;

}

package com.passer.crawl.domain;

import java.util.List;

import lombok.Data;

/**
 * @ClassName: Comments
 *             <p>
 * 
 * @description:
 *               <p>
 * 
 * @author: passer
 *          <p>
 * 
 * @Date: 2019年3月25日 下午5:26:21
 *        <p>
 */
@Data
public class Comments {

	private List<Comment> hotComments;
	@Data
	public class Comment{
		private Long time;
		private String content;
		private User user;
		@Data
		public class User {
			private Long userId;
			private String nickname;
			private String locationInfo;
			
		}
	}
}

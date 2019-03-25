package com.passer.crawl.test;  
/** 
 * @ClassName: Test<p>

 * @description: <p>

 * @author: passer<p>

 * @Date: 2019年3月25日 下午5:47:14<p>
 */

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.passer.crawl.domain.Comments.Comment;
import com.passer.crawl.extract.CommentExtract;
import com.passer.crawl.extract.SongExtract;

public class CrawlTest {
	@Test
	public void test() throws Exception {
		Long songId = 25488651L;
		List<Comment> hotComments = CommentExtract.extract(songId + "?").getHotComments();
		System.out.println("歌曲名：" + SongExtract.ExtractSongNameById(songId));
		System.out.println("网易云热评：");
		System.out.println("--------------------------");
		for(Comment comment : hotComments) {
			System.out.println("时间:" + new Date(comment.getTime()).toLocaleString());
			System.out.println("用户:" + comment.getUser().getNickname());
			System.out.println("评论:" + comment.getContent());
			System.out.println("--------------------------");
		}
	}
}

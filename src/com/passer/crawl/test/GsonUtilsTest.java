package com.passer.crawl.test;

import java.util.List;

import org.junit.Test;

import com.passer.crawl.domain.Comments;
import com.passer.crawl.domain.Comments.Comment;
import com.passer.crawl.util.GsonUtils;

/** 
 * @ClassName: GsonUtilsTest<p>

 * @description: <p>

 * @author: passer<p>

 * @Date: 2019年3月25日 下午5:43:01<p>
 */
public class GsonUtilsTest {
	@Test
	public void test() {
		String jsonData = "{\r\n" + 
				"  \"isMusician\": false,\r\n" + 
				"  \"userId\": -1,\r\n" + 
				"  \"topComments\": [],\r\n" + 
				"  \"moreHot\": true,\r\n" + 
				"  \"hotComments\": [{\r\n" + 
				"    \"user\": {\r\n" + 
				"      \"locationInfo\": null,\r\n" + 
				"      \"userId\": 31188374,\r\n" + 
				"      \"nickname\": \"若是归来去\",\r\n" + 
				"      \"vipType\": 11,\r\n" + 
				"      \"vipRights\": {\r\n" + 
				"        \"associator\": {\r\n" + 
				"          \"vipCode\": 100,\r\n" + 
				"          \"rights\": true\r\n" + 
				"        },\r\n" + 
				"        \"musicPackage\": null,\r\n" + 
				"        \"redVipAnnualCount\": -1\r\n" + 
				"      },\r\n" + 
				"      \"userType\": 0,\r\n" + 
				"      \"expertTags\": null,\r\n" + 
				"      \"authStatus\": 0,\r\n" + 
				"      \"avatarUrl\": \"http://p1.music.126.net/ikucPPb_dZt233xm-3vaww==/3393092927014246.jpg\",\r\n" + 
				"      \"experts\": null,\r\n" + 
				"      \"remarkName\": null\r\n" + 
				"    },\r\n" + 
				"    \"beReplied\": [],\r\n" + 
				"    \"pendantData\": null,\r\n" + 
				"    \"showFloorComment\": null,\r\n" + 
				"    \"status\": 0,\r\n" + 
				"    \"commentLocationType\": 0,\r\n" + 
				"    \"parentCommentId\": 0,\r\n" + 
				"    \"decoration\": null,\r\n" + 
				"    \"repliedMark\": false,\r\n" + 
				"    \"commentId\": 238472796,\r\n" + 
				"    \"liked\": false,\r\n" + 
				"    \"likedCount\": 106934,\r\n" + 
				"    \"expressionUrl\": null,\r\n" + 
				"    \"time\": 1477836375609,\r\n" + 
				"    \"content\": \"华晨宇，创作界的鬼才！\"\r\n" + 
				"  }],\r\n" + 
				"  \"total\": 68637,\r\n" + 
				"  \"more\": true\r\n" + 
				"}";
		Comments comments = GsonUtils.parseJsonWithGson(jsonData,
				Comments.class);
		List<Comment> hotComment = comments.getHotComments();
		for(Comment comment : hotComment) {
			System.out.println(comment.getTime());
			System.out.println(comment.getContent());
			System.out.println(comment.getUser());
		}
	}
}

package org.springblade.modules.admin.util;

import io.swagger.annotations.ApiParam;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.StringUtil;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScoreUtil {

	public static int getMatch(String userTags,
							   Integer charisma1,
							   Integer extroversion1,
							   Integer energy1,
							   Integer wisdom1,
							   Integer art1,
							   Integer courage1,
							   String nftTags,
							   Integer charisma2,
							   Integer extroversion2,
							   Integer energy2,
							   Integer wisdom2,
							   Integer art2,
							   Integer courage2){
		BigDecimal tagMatch = BigDecimal.ZERO;
		//任意一个为空，则为60
		if(StringUtil.isBlank(userTags) || StringUtil.isBlank(nftTags)){
			tagMatch = new BigDecimal("60");
		}else {

			List<String> tags1 = Arrays.asList(userTags.split(","));
			List<String> tags2 = Arrays.asList(nftTags.split(","));

			//原长度
			int oldSize = tags1.size();
			//去掉交集
			tags1.removeAll(tags2);
			//交集数量
			int intersection = oldSize - tags1.size();
			//并集
			tags1.addAll(tags2);
			//并集长度
			int union = tags1.size();

			tagMatch = new BigDecimal(intersection).multiply(new BigDecimal(40)).divide(new BigDecimal(union),2,BigDecimal.ROUND_HALF_UP);
			tagMatch = tagMatch.add(new BigDecimal(60));
			tagMatch = tagMatch.setScale(0,BigDecimal.ROUND_HALF_UP);
		}


		int diff = Math.abs(charisma1 - charisma2) + Math.abs(extroversion1 - extroversion2) + Math.abs(energy1 - energy2)
			+ Math.abs(wisdom1 - wisdom2) + Math.abs(art1 - art2) + Math.abs(courage1 - courage2);

		BigDecimal divide = new BigDecimal(diff).divide(new BigDecimal("15"), 2, BigDecimal.ROUND_HALF_UP);
		BigDecimal DMatch = new BigDecimal("100").subtract(divide);
		DMatch = DMatch.setScale(0,BigDecimal.ROUND_HALF_UP);

		BigDecimal SoulMatch = DMatch.multiply(new BigDecimal(6));
		SoulMatch = tagMatch.add(SoulMatch);
		SoulMatch =	SoulMatch.divide(new BigDecimal(7),0,BigDecimal.ROUND_HALF_UP);

		return SoulMatch.intValue();
	}

}
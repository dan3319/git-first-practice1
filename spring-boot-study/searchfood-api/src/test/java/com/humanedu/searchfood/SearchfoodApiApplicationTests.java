package com.humanedu.searchfood;

import com.humanedu.searchfood.naver.NaverAPIClient;
import com.humanedu.searchfood.naver.dto.ImageRequestDto;
import com.humanedu.searchfood.naver.dto.ImageResponseDto;
import com.humanedu.searchfood.naver.dto.SearchRegionRequestDto;
import com.humanedu.searchfood.naver.dto.SearchRegionResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SearchfoodApiApplicationTests {

	@Autowired
	private NaverAPIClient naverAPIClient;

	@Test
	void contextLoads() {
	}

	@Test	// 네이버 지역 검색 OpenAPI 테스트
	void naverSearchRegionAPITest(){
		String paramQuery = "커피";

		// 네이버 지역검색 API Call method 테스트
		SearchRegionRequestDto searchRegionRequestDto = new SearchRegionRequestDto();
		searchRegionRequestDto.setQuery(paramQuery);

		SearchRegionResponseDto searchRegionResponseDto
				= naverAPIClient.searchRegion(searchRegionRequestDto);
		System.out.println("네이버 지역검색 OpenAPI response json" + searchRegionResponseDto);
	}

	@Test
	void naverSearchRegionAPITest2(){
		String paramQuery = "감자";

		// 네이버 지역검색 API Call method 테스트 (이미지)
		ImageRequestDto imageRequestDto = new ImageRequestDto();
		imageRequestDto.setQuery(paramQuery);

		ImageResponseDto imageResponseDto
				= naverAPIClient.imageResponse(imageRequestDto);
		System.out.println("네이버 지역검색 OpenAPI response json" + imageResponseDto);

	}
}

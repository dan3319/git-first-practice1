package com.humanedu.searchfood.naver;

import com.humanedu.searchfood.naver.dto.ImageResponseDto;
import com.humanedu.searchfood.naver.dto.ImageRequestDto;
import com.humanedu.searchfood.naver.dto.SearchRegionRequestDto;
import com.humanedu.searchfood.naver.dto.SearchRegionResponseDto;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class NaverAPIClient {
    // 1. 지역검색 API Call method(request dto, response dto)
    public SearchRegionResponseDto searchRegion(
            SearchRegionRequestDto searchRegionRequestDto) {
        // API Call Library -> HttpURLConnection, WebClient, RestTemplate, Retry etc... (여기서는 RestTemplate사용)

        // (3,4) Response 설정, 실제 API Call
        ResponseEntity<SearchRegionResponseDto> responseRestTemplate
                = new RestTemplate().exchange(getURI("/v1/search/local.json", searchRegionRequestDto.getQuery())
                , HttpMethod.GET
                , getHttpEntity()
                , SearchRegionResponseDto.class
        );

        return responseRestTemplate.getBody();
    }

    // 2. 지역 이미지 검색 API Call method(request dto, response dto)
    public ImageResponseDto imageResponse(
            ImageRequestDto imageRequest) {
        // 실제 API Call
        return new RestTemplate()
                .exchange(getURI("/v1/search/image", imageRequest.getQuery())
                        , HttpMethod.GET
                        , getHttpEntity()
                        , ImageResponseDto.class
                ).getBody();

    }

    // 리팩토링(코드를 더 깔끔하게 만들기)
    private HttpHeaders getHttpHeaders(){
        // (1) Header설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", "krwOEyRn4rGHWL1buCts");
        headers.set("X-Naver-Client-Secret", "oqneboAxoz");
        headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
    }

    private URI getURI(String path, String query){
        // (2) Request 설정
        return  UriComponentsBuilder.fromUriString("https://openapi.naver.com") // 호출 할 서버 domain 주소
            .path(path) // 호출 할 서버 path
            .queryParam("query", query) // 호출 할 서버 query string
            //.queryParam("dispaly", 1)
            .encode()   // 한글처리
            .build()
            .toUri();
    }

    private HttpEntity getHttpEntity(){
        return new HttpEntity(getHttpHeaders());
    }
}

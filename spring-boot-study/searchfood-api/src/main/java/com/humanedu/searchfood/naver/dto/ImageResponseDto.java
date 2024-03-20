package com.humanedu.searchfood.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponseDto {
    private String lastBuildDate;
    private Integer total;
    private Integer start;
    private Integer display;
    private List<imageRequestDto> items;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class imageRequestDto{
        private String title;
        private String link;
        private String thumbnail;
        private String sizeheight;
        private String sizewidth;
    }

}

package com.humanedu.searchfood.naver.dto;

import lombok.Getter;
import lombok.Setter;

public class ImageRequestDto {
    @Getter
    @Setter
    private String query;
    private String sort = "random";
    private String filter = "all";
    private Integer display = 1;
    private Integer start = 1;


}

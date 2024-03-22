package com.humanedu.searchfood.controller;

import com.humanedu.searchfood.naver.NaverAPIClient;
import com.humanedu.searchfood.wishlist.WishListDto;
import com.humanedu.searchfood.wishlist.WishListService;
import com.humanedu.searchfood.wishlist.WishListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ApiController {
    @Autowired
    private WishListService wishListService;

    // 1. 검색 API(GET)
    @GetMapping("/search")
    public WishListDto search(@RequestParam String searchQuery) {
        WishListDto wishListDto = wishListService.search(searchQuery);
        return wishListDto;
    }

    // 2. 위시리스트 추가 API(POST)
    @PostMapping("/wishadd")
    public WishListVO wishAdd(@RequestBody WishListDto wishListDto) {

        return wishListService.addWish(wishListDto);
    }

    // 3. 위시리스트 목록 가져오기 API(GET)
    @GetMapping("/wishall")
    public List<WishListVO> wishAll() {
        return wishListService.allWish();
    }

    // 방문횟수 +1
    @PostMapping("/wishvisit/{id}")
    public boolean wishVisit(@PathVariable("id") Integer id) {
        return wishListService.addVisitWish(id);
    }

    // 위시리스트 삭제하기
    @DeleteMapping("/wishdelete")
    public boolean wishdelete(@RequestBody Integer id){
        boolean wishListDto = wishListService.deleteWish(id);
        return wishListDto;
    }
}


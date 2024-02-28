package com.humanedu.starbucks.controller;

import com.humanedu.starbucks.domain.FreeBoardVO;
import com.humanedu.starbucks.service.FreeBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminNoticeController {

    // 공지사항 리스트
    @Autowired
    private FreeBoardService freeBoardService;
    @GetMapping("/adminNoticeList")
    public String adminNoticeList(@RequestParam(value = "search", required = false) String search, Model model) {
        List<FreeBoardVO> freeBoardVOList = freeBoardService.getFreeBoardList(search);

        model.addAttribute("freeBoardVOList", freeBoardVOList);
        model.addAttribute("search", search);
        return "adminNoticeList";
    }

    // 글 작성란
    @GetMapping("/adminNoticeInsertForm")
    public String adminNoticeInsertForm() {
        return "adminNoticeInsertForm";
    }

    // 글 작성 DB로 보내기
    @PostMapping("/adminNoticeInsert")
    public String adminNoticeInsert(
            MultipartFile[] fileContent,
            @RequestParam("writer") String writer,
            @RequestParam("title") String subject,
            @RequestParam("content") String content,
            RedirectAttributes rttr
    ) {
        // 실제 DB에 텍스트 데이터 저장
        int rtn = freeBoardService.insertFreeBoard(writer, subject, content);
        rttr.addFlashAttribute("insertSuccessCount", rtn);

        return "redirect:/adminNoticeList";
    }

    // 글 상세목록 보여주기
    @GetMapping("/adminNoticeUpdateForm")
    public String adminNoticeUpdateForm(@RequestParam("num") int num, Model model) {
        FreeBoardVO freeBoardVO = freeBoardService.selectFreeBoardOne(num);
        model.addAttribute("freeBoard", freeBoardVO);

        freeBoardService.updateViewCount(num);

        return "adminNoticeUpdateForm";
    }

    // 글 수정
    @PostMapping("/adminNoticeUpdate")
    public String adminNoticeUpdate(
            MultipartFile[] fileContent,
            @RequestParam("num") int num,
            @RequestParam("writer") String writer,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("update_date") Date update_date,
            RedirectAttributes rttr
    ) {
        // 파일 업로드 수정 처리
        int rtn = freeBoardService.updateFreeBoard(
                num,
                writer,
                title,
                content,
                update_date
        );
        rttr.addFlashAttribute("updateSuccessCount", rtn);

        return "redirect:/adminNoticeList";
    }

    // 글 삭제
    @PostMapping("/adminNoticeDelete")
    public String adminNoticeDelete(@RequestParam("num") int num, RedirectAttributes rttr) {
        int rtn = freeBoardService.deleteFreeBoard(num);
        rttr.addFlashAttribute("deleteSuccessCount", rtn);

        return "redirect:/adminNoticeList";
    }



}

package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import java.util.List;

@RequestMapping("/replies")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {
    private ReplyService service;

    // 댓글 등록
    @PostMapping(value = "/new",
            //consumes = "application/json",
            produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
        log.info("ReplyVO: " + vo);

        int insertCount = service.register(vo);
        log.info("Reply INSERT COUNT: " + insertCount);

        Integer newRno = service.getCurrVal();
        log.info("Reply new number: " + newRno);

        return insertCount == 1 ? new ResponseEntity<>(newRno.toString(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 댓글 리스트 조회
    @GetMapping(value = "/board/{bno}/page/{page}/pagesize/{pageSize}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<ReplyVO>> getList(
            @PathVariable("page") int page,
            @PathVariable("bno") Long bno,
            @PathVariable("pageSize") int amount
    ) {
        log.info("getList.................");

        Criteria cri = new Criteria(page, amount);
        log.info(cri);

        return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);
    }

    // 댓글 상세 조회
    @GetMapping(value = "/{rno}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) {
        log.info("get: " + rno);

        return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
    }

    // 댓글 삭제
    @DeleteMapping(value = "/{rno}", produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
        log.info("remove: " + rno);

        return service.remove(rno) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 댓글 수정
    @RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH },
            value = "/{rno}",
            produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> modify(
            @RequestBody ReplyVO vo,
            @PathVariable("rno") Long rno
    ) {
        vo.setRno(rno);

        log.info("rno: " + rno);
        log.info("modify: " + vo);

        return service.modify(vo) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


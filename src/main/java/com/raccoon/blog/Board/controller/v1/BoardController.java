package com.raccoon.blog.Board.controller.v1;

import com.raccoon.blog.Board.application.impl.BoardService;
import com.raccoon.blog.Board.domain.Board;
import com.raccoon.blog.Board.dto.BoardDto;
import com.raccoon.blog.Board.dto.PageDto;
import com.raccoon.blog.Board.repository.BoardRepository;
import com.raccoon.blog.Board.vo.PageMaker;
import com.raccoon.blog.Board.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/board/*")
@CrossOrigin
@RestController
@RequiredArgsConstructor
@Log
public class BoardController {
    private final BoardRepository repo;
    private final BoardService boardService;

    @PostMapping("register")
    public ResponseEntity<Board> register(@RequestBody BoardDto boardDto) {
        log.info("hello" + boardDto);

        return new ResponseEntity<>(boardService.register(boardDto.toEntity()), HttpStatus.CREATED);
    }

    @GetMapping("list")
    public ResponseEntity<Page> list(PageDto pageDto) {
        log.info("hello" + pageDto);

        return new ResponseEntity<>(boardService.getList(pageDto), HttpStatus.OK);
    }

    @PostMapping("delete")
    public ResponseEntity<Page> delete(Long bno, PageDto pageDto) {
        log.info("delete..." + bno);

        return new ResponseEntity<>(boardService.delete(bno, pageDto), HttpStatus.OK);
    }

    @PostMapping("modify")
    public ResponseEntity<Page> modify(BoardDto boardDto, PageDto pageDto) {
        log.info("modify..." + boardDto + pageDto);

        return new ResponseEntity<>(boardService.modify(boardDto, pageDto), HttpStatus.OK);
    }

    @GetMapping("/view")
    public ResponseEntity<Board> view(Long bno) {
        log.info("BNO: " + bno);


        return new ResponseEntity<>(boardService.view(bno), HttpStatus.OK);
    }

}

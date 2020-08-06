package com.ssafy.apolio.web;

import com.ssafy.apolio.domain.Board;
import com.ssafy.apolio.domain.BoardSearch;
import com.ssafy.apolio.domain.Comment;
import com.ssafy.apolio.repository.HeartRepository;
import com.ssafy.apolio.service.BoardService;
import com.ssafy.apolio.service.CommentService;
import com.ssafy.apolio.service.HeartService;
import com.ssafy.apolio.service.TagService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {
    private final BoardService boardService;
    private final CommentService commentService;
    private final HeartService heartService;
    private final TagService tagService;

    @Autowired
    private HeartRepository heartRepository;

    @ApiOperation(value = "태그 아이디, 제목, 내용, 이미지를 입력받아서 게시물을 작성한다.", response = String.class)
    @PostMapping(value = "/board")
    public ResponseEntity<String> insertBoard(@RequestBody BoardForm boardForm, @RequestParam("tagId") Long tagId){
        Long check = boardService.Board(boardForm.getUser(), tagId, boardForm.getTitle(), boardForm.getContent(), boardForm.getImg_thumb());
        if(check != 0){
            return new ResponseEntity<String>("board success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("board fail", HttpStatus.NO_CONTENT);
    }
    @ApiOperation(value = "게시물 전체를 조회한다.", response = List.class)
    @GetMapping(value = "/board")
    public ResponseEntity<List<Board>> boardList(){
        List<Board> boards = boardService.findBoardsAll();
        for(Board board : boards){
            System.out.println("게시물 제목 : " + board.getTitle());
            System.out.println("게시물 내용 : " + board.getContent());
            List<Comment> commentList = board.getComments();
            for(Comment comment : commentList){
                System.out.println("게시물 댓글 : " + comment.getContent());
            }
        }
        return new ResponseEntity<List<Board>>(boards, HttpStatus.OK);
    }

    @ApiOperation(value = "태그 이름, 게시물 제목을 입력받아서 해당하는 게시물들을 조회한다.")
    @GetMapping(value = "/board/search")
    public ResponseEntity<List<Board>> boardSearchList(@RequestBody BoardSearch boardSearch){
        List<Board> boards = boardService.findBoards(boardSearch);
        return new ResponseEntity<List<Board>>(boards, HttpStatus.OK);
    }

    @ApiOperation(value = "게시물 번호를 입력받아 해당하는 게시물을 조회한다.", response = Board.class)
    @GetMapping(value = "/board/{id}")
    public ResponseEntity<Board> boardDetail(@PathVariable Long id){
        Board board = boardService.findBoard(id);
        System.out.println(board.getTitle());
//        for(Comment c : board.getComments()){
//            System.out.println("댓글 작성자: " + c.getUser().getUsername());
//            System.out.println("댓글 내용: " + c.getContent());
//        }
        System.out.println(board.getContent());
        return new ResponseEntity<Board>(board, HttpStatus.OK);
    }
}

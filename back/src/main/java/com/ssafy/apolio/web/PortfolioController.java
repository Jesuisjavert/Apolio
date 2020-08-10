package com.ssafy.apolio.web;


import com.ssafy.apolio.domain.Portfolio;
import com.ssafy.apolio.service.PortfolioService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PortfolioController {

    private final PortfolioService portfolioService;

    @ApiOperation(value = "새로운 포트폴리오 게시물을 입력한다.", response = String.class)
    @PostMapping("/portfolio")
    public ResponseEntity<String> insertPortfolio(PortfolioForm portfolioForm) throws IOException {
        //Long check = portfolioService.portfolio(portfolio.getTitle(), portfolio.getContent(), portfolio.getImg());
        Long check = 0L;
        if(portfolioForm.getUploadFile() == null){
            check = portfolioService.portfolio(portfolioForm.getTitle(), portfolioForm.getContent(), portfolioForm.getImg());
        }else{
            String fileName = null;
            MultipartFile uploadFile = portfolioForm.getUploadFile();
            if(!uploadFile.isEmpty()){
                String origin_filename = uploadFile.getOriginalFilename();
                System.out.println("origin name:" + origin_filename);
                fileName = origin_filename;
                System.out.println("file name: " + fileName);
                uploadFile.transferTo(new File("C:/apolio_file/" + fileName));
            }

            check = portfolioService.portfolioWithFile(portfolioForm.getTitle(), portfolioForm.getContent(), portfolioForm.getImg(), fileName);
        }
        if(check != 0){
            return new ResponseEntity<String>("portfolio insert success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("portfolio insert fail", HttpStatus.NO_CONTENT);
    }
    @ApiOperation(value = "포트폴리오 게시물 전체를 조회한다.", response = List.class)
    @GetMapping("/portfolio")
    public ResponseEntity<List<Portfolio>> findPortfolioAll(){
        List<Portfolio> portfolios = portfolioService.searchAll();
        return new ResponseEntity<List<Portfolio>>(portfolios, HttpStatus.OK);
    }
    @ApiOperation(value = "게시물 번호로 포트폴리오를 조회한다.", response = Portfolio.class)
    @GetMapping("/portfolio/{portfolio_id}")
    public ResponseEntity<Portfolio> findPortfolioById(@PathVariable Long portfolio_id){
        Portfolio portfolio = portfolioService.searchPortfolio(portfolio_id);
        return new ResponseEntity<Portfolio>(portfolio, HttpStatus.OK);
    }

    @ApiOperation(value = "게시물 번호에 해당하는 포트폴리오를 받아서 수정한다.", response = String.class)
    @PutMapping("/portfolio/{portfolio_id}")
    public ResponseEntity<String> updatePortfolio(@RequestBody Portfolio portfolio){
        int check = portfolioService.updatePortfolio(portfolio);
        if(check != 0){
            return new ResponseEntity<String>("success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "게시물 번호로 포트폴리오를 삭제한다.", response = String.class)
    @DeleteMapping("/portfolio/{portfolio_id}")
    public ResponseEntity<String> deletePortfolioById(@PathVariable Long portfolio_id){
        int check = portfolioService.deletePortfolio(portfolio_id);
        if(check != 0){
            return new ResponseEntity<String>("success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
    }




}

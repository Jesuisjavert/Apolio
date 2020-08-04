package com.ssafy.apolio.web;


import com.ssafy.apolio.domain.Portfolio;
import com.ssafy.apolio.service.PortfolioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @ApiOperation(value = "새로운 포트폴리오 게시물을 입력한다.", response = String.class)
    @PostMapping("/portfolio")
    public ResponseEntity<String> insertPortfolio(@RequestBody Portfolio portfolio){
        Long check = portfolioService.portfolio(portfolio.getTitle(), portfolio.getContent(), portfolio.getImg());
        if(check != 0){
            return new ResponseEntity<String>("portfolio insert success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("portfolio insert fail", HttpStatus.NO_CONTENT);
    }
    @ApiOperation(value = "포트폴리오 게시물 전체를 조회한다.", response = List.class)
    @GetMapping("/portfolio/all")
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

package com.ssafy.apolio.web;

import com.ssafy.apolio.dto.TrendsDto;
import io.swagger.annotations.ApiOperation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
public class HomeController {
    @ApiOperation(value = "최신 IT 동향 정보를 크롤링하여서 정보들을 메인 화면에 띄어준다", response = TrendsDto.class)
    @GetMapping("/")
    public ResponseEntity<TrendsDto> getTrends() throws IOException {
        TrendsDto trendsDto = new TrendsDto();
        Document doc = Jsoup.connect("https://www.itfind.or.kr/trend/trend/organScrap/list.do").get();
        Elements items1 = doc.select(".tit a");
        Elements items2 = doc.select(".writer2");
        Elements items3 = doc.select("date");
        for(Element e : items1){
            System.out.println("동향 제목: " + e.text());

        }
        trendsDto.setTitle(items1.text());
        trendsDto.setWriter(items2.text());
        trendsDto.setCreate_date(items3.text());
        return new ResponseEntity<TrendsDto>(trendsDto, HttpStatus.OK);
    }
}

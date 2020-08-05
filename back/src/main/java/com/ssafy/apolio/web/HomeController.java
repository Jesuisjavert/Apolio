package com.ssafy.apolio.web;

import com.ssafy.apolio.dto.TrendsDto;
import io.swagger.annotations.ApiOperation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/api")
@RestController
public class HomeController {
    @ApiOperation(value = "최신 IT 동향 정보를 크롤링 하여서 제목과 이미지를 메인 화면에 보여준다.", response = TrendsDto.class)
    @GetMapping("/")
    public ResponseEntity<List<TrendsDto>> getTrends() throws IOException {
        List<TrendsDto> trendsDtoList = new ArrayList<>();
        Document doc = Jsoup.connect("https://www.itfind.or.kr/trend/trend/bestData/list.do").get();
        Elements item = doc.select("dl");
        for(Element e : item){
            TrendsDto trendsDto = new TrendsDto();
            String title = e.select("a").text();
            Element content = e.select("a").first();
            String content_url = content.attr("href");
            Element img_element = e.select("img").first();
            String img_url = "https://www.itfind.or.kr" + img_element.attr("src");
            trendsDto.setTitle(title);
            trendsDto.setContent_url(content_url);
            trendsDto.setImg_url(img_url);
            trendsDtoList.add(trendsDto);
        }

        return new ResponseEntity<List<TrendsDto>>(trendsDtoList, HttpStatus.OK);
    }
}

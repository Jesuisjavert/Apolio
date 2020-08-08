package com.ssafy.apolio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;


@Entity
@Getter
@Setter
public class TagBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_board_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "tag_id")
    @JsonBackReference
    private Tag tag;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "board_id")
    @JsonBackReference
    private Board board;

    //==생성 메서드==//
    public static TagBoard createTagBoard(Tag tag) {
        TagBoard tagBoard = new TagBoard();
        tagBoard.setTag(tag);

        return tagBoard;
    }
}

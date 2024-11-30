package com.example.myProject.repository;


import com.example.myProject.domain.Board;
import com.example.myProject.domain.Enum.StatusYn;
import com.example.myProject.domain.QBoard;
import com.example.myProject.dto.request.BoardSearchRequestDto;
import com.example.myProject.dto.response.board.BoardListResponseDto;
import com.example.myProject.repository.custom.CustomBoardRepository;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.myProject.domain.QBoard.*;

@Repository
public class BoardRepositoryImpl extends QuerydslRepositorySupport implements CustomBoardRepository {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    // 생성자를 통해 도메인 클래스를 부모 클래스에 전달애햐 함
    public BoardRepositoryImpl() {
        super(Board.class);
    }

    @Override
    public Page<BoardListResponseDto> getBoardList(BoardSearchRequestDto requestDto) {
        PageRequest pageRequest = PageRequest.of(requestDto.getPage(), requestDto.getPerPageSize());

        List<BoardListResponseDto> query = jpaQueryFactory
                .select(Projections.fields(
                        BoardListResponseDto.class
                        , board.boardId.as("boardId")
                        , board.title.as("title")
                        , board.member.name.as("writer")
                        , board.viewCount.as("viewCount")
                        , formatLocalDateTime(board.createdAt).as("createdAt")
                ))
                .from(board)
                .where(
                        board.delYn.eq(StatusYn.N.getStatus())
                        .and(
                                searchTypeContains(
                                    requestDto.getSearchType(),
                                    requestDto.getSearchValue()
                                )
                        )
                )
                .orderBy(board.createdAt.desc())
                .offset(pageRequest.getOffset())
                .limit(requestDto.getPageSize())
                .fetch();

        long count = jpaQueryFactory.select(board.count())
                .from(board)
                .where(board.delYn.eq(StatusYn.N.getStatus()))
                .fetchOne();

        return new PageImpl<>(query, pageRequest, count);
    }

    private static BooleanExpression searchTypeContains(String searchType, String searchValue) {
        if (StringUtils.hasText(searchType)) {
            return switch (searchValue) {
                case "title" -> board.title.contains(searchType);
                case "writer" -> board.member.name.contains(searchType);
                case "contents" -> board.contents.contains(searchType);
                default -> board.title.contains(searchValue)
                        .or(board.contents.contains(searchValue))
                        .or(board.member.name.contains(searchValue));
            };
        }
        return null;
    }

    private static StringTemplate formatLocalDateTime(DateTimePath dateTimePath) {
        return Expressions.stringTemplate(
                "DATE_FORMAT({0}, {1})",
                dateTimePath,
                ConstantImpl.create("%Y-%m-%d %H:%i")
        );
    }
}

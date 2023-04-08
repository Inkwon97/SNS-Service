package com.project.snsservice.service;

import com.project.snsservice.doamin.Document;
import com.project.snsservice.doamin.type.SearchType;
import com.project.snsservice.doamin.dto.DocumentDto;
import com.project.snsservice.repository.DocumentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.mockito.BDDMockito.*;

@Disabled
@DisplayName("비즈니스 - 검색")
@ExtendWith(MockitoExtension.class)
class DocumentServiceTest {

    @InjectMocks
    private DocumentService sut;

    @Mock
    private DocumentRepository documentRepository;

    @DisplayName("게시글을 검색하면 게시글 리스트를 반환한다.")
    @Test
    public void 게시글_검색() throws Exception {
        //given

        //when
        Page<DocumentDto> documents = sut.searchDocuments(SearchType.TITLE, "search keyword");

        //then
        Assertions.assertThat(documents).isNotNull();
    }

    @DisplayName("게시글을 조회하면 게시글을 반환한다.")
    @Test
    public void 게시글_조회() throws Exception {
        //given
        long documentId = 1L;

        //when
        DocumentDto dto = sut.searchDocument(documentId);

        //then
        Assertions.assertThat(dto).isNotNull();
    }

    @DisplayName("게시글의 ID와 수정 정보를 입력하면, 게시글을 수정한다")
    @Test
    public void 게시글_수정() throws Exception {
        //given
        given(documentRepository.save(any(Document.class))).willReturn(null);

        //when
        sut.updateArticle(1L, DocumentDto.of("title", "content", "#java"));

        //then
        then(documentRepository).should().save(any(Document.class));
    }

    @DisplayName("게시글의 ID를 입력하면, 게시글을 삭제한다")
    @Test
    public void 게시글_삭제() throws Exception {
        //given
        willDoNothing().given(documentRepository).delete(any(Document.class));

        //when
        sut.deleteDocument(1L);

        //then
        then(documentRepository).should().delete(any(Document.class));
    }

}
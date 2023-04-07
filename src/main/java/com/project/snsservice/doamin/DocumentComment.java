package com.project.snsservice.doamin;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class DocumentComment extends AuditingFields{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false) @JoinColumn(name = "member_id")
    private Member member; // 유저 정보

    @ManyToOne(optional = false) @JoinColumn(name = "document_id") @Column(nullable = false)
    private Document document; // 게시글 ID

    private Long parentCommentId;
    @ToString.Exclude
    @Lob
    @Column(nullable = false)
    private String content; // 본문

    @OrderBy("createdAt ASC")
    @OneToMany(mappedBy = "parentCommentId", cascade = CascadeType.ALL)
    private Set<DocumentComment> childComments = new LinkedHashSet<>();

    private DocumentComment(Member member, Document document, Long parentCommentId, String content) {
        this.member = member;
        this.document = document;
        this.parentCommentId = parentCommentId;
        this.content = content;
    }

    public static DocumentComment of(Member member, Document document, Long parentCommentId, String content) {
        return new DocumentComment(member, document, parentCommentId, content);
    }

    public static DocumentComment of(Member member, Document document, String content) {
        return new DocumentComment(member, document, null, content);
    }

    public void addChildComment(DocumentComment child) {
        child.parentCommentId = this.parentCommentId;
        this.childComments.add(child);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentComment documentComment = (DocumentComment) o;
        return Objects.equals(id, documentComment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package com.project.snsservice.doamin;

import lombok.*;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Document extends AuditingFields{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @JoinColumn(name = "member_id")
    @ManyToOne
    private Member member;

    @Column(nullable = false)
    private String title; // 제목

    @Column(nullable = true, length = 10000)
    private String content; // 본문

    // hashtag

    // comment
    @ToString.Exclude
    @OrderBy("createdAt DESC")
    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    private Set<DocumentComment> documentComments = new LinkedHashSet<>();


    private Document(Member member, String title, String content) {

        this.member = member;
        this.title = title;
        this.content = content;
    }

    public static Document of(Member member, String title, String content) {
        return new Document(member, title, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(id, document.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

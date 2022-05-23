package qna.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "DELETE_HISTORY")
public class DeleteHistory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "CONTENT_TYPE")
    private ContentType contentType;
    @Column(name = "CONTENT_ID")
    private Long contentId;
    @ManyToOne
    @JoinColumn(name = "DELETED_BY_ID", foreignKey = @ForeignKey(name = "fk_delete_history_to_user"))
    private User deletedByUser;
    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate = LocalDateTime.now();

    protected DeleteHistory() {
    }

    public DeleteHistory(ContentType contentType, Long contentId, User deletedByUser, LocalDateTime createDate) {
        this.contentType = contentType;
        this.contentId = contentId;
        this.deletedByUser = deletedByUser;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteHistory that = (DeleteHistory) o;
        return Objects.equals(id, that.id) &&
                contentType == that.contentType &&
                Objects.equals(contentId, that.contentId) &&
                Objects.equals(deletedByUser, that.deletedByUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contentType, contentId, deletedByUser);
    }

    @Override
    public String toString() {
        return "DeleteHistory{" +
                "id=" + id +
                ", contentType=" + contentType +
                ", contentId=" + contentId +
                ", deletedByUser=" + deletedByUser +
                ", createDate=" + createDate +
                '}';
    }
}

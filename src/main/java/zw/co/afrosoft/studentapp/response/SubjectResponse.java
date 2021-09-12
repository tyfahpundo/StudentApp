package zw.co.afrosoft.studentapp.response;

import lombok.Getter;
import lombok.Setter;
import zw.co.afrosoft.studentapp.domain.Subject;

@Getter
@Setter
public class SubjectResponse {
    private Long id;
    private String subjectName;
    private Double marksObtained;

    public SubjectResponse(Subject subject){
        this.id = subject.getId();
        this.subjectName = subject.getSubjectName();
        this.marksObtained = subject.getMarksObtained();
    }
}

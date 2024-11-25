package com.example.tangthu_app_be.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "adn_subject_attr_mapping")
public class AdnSubjectMapping extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private String id;

    @Column(name = "SUBJECT_CODE")
    private String subjectCode;

    @Column(name = "VALUE_LABEL")
    private String valueLabel;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "VALUE_CODE")
    private String valueCode;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "OPTION_1")
    private String option1;
    @Column(name = "OPTION_2")
    private String option2;
    @Column(name = "OPTION_3")
    private String option3;
    @Column(name = "OPTION_4")
    private String option4;
    @Column(name = "OPTION_5")
    private String option5;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private AdnSubjectProvisional subjectProvisional;
}

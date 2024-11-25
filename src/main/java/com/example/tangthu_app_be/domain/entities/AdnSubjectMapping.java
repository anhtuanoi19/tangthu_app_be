package com.example.tangthu_app_be.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;


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

    public AdnSubjectMapping(LocalDateTime createdDate, LocalDateTime lastModifiedDate, String createdBy, String lastModifiedBy, Integer deleted, String deletedBy, LocalDateTime deletedDate) {
        super(createdDate, lastModifiedDate, createdBy, lastModifiedBy, deleted, deletedBy, deletedDate);
    }

    public AdnSubjectMapping(LocalDateTime createdDate, LocalDateTime lastModifiedDate, String createdBy, String lastModifiedBy, Integer deleted, String deletedBy, LocalDateTime deletedDate, String id, String subjectCode, String valueLabel, String value, String valueCode, Integer status, String option1, String option2, String option3, String option4, String option5, AdnSubjectProvisional subjectProvisional) {
        super(createdDate, lastModifiedDate, createdBy, lastModifiedBy, deleted, deletedBy, deletedDate);
        this.id = id;
        this.subjectCode = subjectCode;
        this.valueLabel = valueLabel;
        this.value = value;
        this.valueCode = valueCode;
        this.status = status;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.subjectProvisional = subjectProvisional;
    }

    public String getId() {
        return id;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getValueLabel() {
        return valueLabel;
    }

    public String getValue() {
        return value;
    }

    public String getValueCode() {
        return valueCode;
    }

    public Integer getStatus() {
        return status;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getOption5() {
        return option5;
    }

    public AdnSubjectProvisional getSubjectProvisional() {
        return subjectProvisional;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public void setValueLabel(String valueLabel) {
        this.valueLabel = valueLabel;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setValueCode(String valueCode) {
        this.valueCode = valueCode;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
    }

    public void setSubjectProvisional(AdnSubjectProvisional subjectProvisional) {
        this.subjectProvisional = subjectProvisional;
    }
}

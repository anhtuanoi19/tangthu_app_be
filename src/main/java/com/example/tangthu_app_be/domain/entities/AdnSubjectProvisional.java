package com.example.tangthu_app_be.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "adn_subject_provisional")
public class AdnSubjectProvisional extends BaseEntity {

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "ETHNICITY")
    private String ethnicity;

    @Column(name = "IDENTIFICATION_NUMBER")
    private String identificationNumber;

    @Column(name = "INVESTIGATION_CODE")
    private String investigationCode;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "PRECINCT")
    private String precinct;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "DISTRICT")
    private String district;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "BARCODE")
    private String barcode;

    @Column(name = "MANAGER_BY")
    private String managerBy;

    @Column(name = "MANAGER_INVESTIGATION")
    private String managerInvestigation;

    @Column(name = "OPTION_VALUE1")
    private String optionValue1;

    @Column(name = "OPTION_VALUE2")
    private String optionValue2;

    @Column(name = "OPTION_VALUE3")
    private String optionValue3;

    @Column(name = "OPTION_VALUE4")
    private String optionValue4;

    @Column(name = "OPTION_VALUE5")
    private String optionValue5;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "FULLNAMEVN")
    private String fullNameVn;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private String id;

    @Column(name = "AREA_NAME")
    private String areaName;

    @Column(name = "PROVINCE_NAME")
    private String provinceName;

    @Column(name = "DISTRICT_NAME")
    private String districtName;

    @Column(name = "ATTRIBUTE_CODE")
    private String attributeCode;

    @Column(name = "VALUE_CODE")
    private String valueCode;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PRECINCT_NAME")
    private String precinctName;

    @Column(name = "SUBJECT_KEY")
    private String subjectKey;

    @Column(name = "CCCD")
    private String cccd;

    @Column(name = "BIRTH_DATE")
    private String birthDate;

    @OneToMany(mappedBy = "subjectProvisional", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<AdnSubjectMapping> adnSubjectMappings;
    @Column(name = "INVESTIGATION_REQUEST_CODE")
    private String investigationRequestCode;

    @Column(name = "VALI_BARCODE")
    private String valiBarcode;

    @Column(name = "LO_BARCODE")
    private String loBarcode;
}

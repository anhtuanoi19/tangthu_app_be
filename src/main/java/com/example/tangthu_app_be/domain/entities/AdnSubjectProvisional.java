package com.example.tangthu_app_be.domain.entities;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

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

    @Column(name = "DELETED")
    private Integer deleted;

    @Column(name = "DELETED_DATE")
    private LocalDateTime deletedDate;

    @Column(name = "DELETED_BY")
    private String deletedBy;

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

    public AdnSubjectProvisional(LocalDateTime createdDate, LocalDateTime lastModifiedDate, String createdBy, String lastModifiedBy, Integer deleted, String deletedBy, LocalDateTime deletedDate) {
        super(createdDate, lastModifiedDate, createdBy, lastModifiedBy, deleted, deletedBy, deletedDate);
    }

    public AdnSubjectProvisional(LocalDateTime createdDate, LocalDateTime lastModifiedDate, String createdBy, String lastModifiedBy, Integer deleted, String deletedBy, LocalDateTime deletedDate, String lastName, String middleName, String firstName, String gender, String ethnicity, String identificationNumber, String investigationCode, String phoneNumber, String precinct, String province, String district, Integer status, String barcode, String managerBy, String managerInvestigation, String optionValue1, String optionValue2, String optionValue3, String optionValue4, String optionValue5, Integer deleted1, LocalDateTime deletedDate1, String deletedBy1, String fullName, String fullNameVn, String id, String areaName, String provinceName, String districtName, String attributeCode, String valueCode, String address, String precinctName, String subjectKey, String cccd, String birthDate, List<AdnSubjectMapping> adnSubjectMappings, String investigationRequestCode, String valiBarcode, String loBarcode) {
        super(createdDate, lastModifiedDate, createdBy, lastModifiedBy, deleted, deletedBy, deletedDate);
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
        this.gender = gender;
        this.ethnicity = ethnicity;
        this.identificationNumber = identificationNumber;
        this.investigationCode = investigationCode;
        this.phoneNumber = phoneNumber;
        this.precinct = precinct;
        this.province = province;
        this.district = district;
        this.status = status;
        this.barcode = barcode;
        this.managerBy = managerBy;
        this.managerInvestigation = managerInvestigation;
        this.optionValue1 = optionValue1;
        this.optionValue2 = optionValue2;
        this.optionValue3 = optionValue3;
        this.optionValue4 = optionValue4;
        this.optionValue5 = optionValue5;
        this.deleted = deleted1;
        this.deletedDate = deletedDate1;
        this.deletedBy = deletedBy1;
        this.fullName = fullName;
        this.fullNameVn = fullNameVn;
        this.id = id;
        this.areaName = areaName;
        this.provinceName = provinceName;
        this.districtName = districtName;
        this.attributeCode = attributeCode;
        this.valueCode = valueCode;
        this.address = address;
        this.precinctName = precinctName;
        this.subjectKey = subjectKey;
        this.cccd = cccd;
        this.birthDate = birthDate;
        this.adnSubjectMappings = adnSubjectMappings;
        this.investigationRequestCode = investigationRequestCode;
        this.valiBarcode = valiBarcode;
        this.loBarcode = loBarcode;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public void setInvestigationCode(String investigationCode) {
        this.investigationCode = investigationCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPrecinct(String precinct) {
        this.precinct = precinct;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setManagerBy(String managerBy) {
        this.managerBy = managerBy;
    }

    public void setManagerInvestigation(String managerInvestigation) {
        this.managerInvestigation = managerInvestigation;
    }

    public void setOptionValue1(String optionValue1) {
        this.optionValue1 = optionValue1;
    }

    public void setOptionValue2(String optionValue2) {
        this.optionValue2 = optionValue2;
    }

    public void setOptionValue3(String optionValue3) {
        this.optionValue3 = optionValue3;
    }

    public void setOptionValue4(String optionValue4) {
        this.optionValue4 = optionValue4;
    }

    public void setOptionValue5(String optionValue5) {
        this.optionValue5 = optionValue5;
    }

    @Override
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public void setDeletedDate(LocalDateTime deletedDate) {
        this.deletedDate = deletedDate;
    }

    @Override
    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setFullNameVn(String fullNameVn) {
        this.fullNameVn = fullNameVn;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public void setAttributeCode(String attributeCode) {
        this.attributeCode = attributeCode;
    }

    public void setValueCode(String valueCode) {
        this.valueCode = valueCode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPrecinctName(String precinctName) {
        this.precinctName = precinctName;
    }

    public void setSubjectKey(String subjectKey) {
        this.subjectKey = subjectKey;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setAdnSubjectMappings(List<AdnSubjectMapping> adnSubjectMappings) {
        this.adnSubjectMappings = adnSubjectMappings;
    }

    public void setInvestigationRequestCode(String investigationRequestCode) {
        this.investigationRequestCode = investigationRequestCode;
    }

    public void setValiBarcode(String valiBarcode) {
        this.valiBarcode = valiBarcode;
    }

    public void setLoBarcode(String loBarcode) {
        this.loBarcode = loBarcode;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public String getInvestigationCode() {
        return investigationCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPrecinct() {
        return precinct;
    }

    public String getProvince() {
        return province;
    }

    public String getDistrict() {
        return district;
    }

    public Integer getStatus() {
        return status;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getManagerBy() {
        return managerBy;
    }

    public String getManagerInvestigation() {
        return managerInvestigation;
    }

    public String getOptionValue1() {
        return optionValue1;
    }

    public String getOptionValue2() {
        return optionValue2;
    }

    public String getOptionValue3() {
        return optionValue3;
    }

    public String getOptionValue4() {
        return optionValue4;
    }

    public String getOptionValue5() {
        return optionValue5;
    }

    @Override
    public Integer getDeleted() {
        return deleted;
    }

    @Override
    public LocalDateTime getDeletedDate() {
        return deletedDate;
    }

    @Override
    public String getDeletedBy() {
        return deletedBy;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFullNameVn() {
        return fullNameVn;
    }

    public String getId() {
        return id;
    }

    public String getAreaName() {
        return areaName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getAttributeCode() {
        return attributeCode;
    }

    public String getValueCode() {
        return valueCode;
    }

    public String getAddress() {
        return address;
    }

    public String getPrecinctName() {
        return precinctName;
    }

    public String getSubjectKey() {
        return subjectKey;
    }

    public String getCccd() {
        return cccd;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public List<AdnSubjectMapping> getAdnSubjectMappings() {
        return adnSubjectMappings;
    }

    public String getInvestigationRequestCode() {
        return investigationRequestCode;
    }

    public String getValiBarcode() {
        return valiBarcode;
    }

    public String getLoBarcode() {
        return loBarcode;
    }
}

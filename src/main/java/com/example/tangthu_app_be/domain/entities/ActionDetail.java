package com.example.tangthu_app_be.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="action_detail")
public class ActionDetail extends BaseEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="ID")
   private Long id;

   @Column(name="COL_NAME")
   private String colName;

   @Column(name="COL_DISPLAY_NAME")
   private String colDisplayName;

   @Column(name="OLD_VALUE")
   private String oldValue;

   @Column(name="NEW_VALUE")
   private String newValue;

   @Column(name="TABLE_NAME")
   private String tableName;

   @Column(name="OLD_DISPLAY_VALUE")
   private String oldDisplayValue;

   @Column(name="NEW_DISPLAY_VALUE")
   private String newDisplayValue;

   @Column(name="ISSUE_DATE")
   private Date issueDate;

   @Column(name="STAFF_ID")
   private Long staffId;

   @Column(name="TABLE_DISPLAY_NAME")
   private String tableDisplayName;

   @Column(name="ROW_ID")
   private Long rowId;

   @Column(name="PARENT_COLUMN_OLD_VALUE")
   private String parentColumnOldValue;

   @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
   @JoinColumn(name = "ACTION_AUDIT_ID", referencedColumnName = "id")
   private ActionAudit actionAudit;

   @Column(name="PRACTICE_COLUMN_NEW_VALUE")
   private String practiceColumnNewValue;

   @Column(name="ACTION_TYPE")
   private String actionType;

   @Column(name="STATUS")
   private Integer status;

}

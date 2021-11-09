package models;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = JpaConst.TABLE_CLI)
@NamedQueries({
    @NamedQuery(
            name = JpaConst.Q_CLI_GET_ALL,
            query = JpaConst.Q_CLI_GET_ALL_DEF),
    @NamedQuery(
            name = JpaConst.Q_CLI_COUNT,
            query = JpaConst.Q_CLI_COUNT_DEF),
    @NamedQuery(
            name = JpaConst.Q_CLI_GET_ID,
            query = JpaConst.Q_CLI_GET_ID_DEF)
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {

    //id
    @Id
    @Column(name = JpaConst.CLI_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    //お客様番号
    @Column(name = JpaConst.CLI_COL_CODE, nullable = false, unique = true)
    private String code;


    //会社名
    @Column(name = JpaConst.CLI_COL_NAME, nullable = false)
    private String name;

    //事業内容
    @Column(name = JpaConst.CLI_COL_CONTENT, nullable = false)
    private String content;


    //担当者名
    @ManyToOne
    @JoinColumn(name = JpaConst.CLI_COL_EMP, nullable = false)
    private Employee employeeRepresentative;


    //月間平均売上
    @Column(name = JpaConst.CLI_COL_AVE_SALE, nullable = false)
    private String average_sales;

    //メモ
    @Column(name = JpaConst.CLI_COL_TEXT, nullable = false)
    private String text;


    //作成日
    @Column(name = JpaConst.CLI_COL_CREATED_AT, nullable = false)
    private LocalDateTime createdAt;


    //更新日
    @Column(name = JpaConst.CLI_COL_UPDATED_AT, nullable = false)
    private LocalDateTime updatedAt;



}
package models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = JpaConst.TABLE_PRO)
@NamedQueries({
    @NamedQuery(
            name = JpaConst.Q_PRO_GET_ALL,
            query = JpaConst.Q_PRO_GET_ALL_DEF),
    @NamedQuery(
            name = JpaConst.Q_PRO_COUNT,
            query = JpaConst.Q_PRO_COUNT_DEF),
    @NamedQuery(
            name = JpaConst.Q_PRO_GET_ALL_MINE,
            query = JpaConst.Q_PRO_GET_ALL_MINE_DEF),
    @NamedQuery(
            name = JpaConst.Q_PRO_COUNT_ALL_MINE,
            query = JpaConst.Q_PRO_COUNT_ALL_MINE_DEF)
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Progress {



    @Id
    @Column(name = JpaConst.PRO_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = JpaConst.PRO_COL_EMP, nullable = false)
    private Employee employee;


    @ManyToOne
    @JoinColumn(name = JpaConst.PRO_COL_CLI, nullable = false)
    private Client client;


    @ManyToOne
    @JoinColumn(name = JpaConst.PRO_COL_OPP, nullable = false)
    private Opportunity opportunity;


    @Column(name = JpaConst.PRO_COL_DATE, nullable = false)
    private LocalDate progressDate;


    @Column(name = JpaConst.PRO_COL_ITEM, nullable = false)
    private String item;


    @Column(name = JpaConst.PRO_COL_PROSPECT, nullable = false)
    private String prospect;


    @Column(name = JpaConst.PRO_COL_STATUS, nullable = false)
    private String status;


    @Lob
    @Column(name = JpaConst.PRO_COL_CONTENT, nullable = false)
    private String content;


    @Column(name = JpaConst.PRO_COL_CREATED_AT, nullable = false)
    private LocalDateTime createdAt;



    @Column(name = JpaConst.PRO_COL_UPDATED_AT, nullable = false)
    private LocalDateTime updatedAt;










}

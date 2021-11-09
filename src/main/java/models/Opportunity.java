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

@Table(name = JpaConst.TABLE_OPP)
@NamedQueries({
    @NamedQuery(
            name = JpaConst.Q_OPP_GET_ALL,
            query = JpaConst.Q_OPP_GET_ALL_DEF),
    @NamedQuery(
            name = JpaConst.Q_OPP_COUNT,
            query = JpaConst.Q_OPP_COUNT_DEF),
    @NamedQuery(
            name = JpaConst.Q_OPP_GET_ALL_MINE,
            query = JpaConst.Q_OPP_GET_ALL_MINE_DEF),
    @NamedQuery(
            name = JpaConst.Q_OPP_COUNT_ALL_MINE,
            query = JpaConst.Q_OPP_COUNT_ALL_MINE_DEF)
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Opportunity {

    @Id
    @Column(name = JpaConst.OPP_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = JpaConst.OPP_COL_CLI, nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = JpaConst.OPP_COL_EMP, nullable = false)
    private Employee employee;


    @Column(name = JpaConst.OPP_COL_TITLE,  nullable = false)
    private String title;



    @Column(name = JpaConst.OPP_COL_CREATED_AT, nullable = false)
    private LocalDateTime createdAt;



    @Column(name = JpaConst.OPP_COL_UPDATED_AT, nullable = false)
    private LocalDateTime updatedAt;

}
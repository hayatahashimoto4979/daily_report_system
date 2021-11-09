package services;

import java.time.LocalDateTime;
import java.util.List;

import actions.views.EmployeeConverter;
import actions.views.EmployeeView;
import actions.views.OpportunityConverter;
import actions.views.OpportunityView;
import constants.JpaConst;
import models.Opportunity;
import models.validators.OpportunityValidator;

public class OpportunityService extends ServiceBase {

    public List<OpportunityView> getMinePerPage(EmployeeView employee, int page) {

        List<Opportunity> opportunities = em.createNamedQuery(JpaConst.Q_OPP_GET_ALL_MINE, Opportunity.class)
                .setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                .setMaxResults(JpaConst.ROW_PER_PAGE)
                .getResultList();
        return OpportunityConverter.toViewList(opportunities);
    }

    public long countAllMine(EmployeeView employee) {

        long count = (long) em.createNamedQuery(JpaConst.Q_OPP_COUNT_ALL_MINE, Long.class)
                .setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
                .getSingleResult();

        return count;
    }

    public List<OpportunityView> getAllPerPage(int page) {

        List<Opportunity> opportunities = em.createNamedQuery(JpaConst.Q_OPP_GET_ALL, Opportunity.class)
                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                .setMaxResults(JpaConst.ROW_PER_PAGE)
                .getResultList();
        return OpportunityConverter.toViewList(opportunities);
    }

    public long countAll() {
        long opportunities_count = (long) em.createNamedQuery(JpaConst.Q_OPP_COUNT, Long.class)
                .getSingleResult();
        return opportunities_count;
    }

    public OpportunityView findOne(int id) {
        return OpportunityConverter.toView(findOneInternal(id));
    }

    public List<String> create(OpportunityView ov) {
        List<String> errors = OpportunityValidator.validate(ov);
        if (errors.size() == 0) {
            LocalDateTime ldt = LocalDateTime.now();
            ov.setCreatedAt(ldt);
            ov.setUpdatedAt(ldt);
            createInternal(ov);
        }

        return errors;
    }

    public List<String> update(OpportunityView ov) {

        List<String> errors = OpportunityValidator.validate(ov);

        if (errors.size() == 0) {

            LocalDateTime ldt = LocalDateTime.now();
            ov.setCreatedAt(ldt);
            ov.setUpdatedAt(ldt);

            updateInternal(ov);
        }

        return errors;
    }

    private Opportunity findOneInternal(int id) {
        return em.find(Opportunity.class, id);
    }

    private void createInternal(OpportunityView ov) {

        em.getTransaction().begin();
        em.persist(OpportunityConverter.toModel(ov));
        em.getTransaction().commit();

    }

    private void updateInternal(OpportunityView ov) {

        em.getTransaction().begin();
        Opportunity o = findOneInternal(ov.getId());
        OpportunityConverter.copyViewToModel(o, ov);
        em.getTransaction().commit();

    }

}
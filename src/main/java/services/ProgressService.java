package services;

import java.time.LocalDateTime;
import java.util.List;

import actions.views.EmployeeConverter;
import actions.views.EmployeeView;
import actions.views.ProgressConverter;
import actions.views.ProgressView;
import constants.JpaConst;
import models.Progress;
import models.validators.ProgressValidator;

public class ProgressService extends ServiceBase {


    public List<ProgressView> getMinePerPage(EmployeeView employee, int page) {

        List<Progress> progresses = em.createNamedQuery(JpaConst.Q_PRO_GET_ALL_MINE, Progress.class)
                .setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                .setMaxResults(JpaConst.ROW_PER_PAGE)
                .getResultList();
        return ProgressConverter.toViewList(progresses);
    }


    public long countAllMine(EmployeeView employee) {

        long count = (long) em.createNamedQuery(JpaConst.Q_PRO_COUNT_ALL_MINE, Long.class)
                .setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
                .getSingleResult();

        return count;
    }


    public List<ProgressView> getAllPerPage(int page) {

        List<Progress> progresses = em.createNamedQuery(JpaConst.Q_PRO_GET_ALL, Progress.class)
                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                .setMaxResults(JpaConst.ROW_PER_PAGE)
                .getResultList();
        return ProgressConverter.toViewList(progresses);
    }


    public long countAll() {
        long progresses_count = (long) em.createNamedQuery(JpaConst.Q_PRO_COUNT, Long.class)
                .getSingleResult();
        return progresses_count;
    }


    public ProgressView findOne(int id) {
        return ProgressConverter.toView(findOneInternal(id));
    }


    public List<String> create(ProgressView pv) {
        List<String> errors = ProgressValidator.validate(pv);
        if (errors.size() == 0) {
            LocalDateTime ldt = LocalDateTime.now();
            pv.setCreatedAt(ldt);
            pv.setUpdatedAt(ldt);
            createInternal(pv);
        }

        return errors;
    }


    public List<String> update(ProgressView pv) {


        List<String> errors = ProgressValidator.validate(pv);

        if (errors.size() == 0) {

            LocalDateTime ldt = LocalDateTime.now();
            pv.setCreatedAt(ldt);
            pv.setUpdatedAt(ldt);

            updateInternal(pv);
        }

        return errors;
    }


    private Progress findOneInternal(int id) {
        return em.find(Progress.class, id);
    }


    private void createInternal(ProgressView pv) {

        em.getTransaction().begin();
        em.persist(ProgressConverter.toModel(pv));
        em.getTransaction().commit();

    }


    private void updateInternal(ProgressView pv) {

        em.getTransaction().begin();
        Progress p = findOneInternal(pv.getId());
        ProgressConverter.copyViewToModel(p, pv);
        em.getTransaction().commit();

    }
}

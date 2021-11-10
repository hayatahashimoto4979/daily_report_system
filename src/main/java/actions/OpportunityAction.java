package actions;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.ClientView;
import actions.views.EmployeeView;
import actions.views.OpportunityView;
import actions.views.ProgressView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import constants.MessageConst;
import services.ClientService;
import services.OpportunityService;
import services.ProgressService;

public class OpportunityAction extends ActionBase {


    private ProgressService pro_service;

    private ClientService cli_service;

    private OpportunityService service;



    @Override
    public void process() throws ServletException, IOException {

        pro_service = new ProgressService();

        cli_service = new ClientService();

        service = new OpportunityService();


        invoke();
        service.close();
    }

    public void index() throws ServletException, IOException {

        int page = getPage();
        List<OpportunityView> opportunities = service.getAllPerPage(page);

        long opportunitiesCount = service.countAll();

        List<ProgressView> progresses = pro_service.getAllPerPage(page);

        long progressesCount = service.countAll();

        putRequestScope(AttributeConst.OPPORTUNITIES, opportunities);
        putRequestScope(AttributeConst.OPP_COUNT, opportunitiesCount);
        putRequestScope(AttributeConst.PROGRESSES, progresses);
        putRequestScope(AttributeConst.PRO_COUNT, progressesCount);
        putRequestScope(AttributeConst.PAGE, page);
        putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE);



        String flush = getSessionScope(AttributeConst.FLUSH);
        if (flush != null) {
            putRequestScope(AttributeConst.FLUSH, flush);
            removeSessionScope(AttributeConst.FLUSH);
        }

        forward(ForwardConst.FW_OPP_INDEX);

    }

    public void entryNew() throws ServletException, IOException {

        putRequestScope(AttributeConst.TOKEN, getTokenId());

        List<ClientView> clients = cli_service.getperPage(getPage());

        putRequestScope(AttributeConst.CLIENTS, clients);

        OpportunityView ov = new OpportunityView();

        putRequestScope(AttributeConst.OPPORTUNITY, ov);

        forward(ForwardConst.FW_OPP_NEW);
    }


    public void pro_entryNew() throws ServletException, IOException {

        putRequestScope(AttributeConst.TOKEN, getTokenId());


        List<OpportunityView> opportunities = service.getAllPerPage(getPage());

        putRequestScope(AttributeConst.OPPORTUNITIES, opportunities);


        List<ClientView> clients = cli_service.getperPage(getPage());

        putRequestScope(AttributeConst.CLIENTS, clients);


        ProgressView pv = new ProgressView();
        pv.setProgressDate(LocalDate.now());
        putRequestScope(AttributeConst.PROGRESS, pv);


        forward(ForwardConst.FW_OPP_PRO_NEW);

    }

    public void create() throws ServletException, IOException {

        if (checkToken()) {

            ClientView cv = cli_service.findOne(toNumber(getRequestParam(AttributeConst.CLI_ID)));

            EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

            OpportunityView ov = new OpportunityView(
                    null,
                    cv,
                    ev,
                    getRequestParam(AttributeConst.OPP_TITLE),
                    null,
                    null);

            List<String> errors = service.create(ov);

            if (errors.size() > 0) {

                putRequestScope(AttributeConst.TOKEN, getTokenId());
                putRequestScope(AttributeConst.OPPORTUNITY, ov);
                putRequestScope(AttributeConst.ERR, errors);

                forward(ForwardConst.FW_OPP_NEW);

            } else {

                putSessionScope(AttributeConst.FLUSH, MessageConst.I_REGISTERED.getMessage());

                redirect(ForwardConst.ACT_OPP, ForwardConst.CMD_INDEX);
            }
        }
    }


    public void pro_create() throws ServletException, IOException {


        if (checkToken()) {

            OpportunityView ov = service.findOne(toNumber(getRequestParam(AttributeConst.OPP_ID)));

            ClientView cv = cli_service.findOne(toNumber(getRequestParam(AttributeConst.CLI_ID)));


            LocalDate day = null;
            if (getRequestParam(AttributeConst.PRO_DATE) == null
                    || getRequestParam(AttributeConst.PRO_DATE).equals("")) {
                day = LocalDate.now();
            } else {
                day = LocalDate.parse(getRequestParam(AttributeConst.PRO_DATE));
            }

            EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);


            ProgressView pv = new ProgressView(
                    null,
                    ev,
                    cv,
                    ov,
                    day,
                    getRequestParam(AttributeConst.PRO_ITEM),
                    getRequestParam(AttributeConst.PRO_PROSPECT),
                    getRequestParam(AttributeConst.PRO_STATUS),
                    getRequestParam(AttributeConst.PRO_CONTENT),
                    null,
                    null);


            List<String> errors = pro_service.create(pv);

            if (errors.size() > 0) {


                putRequestScope(AttributeConst.TOKEN, getTokenId());
                putRequestScope(AttributeConst.PROGRESS, pv);
                putRequestScope(AttributeConst.ERR, errors);

                forward(ForwardConst.FW_OPP_PRO_NEW);

            } else {

                putSessionScope(AttributeConst.FLUSH, MessageConst.I_REGISTERED.getMessage());


                redirect(ForwardConst.ACT_OPP, ForwardConst.CMD_INDEX);
            }
        }
    }

    public void show() throws ServletException, IOException {

        OpportunityView ov = service.findOne(toNumber(getRequestParam(AttributeConst.OPP_ID)));

        List<ClientView> clients = cli_service.getperPage(getPage());

        putRequestScope(AttributeConst.CLIENTS, clients);

        String flush = getSessionScope(AttributeConst.FLUSH);

        if (ov == null ) {

            putRequestScope(AttributeConst.FLUSH, flush);
            removeSessionScope(AttributeConst.FLUSH);

            forward(ForwardConst.FW_ERR_UNKNOWN);

        } else {

            putRequestScope(AttributeConst.OPPORTUNITY, ov);

            forward(ForwardConst.FW_OPP_SHOW);
        }

    }


    public void pro_show() throws ServletException, IOException {


        List<OpportunityView> opportunities = service.getAllPerPage(getPage());

        putRequestScope(AttributeConst.OPPORTUNITIES, opportunities);


        List<ClientView> clients = cli_service.getperPage(getPage());

        putRequestScope(AttributeConst.CLIENTS, clients);


        ProgressView pv = pro_service.findOne(toNumber(getRequestParam(AttributeConst.PRO_ID)));

        String flush = getSessionScope(AttributeConst.FLUSH);

        if (pv == null) {

            putRequestScope(AttributeConst.FLUSH, flush);
            removeSessionScope(AttributeConst.FLUSH);
            forward(ForwardConst.FW_ERR_UNKNOWN);

        } else {

            putRequestScope(AttributeConst.PROGRESS, pv);

            forward(ForwardConst.FW_OPP_PRO_SHOW);
        }
    }

    public void edit() throws ServletException, IOException {

        OpportunityView ov = service.findOne(toNumber(getRequestParam(AttributeConst.OPP_ID)));

        List<ClientView> clients = cli_service.getperPage(getPage());
        putRequestScope(AttributeConst.CLIENTS, clients);

        EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);
        putRequestScope(AttributeConst.OPP_SELECTED, ov);

        if (ov == null || ev.getId() != ov.getEmployee().getId()) {

            forward(ForwardConst.FW_ERR_UNKNOWN);

        } else {

            putRequestScope(AttributeConst.TOKEN, getTokenId());
            putRequestScope(AttributeConst.OPPORTUNITY, ov);

            forward(ForwardConst.FW_OPP_EDIT);

        }

    }


    public void pro_edit() throws ServletException, IOException {


        ProgressView pv = pro_service.findOne(toNumber(getRequestParam(AttributeConst.PRO_ID)));

        List<ClientView> clients = cli_service.getperPage(getPage());
        putRequestScope(AttributeConst.CLIENTS, clients);

        List<OpportunityView> opportunities = service.getAllPerPage(getPage());
        putRequestScope(AttributeConst.OPPORTUNITIES, opportunities);

        EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

        putRequestScope(AttributeConst.PRO_SELECTED, pv);



        if (pv == null || ev.getId() != pv.getEmployee().getId()) {

            forward(ForwardConst.FW_ERR_UNKNOWN);

        } else {

            putRequestScope(AttributeConst.TOKEN, getTokenId());
            putRequestScope(AttributeConst.PROGRESS, pv);


            forward(ForwardConst.FW_OPP_PRO_EDIT);
        }

    }

    public void update() throws ServletException, IOException {

        if (checkToken()) {

            OpportunityView ov = service.findOne(toNumber(getRequestParam(AttributeConst.OPP_ID)));

            ClientView cv = cli_service.findOne(toNumber(getRequestParam(AttributeConst.CLI_ID)));

            cv.setCode(getRequestParam(AttributeConst.OPP_CLIENT));
            ov.setTitle(getRequestParam(AttributeConst.OPP_TITLE));

            List<String> errors = service.update(ov);

            if (errors.size() > 0) {

                putRequestScope(AttributeConst.TOKEN, getTokenId());
                putRequestScope(AttributeConst.OPPORTUNITY, ov);
                putRequestScope(AttributeConst.ERR, errors);

                forward(ForwardConst.FW_OPP_EDIT);
            } else {

                putSessionScope(AttributeConst.FLUSH, MessageConst.I_UPDATED.getMessage());

                redirect(ForwardConst.ACT_OPP, ForwardConst.CMD_INDEX);

            }
        }
    }


    public void pro_update() throws ServletException, IOException {


        if (checkToken()) {

            OpportunityView ov = service.findOne(toNumber(getRequestParam(AttributeConst.OPP_ID)));

            ClientView cv = cli_service.findOne(toNumber(getRequestParam(AttributeConst.CLI_ID)));

            EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

            ProgressView pv = new ProgressView(
                    toNumber(getRequestParam(AttributeConst.PRO_ID)),
                    ev,
                    cv,
                    ov,
                    toLocalDate(getRequestParam(AttributeConst.REP_DATE)),
                    getRequestParam(AttributeConst.PRO_ITEM),
                    getRequestParam(AttributeConst.PRO_PROSPECT),
                    getRequestParam(AttributeConst.PRO_STATUS),
                    getRequestParam(AttributeConst.PRO_CONTENT),
                    null,
                    null);


            List<String> errors = pro_service.update(pv);

            if (errors.size() > 0) {


                putRequestScope(AttributeConst.TOKEN, getTokenId());
                putRequestScope(AttributeConst.PROGRESS, pv);
                putRequestScope(AttributeConst.ERR, errors);

                forward(ForwardConst.FW_OPP_PRO_EDIT);
            } else {

                putSessionScope(AttributeConst.FLUSH, MessageConst.I_UPDATED.getMessage());

                redirect(ForwardConst.ACT_OPP, ForwardConst.CMD_INDEX);
            }
        }
    }

}
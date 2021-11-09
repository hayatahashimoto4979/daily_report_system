package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.ClientView;
import actions.views.EmployeeView;
import actions.views.OpportunityView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import constants.MessageConst;
import services.ClientService;
import services.OpportunityService;

public class OpportunityAction extends ActionBase {

    private ClientService cli_service;

    private OpportunityService service;



    @Override
    public void process() throws ServletException, IOException {

        cli_service = new ClientService();

        service = new OpportunityService();



        invoke();
        service.close();
    }

    public void index() throws ServletException, IOException {

        int page = getPage();
        List<OpportunityView> opportunities = service.getAllPerPage(page);

        long opportunitiesCount = service.countAll();

        putRequestScope(AttributeConst.OPPORTUNITIES, opportunities);
        putRequestScope(AttributeConst.OPP_COUNT, opportunitiesCount);
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

}
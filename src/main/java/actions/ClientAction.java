package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.ClientView;
import actions.views.EmployeeView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import constants.MessageConst;
import services.ClientService;
import services.EmployeeService;

public class ClientAction extends ActionBase {

    private EmployeeService emp_service;

    private ClientService service;

    @Override
    public void process() throws ServletException, IOException {

        emp_service = new EmployeeService();

        service = new ClientService();

        invoke();

        service.close();
    }

    public void index() throws ServletException, IOException {

        int page = getPage();
        List<ClientView> clients = service.getperPage(page);

        long clientsCount = service.countAll();

        putRequestScope(AttributeConst.CLIENTS, clients);
        putRequestScope(AttributeConst.CLI_COUNT, clientsCount);
        putRequestScope(AttributeConst.PAGE, page);
        putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE);

        String flush = getSessionScope(AttributeConst.FLUSH);
        if (flush != null) {
            putRequestScope(AttributeConst.FLUSH, flush);
            removeSessionScope(AttributeConst.FLUSH);
        }

        forward(ForwardConst.FW_CLI_INDEX);

    }

    public void entryNew() throws ServletException, IOException {

        List<EmployeeView> employees = emp_service.getAll();

        putRequestScope(AttributeConst.EMPLOYEES, employees);

        putRequestScope(AttributeConst.TOKEN, getTokenId());
        putRequestScope(AttributeConst.CLIENT, new ClientView());

        forward(ForwardConst.FW_CLI_NEW);

    }

    public void create() throws ServletException, IOException {

        if (checkToken()) {

            EmployeeView ev = emp_service.findOne(toNumber(getRequestParam(AttributeConst.EMP_ID)));

            System.out.println("####################");
            System.out.println("  id : " + ev);
            System.out.println("####################");

            ClientView cv = new ClientView(
                    null,
                    getRequestParam(AttributeConst.CLI_CODE),
                    getRequestParam(AttributeConst.CLI_NAME),
                    getRequestParam(AttributeConst.CLI_CONTENT),
                    ev,
                    getRequestParam(AttributeConst.CLI_AVE_SALE),
                    getRequestParam(AttributeConst.CLI_TEXT),
                    null,
                    null);

            List<String> errors = service.create(cv);

            if (errors.size() > 0) {

                putRequestScope(AttributeConst.TOKEN, getTokenId());
                putRequestScope(AttributeConst.CLIENT, cv);
                putRequestScope(AttributeConst.ERR, errors);

                forward(ForwardConst.FW_CLI_NEW);

            } else {

                putSessionScope(AttributeConst.FLUSH, MessageConst.I_REGISTERED.getMessage());

                redirect(ForwardConst.ACT_CLI, ForwardConst.CMD_INDEX);
            }
        }
    }

    public void show() throws ServletException, IOException {

        ClientView cv = service.findOne(toNumber(getRequestParam(AttributeConst.CLI_ID)));

        List<EmployeeView> employees = emp_service.getAll();

        putRequestScope(AttributeConst.EMPLOYEES, employees);

        if (cv == null) {

            forward(ForwardConst.FW_ERR_UNKNOWN);
            return;
        }

        putRequestScope(AttributeConst.CLIENT, cv);

        forward(ForwardConst.FW_CLI_SHOW);

    }

    public void edit() throws ServletException, IOException {

        ClientView cv = service.findOne(toNumber(getRequestParam(AttributeConst.CLI_ID)));

        List<EmployeeView> employees = emp_service.getAll();

        putRequestScope(AttributeConst.EMPLOYEES, employees);
        putRequestScope(AttributeConst.CLI_SELECTED, cv);

        if (cv == null) {

            forward(ForwardConst.FW_ERR_UNKNOWN);
            return;
        }

        putRequestScope(AttributeConst.TOKEN, getTokenId());
        putRequestScope(AttributeConst.CLIENT, cv);

        forward(ForwardConst.FW_CLI_EDIT);

    }

    public void update() throws ServletException, IOException {

        if (checkToken()) {

            EmployeeView ev = emp_service.findOne(toNumber(getRequestParam(AttributeConst.EMP_ID)));

            ClientView cv = new ClientView(
                    toNumber(getRequestParam(AttributeConst.CLI_ID)),
                    getRequestParam(AttributeConst.CLI_CODE),
                    getRequestParam(AttributeConst.CLI_NAME),
                    getRequestParam(AttributeConst.CLI_CONTENT),
                    ev,
                    getRequestParam(AttributeConst.CLI_AVE_SALE),
                    getRequestParam(AttributeConst.CLI_TEXT),
                    null,
                    null);

            List<String> errors = service.update(cv);

            if (errors.size() > 0) {

                putRequestScope(AttributeConst.TOKEN, getTokenId());
                putRequestScope(AttributeConst.CLIENT, cv);
                putRequestScope(AttributeConst.ERR, errors);

                forward(ForwardConst.FW_CLI_EDIT);

            } else {

                putSessionScope(AttributeConst.FLUSH, MessageConst.I_UPDATED.getMessage());

                redirect(ForwardConst.ACT_CLI, ForwardConst.CMD_INDEX);
            }
        }
    }

}
package constants;

public enum ForwardConst {

    ACT("action"),
    ACT_TOP("Top"),
    ACT_EMP("Employee"),
    ACT_REP("Report"),
    ACT_CLI("Client"),
    ACT_OPP("Opportunity"),
    ACT_PRO("Progress"),
    ACT_AUTH("Auth"),

    CMD("command"),
    CMD_NONE(""),
    CMD_INDEX("index"),
    CMD_SHOW("show"),
    CMD_SHOW_LOGIN("showLogin"),
    CMD_LOGIN("login"),
    CMD_LOGOUT("logout"),
    CMD_NEW("entryNew"),
    CMD_CREATE("create"),
    CMD_EDIT("edit"),
    CMD_UPDATE("update"),
    CMD_DESTROY("destroy"),
    CMD_PRO_NEW("pro_entryNew"),
    CMD_PRO_SHOW("pro_show"),
    CMD_PRO_CREATE("pro_create"),
    CMD_PRO_EDIT("pro_edit"),
    CMD_PRO_UPDATE("pro_update"),

    FW_ERR_UNKNOWN("error/unknown"),
    FW_TOP_INDEX("topPage/index"),
    FW_LOGIN("login/login"),

    FW_EMP_INDEX("employees/index"),
    FW_EMP_SHOW("employees/show"),
    FW_EMP_NEW("employees/new"),
    FW_EMP_EDIT("employees/edit"),

    FW_REP_INDEX("reports/index"),
    FW_REP_SHOW("reports/show"),
    FW_REP_NEW("reports/new"),
    FW_REP_EDIT("reports/edit"),

    FW_CLI_INDEX("clients/index"),
    FW_CLI_SHOW("clients/show"),
    FW_CLI_NEW("clients/new"),
    FW_CLI_EDIT("clients/edit"),

    FW_OPP_INDEX("opportunities/index"),
    FW_OPP_SHOW("opportunities/show"),
    FW_OPP_NEW("opportunities/new"),
    FW_OPP_EDIT("opportunities/edit"),
    FW_OPP_PRO_SHOW("progresses/pro_show"),
    FW_OPP_PRO_NEW("progresses/pro_new"),
    FW_OPP_PRO_EDIT("progresses/pro_edit");




    private final String text;

    private ForwardConst(final String text) {
        this.text = text;
    }

    public String getValue() {
        return this.text;
    }

    public static ForwardConst get(String key) {
        for(ForwardConst c : values()) {
            if(c.getValue().equals(key)) {
                return c;
            }
        }
        return CMD_NONE;
    }

}
package constants;

public enum AttributeConst {

    //フラッシュメッセージ
    FLUSH("flush"),

    //一覧画面共通
    MAX_ROW("maxRow"),
    PAGE("page"),

    //入力フォーム共通
    TOKEN("_token"),
    ERR("errors"),

    //ログイン中の従業員
    LOGIN_EMP("login_employee"),

    //ログイン画面
    LOGIN_ERR("loginError"),

    //従業員管理
    EMPLOYEE("employee"),
    EMPLOYEES("employees"),
    EMP_COUNT("employees_count"),
    EMP_ID("id"),
    EMP_CODE("code"),
    EMP_PASS("password"),
    EMP_NAME("name"),
    EMP_ADMIN_FLG("admin_flag"),

    //管理者フラグ
    ROLE_ADMIN(1),
    ROLE_GENERAL(0),

    //削除フラグ
    DEL_FLAG_TRUE(1),
    DEL_FLAG_FALSE(0),

    //日報管理
    REPORT("report"),
    REPORTS("reports"),
    REP_COUNT("reports_count"),
    REP_ID("id"),
    REP_DATE("report_date"),
    REP_TITLE("title"),
    REP_CONTENT("content"),

    //顧客管理
    CLIENT("client"),
    CLIENTS("clients"),
    CLI_COUNT("clients_count"),
    CLI_ID("cli_id"),
    CLI_CODE("code"),
    CLI_NAME("name"),
    CLI_CONTENT("content"),
    CLI_EMPLOYEE("employee_rep_id"),
    CLI_SELECTED("selected_id"),
    CLI_AVE_SALE("average_sales"),
    CLI_TEXT("text"),
    CLI_ADMIN_FLG("cli_admin_flag"),

    CLI_EMP_LIST("emp_list"),

    //商談管理
    OPPORTUNITY("opportunity"),
    OPPORTUNITIES("opportunities"),
    OPP_COUNT("opportunitis_count"),
    OPP_ID("id"),
    OPP_CLIENT("client_id"),
    OPP_SELECTED("selected_id"),
    OPP_TITLE("opp_title"),

    //商談状況
    PROGRESS("progress"),
    PROGRESSES("progresses"),
    PRO_COUNT("progresses_count"),
    PRO_ID("id"),
    PRO_SELECTED("selected_id"),
    PRO_EMP("employee_id"),
    PRO_CLI("client_id"),
    PRO_OPP("opportunity_id"),
    PRO_DATE("progress_date"),
    PRO_ITEM("item"),
    PRO_PROSPECT("prospect"),
    PRO_STATUS("status"),
    PRO_CONTENT("content");





    private final String text;
    private final Integer i;

    private AttributeConst(final String text) {
        this.text = text;
        this.i = null;
    }

    private AttributeConst(final Integer i) {
        this.text = null;
        this.i = i;
    }

    public String getValue() {
        return this.text;
    }

    public Integer getIntegerValue() {
        return this.i;
    }
}
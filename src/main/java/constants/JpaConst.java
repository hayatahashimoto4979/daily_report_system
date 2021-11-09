package constants;

public interface JpaConst {

    String PERSISTENCE_UNIT_NAME = "daily_report_system";

    int ROW_PER_PAGE = 15;

    String TABLE_EMP = "employees";

    String EMP_COL_ID = "id";
    String EMP_COL_CODE = "code";
    String EMP_COL_NAME = "name";
    String EMP_COL_PASS = "pasward";
    String EMP_COL_ADMIN_FLAG = "admin_flag";
    String EMP_COL_CREATED_AT = "created_at";
    String EMP_COL_UPDATED_AT = "updated_at";
    String EMP_COL_DELETE_FLAG = "delete_flag";

    int ROLE_ADMIN = 1;
    int ROLE_GENERAL = 0;
    int EMP_DEL_TRUE = 1;
    int EMP_DEL_FALSE = 0;

    String TABLE_REP = "report";

    String REP_COL_ID = "id";
    String REP_COL_EMP = "employee_id";
    String REP_COL_REP_DATE = "report_date";
    String REP_COL_TITLE = "title";
    String REP_COL_CONTENT = "content";
    String REP_COL_CREATED_AT = "created_at";
    String REP_COL_UPDATED_AT = "updated_at";

    String TABLE_CLI = "client";

    String CLI_COL_ID = "id"; //id
    String CLI_COL_CODE = "code";
    String CLI_COL_NAME = "name";
    String CLI_COL_CONTENT = "content";
    String CLI_COL_EMP = "employee_id";
    String CLI_COL_AVE_SALE = "average_sales";
    String CLI_COL_TEXT = "text";
    String CLI_COL_CREATED_AT = "created_at";
    String CLI_COL_UPDATED_AT = "updated_at";


    String TABLE_OPP = "opportunity";

    String OPP_COL_ID = "id";
    String OPP_COL_CLI = "client_id";
    String OPP_COL_EMP = "employee_id";
    String OPP_COL_TITLE = "title";
    String OPP_COL_CREATED_AT = "created_at";
    String OPP_COL_UPDATED_AT = "updated_at";




    String ENTITY_EMP = "employee";
    String ENTITY_REP = "report";
    String ENTITY_CLI = "client";
    String ENTITY_OPP = "opportunity";

    String JPQL_PARM_CODE = "code";
    String JPQL_PARM_PASSWORD = "password";
    String JPQL_PARM_EMPLOYEE = "employee";

    String Q_EMP_GET_ALL = ENTITY_EMP + ".getAll";
    String Q_EMP_GET_ALL_DEF = "SELECT e FROM Employee AS e ORDER BY e.id DESC";

    String Q_EMP_GET_ID = ENTITY_EMP + ".getId";
    String Q_EMP_GET_ID_DEF = "SELECT e FROM Employee AS e WHERE e.deleteFlag = 0 ORDER BY e.id DESC";

    String Q_EMP_COUNT = ENTITY_EMP + ".count";
    String Q_EMP_COUNT_DEF = "SELECT COUNT(e) FROM Employee AS e";

    String Q_EMP_GET_BY_CODE_AND_PASS = ENTITY_EMP + ".getByCodeAndPass";
    String Q_EMP_GET_BY_CODE_AND_PASS_DEF = "SELECT e FROM Employee AS e WHERE e.deleteFlag = 0 AND e.code = :" + JPQL_PARM_CODE + " AND e.password = :" + JPQL_PARM_PASSWORD;

    String Q_EMP_COUNT_RESISTERED_BY_CODE = ENTITY_EMP + ".countRegisteredByCode";
    String Q_EMP_COUNT_RESISTERED_BY_CODE_DEF = "SELECT COUNT(e) FROM Employee AS e WHERE e.code = :" + JPQL_PARM_CODE;




    String Q_REP_GET_ALL = ENTITY_REP + ".getAll";
    String Q_REP_GET_ALL_DEF = "SELECT r FROM Report AS r ORDER BY r.id DESC";

    String Q_REP_COUNT = ENTITY_REP + ".count";
    String Q_REP_COUNT_DEF = "SELECT COUNT(r) FROM Report AS r";

    String Q_REP_GET_ALL_MINE = ENTITY_REP + ".getAllMine";
    String Q_REP_GET_ALL_MINE_DEF = "SELECT r FROM Report AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE + " ORDER BY r.id DESC";

    String Q_REP_COUNT_ALL_MINE = ENTITY_REP + ".countAllMine";
    String Q_REP_COUNT_ALL_MINE_DEF = "SELECT COUNT(r) FROM Report AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE;




    String Q_CLI_GET_ALL = ENTITY_CLI + ".getAll";
    String Q_CLI_GET_ALL_DEF = "SELECT c FROM Client AS c ORDER BY c.id DESC";

    String Q_CLI_COUNT = ENTITY_CLI + ".count";
    String Q_CLI_COUNT_DEF = "SELECT COUNT(c) FROM Client AS c";

    String Q_CLI_GET_ID = ENTITY_CLI + ".getId";
    String Q_CLI_GET_ID_DEF = "SELECT c FROM Client AS c ORDER BY c.id DESC";




    String Q_OPP_GET_ALL = ENTITY_OPP + ".getAll";
    String Q_OPP_GET_ALL_DEF = "SELECT o FROM Opportunity AS o ORDER BY o.id DESC";

    String Q_OPP_COUNT = ENTITY_OPP + ".count";
    String Q_OPP_COUNT_DEF = "SELECT COUNT(o) FROM Opportunity AS o";

    String Q_OPP_GET_ALL_MINE = ENTITY_OPP + ".getAllMine";
    String Q_OPP_GET_ALL_MINE_DEF = "SELECT o FROM Opportunity AS o WHERE o.employee = :" + JPQL_PARM_EMPLOYEE + " ORDER BY o.id DESC";

    String Q_OPP_COUNT_ALL_MINE = ENTITY_OPP + ".countAllMine";
    String Q_OPP_COUNT_ALL_MINE_DEF = "SELECT COUNT(o) FROM Opportunity AS o WHERE o.employee = :" + JPQL_PARM_EMPLOYEE;



}
package constants;

public enum MessageConst {

    I_LOGINED("ログインしました"),
    E_LOGINED("ログインに失敗しました。"),
    I_LOGOUT("ログアウトしました。"),

    I_REGISTERED("登録が完了しました。"),
    I_UPDATED("更新が完了しました。"),
    I_DELETED("削除が完了しました。"),

    E_NONAME("氏名を入力してください。"),
    E_NOCOMPANYNAME("会社名を入力してください。"),
    E_NOPASSWORD("パスワードを入力してください。"),
    E_NOEMP_CODE("社員番号を入力してください。"),
    E_NOCLI_CODE("お客様番号を入力してください"),
    E_EMP_CODE_EXIST("入力された社員番号の情報は既に存在しています。"),
    E_CLI_CODE_EXIST("入力されたお客様番号の情報は既に存在しています。"),
    E_NOTITLE("タイトルを入力してください。"),
    E_NOCONTENT("内容を入力してください。"),
    E_NOAVEGACE("月間平均売上を入力してください。"),
    E_NOOPPTITLE("商談タイトルを入力してください。"),
    E_NOITEM("商談項目を入力してください。"),
    E_NOPROSPECT("見込ランクを入力してください。"),
    E_NOSTATUS("商談状況を入力してください。");




    private final String text;


    private MessageConst(final String text) {
        this.text = text;
    }



    public String getMessage() {
        return this.text;
    }
}
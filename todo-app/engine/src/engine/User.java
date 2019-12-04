package engine;

public class User {
    private String m_Userame;
    private String m_Password;

    public User(String i_Username, String i_Password) {
        m_Userame = i_Username;
        m_Password = i_Password;
    }
    public boolean isUserPassword(String i_Password) { return m_Password.equals(i_Password); }
    public String getUserame() { return m_Userame; }
    public String getPassword() { return m_Password; }
}

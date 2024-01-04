package entity;

public class Manager extends User {
    private String projectId;
    private int expInYear;

    public Manager(int id, String fullName, String email, String password, Role role, String projectId, int expInYear) {
        super(id, fullName, email, password, role);
        this.projectId = projectId;
        this.expInYear = expInYear;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }
}

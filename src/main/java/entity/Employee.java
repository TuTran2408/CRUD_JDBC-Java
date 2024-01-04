package entity;

public class Employee extends User{
    private String projectId;
    private String proSkill;

    public Employee(int id, String fullName, String email, String password, Role role, String projectId, String proSkill) {
        super(id, fullName, email, password, role);
        this.projectId = projectId;
        this.proSkill = proSkill;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}

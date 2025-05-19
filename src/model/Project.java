package model;

import java.util.ArrayList;
import java.util.UUID;

import model.Result;

import java.util.List;

public class Project {
    private String id;
    private String courseCode;
    private List<String> beneficiaryCompanies;
    private String semester;
    private String name;
    private ProjectType type;
    private String keywords;
    private String description;
    private String statementDocumentLink;
    private String derivedFromProjectId;
    private List<Result> results;
    private boolean active;

    public Project(String courseCode, List<String> beneficiaryCompanies, String semester, String name, ProjectType type, String keywords, String description, String statementDocumentLink, String derivedFromProjectId) {
        this.id = generateProjectId();
        this.courseCode = courseCode;
        this.beneficiaryCompanies = beneficiaryCompanies;
        this.semester = semester;
        this.name = name;
        this.type = type;
        this.keywords = keywords;
        this.description = description;
        this.statementDocumentLink = statementDocumentLink;
        this.derivedFromProjectId = derivedFromProjectId;
        this.results = new ArrayList<>();
        this.active = true;
    }

    private String generateProjectId() {
        return "Proj-" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public List<String> getBeneficiaryCompanies() {
        return beneficiaryCompanies;
    }

    public void setBeneficiaryCompanies(List<String> beneficiaryCompanies) {
        this.beneficiaryCompanies = beneficiaryCompanies;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectType getType() {
        return type;
    }

    public void setType(ProjectType type) {
        this.type = type;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatementDocumentLink() {
        return statementDocumentLink;
    }

    public void setStatementDocumentLink(String statementDocumentLink) {
        this.statementDocumentLink = statementDocumentLink;
    }

    public String getDerivedFormProjectId() {
        return derivedFromProjectId;
    }

    public void setDerivedFormProjectId(String derivedFormProjectId) {
        this.derivedFromProjectId = derivedFormProjectId;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void addResult(Result result) {
        if (results.size() < 3){
            results.add(result);
        }
    }

    public void deleteDeliverable(String resultId, String deliverableId) {
        results.stream()
                .filter(r -> r.getId().equals(resultId))
                .findFirst()
                .ifPresent(r -> r.deleteDeliverable(deliverableId));
    }

    public enum ProjectType {
        INTEGRATOR_TASK, COURSE_PROJECT, FINAL_PROJECT
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", semester='" + semester + '\'' +
                '}';
    }
}


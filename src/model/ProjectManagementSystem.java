package model;

import exceptions.*;
import java.util.List;

public class ProjectManagementSystem {
    private Controller controller;

    public ProjectManagementSystem() {
        this.controller = new Controller();
    }

    public void initializeSystem(String filePath) throws InvalidFileException{
        if(filePath.equalsIgnoreCase("demo")){
            controller.loadDemoDate();
        }else{
            controller.loadDataFromFile(filePath);
        }
    }

    public void addCourse (Course course) throws InvalidIdException{
        controller.addCourse(course);
    }

    public Course getCourse(String code) throws CourseNotFoundException{
        Course course = controller.getCourseById(code);
        if (course == null){
            throw new CourseNotFoundException("Course not found whit code: " + code);
        }
        return course;
    }

    public void addProfessor(Professors professor) throws ProfessorNotFoundException {
        if (professor == null || controller.getProfessorsById(professor.getId()) == null) {
            throw new ProfessorNotFoundException("Professor not found with Id: " + professor.getId());
        }
        controller.addProfessor(professor);
    }


    public void addProject(Project project) throws InvalidIdException{
        controller.addProject(project);
    }

    public Project getProject(String id) throws ProjectNotFoundException{
        Project project = controller.getPorjectById(id);
        if (project == null) {
            throw new ProjectNotFoundException("Project not found with Id: " + id);
        }
        return project;
    }

    public List<Project> searchProjectByCourse(String courseCode) throws CourseNotFoundException{
        return controller.searchProjectByCourse(courseCode);
    }

    public List<Project> searchProjectsByKeywords(String[] keywords) {
        return controller.searchProjectsByKeywords(keywords);
    }

    public List<Project> getProjectsWithoutResults() {
        return controller.getProjectsWithoutResults();
    }

    public List<Project> getProjectsBySemester(String semester) {
        return controller.getProjectsBySemester(semester);
    }

    public void deleteDeliverable(String projectId, String resultId, String deliverableId) 
            throws ProjectNotFoundException {
        controller.deleteDeliverable(projectId, resultId, deliverableId);
    }
}



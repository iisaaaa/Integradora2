package model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import exceptions.InvalidFileException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import exceptions.InvalidIdException;
import java.io.Serializable;

public class Controller implements Serializable{
    private List<Course> courses;
    private List<Professors> professors;
    private List<Project> projects;

    public Controller() {
        this.courses = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    //File loading methods
    public void loadDemoDate() throws InvalidFileException{
        try{
            //Load courses
            File coursesFile = new File("src\\data\\courses.txt");
            loadCoursesFormFile(coursesFile);

            //Load professors
            File professorsFile = new File("src\\data\\professors.txt");
            loadProfessorsFromFile(professorsFile);

            //Load projects
            File projectFile = new File ("src\\data\\projects.txt");
            loadProjectsFromFile(projectFile);

        }catch (FileNotFoundException e){
            throw new InvalidFileException("Demo data files not found");
        }catch (IOException e){
            throw new InvalidFileException("Error reading demo data files");
        }
    }

    public void loadDataFromFile(String filePath) throws InvalidFileException {
        try{
            File inputFile = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;

            while ((line = reader.readLine()) != null){
                String[] parts = line.split("-");
                switch (parts[0]){
                    case "COURSE" :
                        addCourse(new Course(parts[1], parts[2], parts[3], Integer.parseInt(parts[4])));
                        break;
                    case "PROFESSOR" :
                        addProfessor(new Professors(parts[1], parts[2], parts[3], parts[4]));
                        break;
                    case "PROJECT": 
                        String courseCode = parts[1];
                        List<String> beneficiaryCompanies = Arrays.asList(parts[2].split(","));
                        String semester = parts[3];
                        String projectName = parts[4];
                        Project.ProjectType type = Project.ProjectType.valueOf(parts[5]);
                        String keywords = parts[6];
                        String description = parts[7];
                        String statementDocLink = parts[8];
                        String derivedFromProjectId = parts.length > 9 ? parts[9] : null;
                
                        // Validar que el curso exista
                        Course relatedCourse = getCourseById(courseCode);
                        if (relatedCourse == null) {
                            throw new InvalidFileException("Course not found for project: " + courseCode);
                        }
                
                        // Crear y agregar el proyecto
                        Project project = new Project(
                            courseCode,
                            beneficiaryCompanies,
                            semester,
                            projectName,
                            type,
                            keywords,
                            description,
                            statementDocLink,
                            derivedFromProjectId
                        );
                        addProject(project);
                        break;
                }
            }
            reader.close();
        }catch (FileNotFoundException e){
            throw new InvalidFileException("File not found: " + filePath);
        }catch (IOException e){
            throw new InvalidFileException("Error reading file: " + filePath);
        }
    }

    // public String getCourseByID(String courseID){
    //     for(Course c: courses){
    //         if(c.getCode().equals(courseID)){
    //             return toString();
    //         }
    //     }
    //     return "Not found";
    // }

    private void loadCoursesFormFile(File file) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null){
            String[] parts = line.split("-");
            try {
                addCourse(new Course(parts[0], parts[1], parts[2], Integer.parseInt(parts[3])));
            } catch (InvalidIdException e) {
            }
        }
        reader.close();
    }

    private void loadProfessorsFromFile(File file) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while((line = reader.readLine()) != null){
            String[] parts = line.split("-");
            try {
                addProfessor(new Professors(parts[0], parts[1], parts[2], parts[3]));
            } catch (InvalidIdException e) {
            }
        }
        reader.close();
    }

    private void loadProjectsFromFile(File file) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null){
            String[] parts = line.split("-");
            try {
                addProject(new Project(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8]));
            } catch (Exception e) {
            }
            
        }
        reader.close();
    }

    public List<Project> serachProjectsByKeywords(String [] keywords) {
        List<Project> matchingProjects = new ArrayList<>();

        for (Project project : projects) {
            String projectKeywords = project.getKeywords().toLowerCase();
            boolean matchFound = false;

            for (String keyword : keywords) {
                if (projectKeywords.contains(keyword.toLowerCase())){
                    matchFound = true;
                    break;
                }
            }

            if (matchFound){
                matchingProjects.add(project);
            }
        }
        return matchingProjects;
    }

    public Project getProjectById(String id){
        for (Project project : projects) {
            if (project.getId().equals(id)){
                return project;
            }
        }
        return null;
    }

    public List<Project> getProjectsWithoutResults() {
        List<Project> projectsWithoutResults = new ArrayList<>();

        for (Project project : projects) {
            if (project.getResults().isEmpty()){
                projectsWithoutResults.add(project);
            }
        }

        return projectsWithoutResults;
    }

    public List<Project> getProjectsBySemester(String semester) {
        List<Project> semesterProjects = new ArrayList<>();
        
        for (Project project : projects) {
            if (project.getSemester().equals(semester)) {
                semesterProjects.add(project);
            }
        }
        
        return semesterProjects;
    }

    public Professors getProfessorsById (String id){
        for (Professors professor : professors) {
            if (professor.getId().equals(id)){
                return professor;
            }
        }
        return null;
    }

    public Course getCourseByID(String id){
        for(Course c: courses){
            if(c.getCode().equals(id)){
                return c;
            }
        }
        return null;
    }

    public void addCourse(Course course) throws InvalidIdException{
        if(getCourseByID(course.getCode()) != null){
            throw new InvalidIdException("Course with this Id already exits");
        }
        courses.add(course);
    }

    public void addProfessor(Professors professor) throws InvalidIdException{
        if (getProfessorsById((professor.getId())) != null){
            throw new InvalidIdException("Professor with this Id already exits");
        }
        professors.add(professor);
    }

    public void addProject(Project project) throws InvalidIdException{
        if (getProjectById(project.getId()) != null){
            throw new InvalidIdException("Project with this Id already exits");
        }
        projects.add(project);
    }

   public void deleteDeliverable(String projectId, String resultId, String deliverableId){
        for(Project p: projects){
            //No se como quieras hacer este metodo.
     }
    }
}



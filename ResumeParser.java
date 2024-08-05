import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResumeParser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input personal information
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter your phone: ");
        String phone = scanner.nextLine();
        
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        // Input education
        JSONArray educationArray = new JSONArray();
        System.out.print("Enter your degree: ");
        String degree = scanner.nextLine();
        
        System.out.print("Enter your major: ");
        String major = scanner.nextLine();
        
        System.out.print("Enter your institution: ");
        String institution = scanner.nextLine();
        
        System.out.print("Enter your year of graduation: ");
        String gradYear = scanner.nextLine();
        
        JSONObject education = new JSONObject();
        education.put("degree", degree);
        education.put("major", major);
        education.put("institution", institution);
        education.put("year", gradYear);
        educationArray.put(education);

        // Input work experience
        JSONArray workExperienceArray = new JSONArray();
        System.out.print("Enter your job title: ");
        String jobTitle = scanner.nextLine();
        
        System.out.print("Enter company name: ");
        String company = scanner.nextLine();
        
        System.out.print("Enter company location: ");
        String location = scanner.nextLine();
        
        System.out.print("Enter dates of employment: ");
        String dates = scanner.nextLine();
        
        System.out.print("Enter responsibilities (comma-separated): ");
        String[] responsibilities = scanner.nextLine().split(",");

        JSONObject workExperience = new JSONObject();
        workExperience.put("job_title", jobTitle);
        workExperience.put("company", company);
        workExperience.put("location", location);
        workExperience.put("dates", dates);
        workExperience.put("responsibilities", new JSONArray(List.of(responsibilities)));
        workExperienceArray.put(workExperience);

        // Input skills
        JSONArray skillsArray = new JSONArray();
        System.out.print("Enter skills (comma-separated): ");
        String[] skills = scanner.nextLine().split(",");
        for (String skill : skills) {
            skillsArray.put(skill.trim());
        }

        // Input certifications
        JSONArray certificationsArray = new JSONArray();
        System.out.print("Enter certification name: ");
        String certName = scanner.nextLine();
        
        System.out.print("Enter issuing organization: ");
        String issuingOrg = scanner.nextLine();
        
        System.out.print("Enter year obtained: ");
        String certYear = scanner.nextLine();

        JSONObject certification = new JSONObject();
        certification.put("certification_name", certName);
        certification.put("issuing_organization", issuingOrg);
        certification.put("year", certYear);
        certificationsArray.put(certification);

        // Construct final JSON object
        JSONObject resumeJSON = new JSONObject();
        resumeJSON.put("personal_information", new JSONObject()
                .put("name", name)
                .put("email", email)
                .put("phone", phone)
                .put("address", address));
        resumeJSON.put("education", educationArray);
        resumeJSON.put("work_experience", workExperienceArray);
        resumeJSON.put("skills", skillsArray);
        resumeJSON.put("certifications", certificationsArray);

        // Output the JSON
        System.out.println(resumeJSON.toString(4)); // Pretty print with 4-space indentation
    }
}

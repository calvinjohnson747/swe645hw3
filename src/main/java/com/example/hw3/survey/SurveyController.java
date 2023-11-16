package com.example.hw3.survey;

import com.example.hw3.survey.Survey;
import com.example.hw3.survey.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/get")
    public List<Survey> getSurvey(){
        return surveyService.getSurvey();
    }

    @PostMapping("/submit")
    public ResponseEntity<String> newSurvey(@ModelAttribute Survey survey){
         surveyService.addNewSurvey(survey);
         System.out.println(survey.toString());
         return ResponseEntity.ok("Survey Submitted Successfully, Visit <a href=\"/\">localhost:8080</a> to add another response");
    }

    @DeleteMapping(path="{id}")
    public void deleteSurvey(@PathVariable("id") int id){
        surveyService.deleteSurvey(id);
    }

    @PutMapping(path="/update/{id}")
    public void updateStudent(
            @PathVariable("id") int id,
            @RequestParam(required = false) String Fname,
            @RequestParam(required = false) String Lname
    )
    {
        surveyService.updateStudent(id,Fname,Lname);
    }
}

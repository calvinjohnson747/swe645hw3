package com.example.hw3.survey;

import com.example.hw3.survey.Survey;
import com.example.hw3.survey.SurveyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public List<Survey> getSurvey(){
        return surveyRepository.findAll();
    }
    public void addNewSurvey(Survey survey) {
        surveyRepository.save(survey);
    }

    public void deleteSurvey(int id) {
        if(surveyRepository.existsById(id)){
            surveyRepository.deleteById(id);
        }
        else{
            throw new IllegalStateException("ID does not exist");
        }
    }

    @Transactional
    public void updateStudent(int id, String fname, String lname) {

        if(surveyRepository.existsById(id)){
            Optional<Survey> survey = surveyRepository.findById(id);
            Survey survey1 = survey.orElseThrow();
            if(fname!=null && lname==null) {
                survey1.setFname(fname);

            }
            else if(lname!=null && fname==null){
                survey1.setLname(lname);
            }
            else{
                survey1.setFname(fname);
                survey1.setLname(lname);
            }

        }
    }
}

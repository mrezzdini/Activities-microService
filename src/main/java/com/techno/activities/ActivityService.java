package com.techno.activities;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository repository;

    public void savedActivity(Activity activity) {
        Optional<Activity> activityOptional = repository.findActivityByName(
                activity.getName());
        if(activityOptional.isPresent()){
            throw new IllegalStateException("Name taken");
        }
        repository.save(activity);
    }

    public void deleteActivity(Long weeklyProgramId) {
        boolean exists = repository.existsById(weeklyProgramId);
        if(!exists){
            throw new IllegalStateException(
                    "activity with id" + weeklyProgramId + "was not found");
        }
        repository.deleteById(weeklyProgramId);

    }
    @Transactional
    public void updateActivity(Long weeklyProgramId,String name)
    {
        Activity activity = repository.findById(weeklyProgramId).orElseThrow(
                () -> new IllegalStateException(
                        "teachers with id" + weeklyProgramId + "was not found")
        );
        if (name != null && name.length() > 0 &&
                !Objects.equals(activity.getName(), name)) {
            activity.setName(name);
        }
    }

    public List<Activity> findAllActivity (){
        return repository.findAll();
    }
    public List<Activity> findAllActivityByWeeklyProgram(Long weeklyProgramId)  {
        return repository.findAllByWeeklyProgramId(weeklyProgramId);
    }
}


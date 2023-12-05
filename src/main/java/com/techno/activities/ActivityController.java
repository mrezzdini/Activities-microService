package com.techno.activities;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/activity")
public class ActivityController {
    private final ActivityService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Activity activity){
        service.savedActivity(activity);
    }
    @GetMapping
    public ResponseEntity<List<Activity>> findAllActivity(){
        return ResponseEntity.ok(service.findAllActivity());
    }

    @GetMapping("/weeklyProgram/{weeklyProgram-id}")
    public ResponseEntity<List<Activity>> findAllActivity(
            @PathVariable("weeklyProgram-id") Long weeklyProgramId

    ){
        return ResponseEntity.ok(service.findAllActivityByWeeklyProgram(weeklyProgramId));
    }
    @DeleteMapping(path = "{weeklyProgramId}")
    public  void deleteActivity(@PathVariable("weeklyProgramId") Long weeklyProgramIdy){
        service.deleteActivity(weeklyProgramIdy);
    }

    @PutMapping(path ="{weeklyProgramId}")
    public void updateActivity(
            @PathVariable("weeklyProgramIdy") Long weeklyProgramIdy,
            @RequestParam(required = false) String name)  {

        service.updateActivity(weeklyProgramIdy, name);
    }
}
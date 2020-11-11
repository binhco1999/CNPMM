package com.macia.HRs.api;

import com.macia.HRs.entity.User_Activity;
import com.macia.HRs.repository.UserActivityRepository;
import com.macia.HRs.service.UserActivityService;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/useractivities")
public class UserActivityResource {

    @Autowired
    private UserActivityRepository UserActivityRepository;

    @Autowired
    private UserActivityService usaService;


    @GetMapping()
    @CrossOrigin("*")
    @ResponseBody
    public List<User_Activity> getAllUserActivity(){
        return usaService.findAllAvailable();
    }

    @GetMapping("/count")
    @CrossOrigin("*")
    @ResponseBody
    public Long count() {
        return UserActivityRepository.count();
    }

    @DeleteMapping("/{id}/uid/{uid}")
    @CrossOrigin("*")
    public Map<String, Boolean> deleteUserActivity(@PathVariable(value = "id") Integer UserActivityId,@PathVariable(value = "uid") Integer uid) throws Exception {
        User_Activity UserActivity =
                UserActivityRepository
                        .findById(UserActivityId)
                        .orElseThrow(() -> new ResourceNotFoundException("UserActivity not found on :: " + UserActivityId));
        UserActivity.setIsdeleted(Boolean.TRUE);
        UserActivity.setDeleteBy(uid);
        UserActivityRepository.save(UserActivity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    @ResponseBody
    public ResponseEntity<User_Activity> getUserActivityById(@PathVariable(value = "id") Integer UserActivityId)
            throws ResourceNotFoundException {
        User_Activity UserActivity =
                UserActivityRepository
                        .findById(UserActivityId)
                        .orElseThrow(() -> new ResourceNotFoundException("UserActivity not found on :: " + UserActivityId));
        return ResponseEntity.ok().body(UserActivity);
    }


    @PostMapping()
    @CrossOrigin("*")
    @ResponseBody
    public User_Activity createUserActivity(@RequestBody User_Activity UserActivity) {
        return UserActivityRepository.save(UserActivity);
    }
}
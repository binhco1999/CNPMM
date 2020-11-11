package com.macia.HRs.api;

import com.macia.HRs.entity.AppUser;
import com.macia.HRs.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/appusers")
public class AppUserResource {

    @Autowired
    private AppUserRepository AUserRepo;

    @GetMapping()
    @CrossOrigin("*")
    @ResponseBody
    public List<AppUser> getAllAppUser(){
        return AUserRepo.findAll();
    }

    @GetMapping("/count")
    @CrossOrigin("*")
    public Long count() {
        return AUserRepo.count();
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public Map<String, Boolean> deleteAppUser(@PathVariable(value = "id") Integer AppUserId) throws Exception {
        AppUser AppUser =
                AUserRepo
                        .findById(AppUserId)
                        .orElseThrow(() -> new ResourceNotFoundException("AppUser not found on :: " + AppUserId));
        AUserRepo.delete(AppUser);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    @ResponseBody
    public ResponseEntity<AppUser> getAppUserById(@PathVariable(value = "id") Integer AppUserId)
            throws ResourceNotFoundException {
        AppUser AppUser =
                AUserRepo
                        .findById(AppUserId)
                        .orElseThrow(() -> new ResourceNotFoundException("AppUser not found on :: " + AppUserId));
        return ResponseEntity.ok().body(AppUser);
    }


    @PostMapping()
    @CrossOrigin("*")
    @ResponseBody
    public AppUser createAppUser(@RequestBody AppUser AppUser) {
        return AUserRepo.save(AppUser);
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    @ResponseBody
    public ResponseEntity<AppUser> updateAppUser(
            @PathVariable(value = "id") Integer AppUserId, @RequestBody AppUser AppUserDetails)
            throws ResourceNotFoundException {
        AppUser AppUser =
                AUserRepo
                        .findById(AppUserId)
                        .orElseThrow(() -> new ResourceNotFoundException("AppUser not found on :: " + AppUserId));
        AppUser.setFullName(AppUserDetails.getFullName());
        AppUser.setUserName(AppUserDetails.getUserName());
        AppUser.setPassword(AppUserDetails.getPassword());
        final AppUser updatedAppUser = AUserRepo.save(AppUser);
        return ResponseEntity.ok(updatedAppUser);
    }
}
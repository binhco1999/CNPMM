package com.macia.HRs.api;
import com.macia.HRs.entity.Daily_Schedule;
import com.macia.HRs.repository.DailyScheduleRepository;
import com.macia.HRs.service.DailyScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dailyschedules")
public class DailyScheduleResource {

    @Autowired
    private DailyScheduleRepository dlsRepo;

    @Autowired
    private DailyScheduleService dlsService;


    @GetMapping()
    @CrossOrigin("*")
    public List<Daily_Schedule> getAllDailySchedule(){
        return dlsService.findAllAvailable();
    }

    @GetMapping("/count")
    @CrossOrigin("*")
    public Long count() {

        return dlsRepo.count();
    }
    @DeleteMapping("/{id}/uid/{uid}")
    @CrossOrigin("*")
    public Map<String, Boolean> deleteDailySchedule(@PathVariable(value = "id") Integer DailyScheduleId,@PathVariable(value = "uid") Integer uid) throws Exception {
        Daily_Schedule DailySchedule =
                dlsRepo
                        .findById(DailyScheduleId)
                        .orElseThrow(() -> new ResourceNotFoundException("DailySchedule not found on :: " + DailyScheduleId));
        DailySchedule.setIsdeleted(Boolean.TRUE);
        DailySchedule.setModifyBy(uid);
        dlsRepo.save(DailySchedule);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<Daily_Schedule> getDailyScheduleById(@PathVariable(value = "id") Integer DailyScheduleId)
            throws ResourceNotFoundException {
        Daily_Schedule DailySchedule =
                dlsRepo
                        .findById(DailyScheduleId)
                        .orElseThrow(() -> new ResourceNotFoundException("DailySchedule not found on :: " + DailyScheduleId));
        return ResponseEntity.ok().body(DailySchedule);
    }


    @PostMapping()
    @CrossOrigin("*")
    public Daily_Schedule createDailySchedule(@RequestBody Daily_Schedule DailySchedule) {
        return dlsRepo.save(DailySchedule);
    }

    @PutMapping("/{id}/uid/{uid}")
    @CrossOrigin("*")
    public ResponseEntity<Daily_Schedule> updateDailySchedule(
            @PathVariable(value = "id") Integer DailyScheduleId,
            @PathVariable(value = "uid") Integer uid,
            @RequestBody Daily_Schedule DailyScheduleDetails)
            throws ResourceNotFoundException {
        Daily_Schedule DailySchedule =
                dlsRepo
                        .findById(DailyScheduleId)
                        .orElseThrow(() -> new ResourceNotFoundException("DailySchedule not found on :: " + DailyScheduleId));
        DailySchedule.setName(DailyScheduleDetails.getName());
        DailySchedule.setModifyBy(uid);
        final Daily_Schedule updatedDailySchedule = dlsRepo.save(DailySchedule);
        return ResponseEntity.ok(updatedDailySchedule);
    }
}
package com.macia.HRs.api;

import com.macia.HRs.DTO.TimeKeepingDTO;
import com.macia.HRs.entity.TimeKeeping;
import com.macia.HRs.repository.TimeKeepingRepository;
import com.macia.HRs.service.TimeKeepingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/timekeepings")
public class TimeKeepingResource {

    @Autowired
    private TimeKeepingService tkpService;

    @Autowired
    private TimeKeepingRepository tkpRepo;

    @PersistenceContext
    EntityManager em;


    @PostMapping("/syncdatas/{date}")
    @ResponseBody
    public String syncData(@PathVariable(value = "date") String date) throws Exception {
        Integer record = tkpService.syncTKPDataViaProcByDate(date);
        if(record>0){
            return "Successfully synchronized "+record+" lines of data!";
        }
        return "Everything has been synchronized!";
    }

    @GetMapping("/date/{date}/dept/{depid}")
    @CrossOrigin("*")
    @ResponseBody
    public List<TimeKeepingDTO> getTimeKeepingByDeptIDAndDate(
            @PathVariable(value = "date") String date,
            @PathVariable(value = "depid") Integer depid) {
        return tkpService.getTimeKeepingByDeptIDAndDate(date,depid);
    }

    @GetMapping("/date/{date}")
    @CrossOrigin("*")
    @ResponseBody
    public List<TimeKeepingDTO> getTimeKeepingByDate(@PathVariable(value = "date") String date) {
        return tkpService.getTimeKeepingByDate(date);
    }

    @DeleteMapping("/{id}/uid/{uid}")
    @CrossOrigin("*")
    public Map<String, Boolean> deleteTimeKeeping(@PathVariable(value = "id") Integer timekeepingId,@PathVariable(value = "uid") Integer uid) throws Exception {
        TimeKeeping timeKeeping =
                tkpRepo
                        .findById(timekeepingId)
                        .orElseThrow(() -> new ResourceNotFoundException("TimeKeeping not found on :: " + timekeepingId));
        timeKeeping.setIsDeleted(Boolean.TRUE);
        timeKeeping.setModifyBy(uid);
        tkpRepo.save(timeKeeping);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/{id}/uid/{uid}")
    @ResponseBody
    @CrossOrigin("*")
    public ResponseEntity<TimeKeeping> updateTimeKeeping(
            @PathVariable(value = "id") Integer timekeepingId,
            @PathVariable(value = "uid") Integer uid,
            @RequestBody TimeKeeping timeKeepingDetails)
            throws ResourceNotFoundException {
        TimeKeeping timeKeeping =
                tkpRepo
                        .findById(timekeepingId)
                        .orElseThrow(() -> new ResourceNotFoundException("TimeKeeping not found on :: " + timekeepingId));
        timeKeeping.setDateTime(timeKeepingDetails.getDateTime());
        timeKeeping.setModifyBy(uid);
        final TimeKeeping updatedTimeKeeping = tkpRepo.save(timeKeeping);
        return ResponseEntity.ok(updatedTimeKeeping);
    }
}

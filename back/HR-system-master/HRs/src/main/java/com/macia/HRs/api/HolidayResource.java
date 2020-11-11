package com.macia.HRs.api;

import com.macia.HRs.entity.Holiday;
import com.macia.HRs.repository.HolidayRepository;
import com.macia.HRs.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/holidaies")
public class HolidayResource {

    @Autowired
    private HolidayRepository HolidayRepository;

    @Autowired
    private HolidayService holService;


    @GetMapping()
    @CrossOrigin("*")
    public List<Holiday> getAllHoliday(){
        return holService.findAllAvailable();
    }

    @DeleteMapping("/{id}/uid/{uid}")
    @CrossOrigin("*")
    public Map<String, Boolean> deleteHoliday(@PathVariable(value = "id") Integer HolidayId,@PathVariable(value = "uid") Integer uid) throws Exception {
        Holiday holiday =
                HolidayRepository
                        .findById(HolidayId)
                        .orElseThrow(() -> new ResourceNotFoundException("Holiday not found on :: " + HolidayId));
        holiday.setIsDeleted(Boolean.TRUE);
        holiday.setModifyBy(uid);
        HolidayRepository.save(holiday);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<Holiday> getHolidayById(@PathVariable(value = "id") Integer HolidayId)
            throws ResourceNotFoundException {
        Holiday Holiday =
                HolidayRepository
                        .findById(HolidayId)
                        .orElseThrow(() -> new ResourceNotFoundException("Holiday not found on :: " + HolidayId));
        return ResponseEntity.ok().body(Holiday);
    }


    @PostMapping()
    @CrossOrigin("*")
    public Holiday createHoliday(@RequestBody Holiday Holiday) {
        return HolidayRepository.save(Holiday);
    }

    @PutMapping("/{id}/uid/{uid}")
    @CrossOrigin("*")
    public ResponseEntity<Holiday> updateHoliday(
            @PathVariable(value = "id") Integer HolidayId,
            @PathVariable(value = "uid") Integer uid,
            @RequestBody Holiday HolidayDetails)
            throws ResourceNotFoundException {
        Holiday Holiday =
                HolidayRepository
                        .findById(HolidayId)
                        .orElseThrow(() -> new ResourceNotFoundException("Holiday not found on :: " + HolidayId));
        Holiday.setDayName(HolidayDetails.getDayName());
        Holiday.setFromDate(HolidayDetails.getFromDate());
        Holiday.setToDate(HolidayDetails.getToDate());
        Holiday.setNumOfDayOff(HolidayDetails.getNumOfDayOff());
        Holiday.setCoefficient(HolidayDetails.getCoefficient());
        Holiday.setModifyBy(uid);
        final Holiday updatedHoliday = HolidayRepository.save(Holiday);
        return ResponseEntity.ok(updatedHoliday);
    }
}
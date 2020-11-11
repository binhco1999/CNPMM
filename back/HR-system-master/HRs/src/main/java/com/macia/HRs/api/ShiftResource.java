package com.macia.HRs.api;

import com.macia.HRs.entity.Shift;
import com.macia.HRs.repository.ShiftRepository;
import com.macia.HRs.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/shifts")
public class ShiftResource {

    @Autowired
    private ShiftRepository ShiftRepository;

    @Autowired
    private ShiftService shiftService;

    @GetMapping()
    @CrossOrigin("*")
    @ResponseBody
    public List<Shift> getAllShift(){
        return shiftService.findAllAvailable();
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    @ResponseBody
    public ResponseEntity<Shift> getShiftById(@PathVariable(value = "id") Integer ShiftId)
            throws ResourceNotFoundException {
        Shift Shift =
                ShiftRepository
                        .findById(ShiftId)
                        .orElseThrow(() -> new ResourceNotFoundException("Shift not found on :: " + ShiftId));
        return ResponseEntity.ok().body(Shift);
    }


    @PostMapping()
    @ResponseBody
    @CrossOrigin("*")
    public Shift createShift(@RequestBody Shift Shift) {
        return ShiftRepository.save(Shift);
    }

    @DeleteMapping("/{id}/uid/{uid}")
    @CrossOrigin("*")
    public Map<String, Boolean> deleteShift(@PathVariable(value = "id") Integer ShiftId,@PathVariable(value = "uid") Integer uid) throws Exception {
        Shift shift =
                ShiftRepository
                        .findById(ShiftId)
                        .orElseThrow(() -> new ResourceNotFoundException("Shift not found on :: " + ShiftId));
        shift.setIsDeleted(Boolean.TRUE);
        shift.setModifyBy(uid);
        ShiftRepository.save(shift);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @PutMapping("/{id}/uid/{uid}")
    @CrossOrigin("*")
    @ResponseBody
    public ResponseEntity<Shift> updateShift(
            @PathVariable(value = "id") Integer ShiftId,
            @PathVariable(value = "uid") Integer uid,
            @RequestBody Shift ShiftDetails)
            throws ResourceNotFoundException {
        Shift Shift =
                ShiftRepository
                        .findById(ShiftId)
                        .orElseThrow(() -> new ResourceNotFoundException("Shift not found on :: " + ShiftId));
        Shift.setShiftName(ShiftDetails.getShiftName());
        Shift.setShiftCode(ShiftDetails.getShiftCode());
        Shift.setModifyBy(uid);
        final Shift updatedShift = ShiftRepository.save(Shift);
        return ResponseEntity.ok(updatedShift);
    }
}
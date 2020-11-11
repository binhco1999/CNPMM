package com.macia.HRs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeKeepingDTO {
    private Integer tkp_id;
    private String fullname;
    private String checktime;
    private String shift_name;
    private String type;
}

use hrs
go

CREATE PROC get_TimeKeeping_Data_By_Date(@date date)
AS
	SELECT T.tkp_id,E.last_name + ' ' + E.first_name fullname,SUBSTRING( CONVERT(varchar, CONVERT(time,T.date_time),108),1,5) checktime,S.shift_name,
		--DS.start_time,DS.END_time,
		CASE WHEN CONVERT(time,T.date_time) < CONVERT(time,CAST(DS.start_time AS datetime) + CAST(CONVERT(TIME,'01:00:00') AS datetime)) and S.shift_code != 'CA3' THEN 'in'
			WHEN CONVERT(time,T.date_time) > DS.start_time and S.shift_code != 'CA3' THEN 'out'
			WHEN CONVERT(time,T.date_time) < CONVERT(time,CAST(DS.END_time AS datetime) + CAST(CONVERT(TIME,'01:00:00') AS datetime)) and S.shift_code = 'CA3' THEN 'out'
			WHEN CONVERT(time,T.date_time) > DS.END_time and S.shift_code = 'CA3' THEN 'in'
		END AS [type]
	
	FROM time_keeping T,employee E,[shift] S,employee_shift ES,shift_daily SD, daily_schedule DS

	WHERE	SD.day_of_week = DATEPART(dw,t.date_time)
			and T.is_deleted = 0
			and T.event_data != 0 and CONVERT(date,T.date_time) = @Date  
			and ES.[start_date] < @Date and ES.[END_date] > @Date
			and T.emp_id = E.emp_id and E.emp_id=ES.emp_id and ES.sif_id = S.sif_id and SD.sif_id = S.sif_id and SD.dls_id = DS.dls_id

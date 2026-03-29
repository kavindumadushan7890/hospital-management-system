package com.example.hospital_management_system.doctor.mapper;

import com.example.hospital_management_system.doctor.dto.request.CreateDoctorScheduleRequest;
import com.example.hospital_management_system.doctor.dto.request.UpdateDoctorScheduleRequest;
import com.example.hospital_management_system.doctor.dto.response.DoctorScheduleResponse;
import com.example.hospital_management_system.doctor.model.DoctorSchedule;
import lombok.Builder;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface DoctorScheduleMapper {

    DoctorSchedule toEntity(CreateDoctorScheduleRequest request);

    default DoctorScheduleResponse toResponse(DoctorSchedule doctorSchedule){

        return DoctorScheduleResponse.builder()
                .fullName(doctorSchedule.getDoctor().getFirstName() + " " + doctorSchedule.getDoctor().getLastName())
                .dayOfWeek(doctorSchedule.getDayOfWeek())
                .startTime(doctorSchedule.getStartTime())
                .endTime(doctorSchedule.getEndTime())
                .slotDuration(doctorSchedule.getSlotDuration())
                .doctorAvailable(doctorSchedule.getDoctorAvailable())
                .build();
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void doctorScheduleUpdate(UpdateDoctorScheduleRequest request , @MappingTarget DoctorSchedule doctorSchedule);



}

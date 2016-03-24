package com.joye.health.api;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.joye.health.error.AppExceptionMapper;
import com.joye.health.error.GenericExceptionMapper;
import com.joye.health.error.NotFoundExceptionMapper;
import com.joye.health.filter.LoggingResponseFilter;
import com.joye.health.rest.baseinfo.CvAreaDictRest;
import com.joye.health.rest.baseinfo.HealthOfficerRest;
import com.joye.health.rest.baseinfo.HospitalBasicRest;
import com.joye.health.rest.emergency.CvEventClassDictRest;
import com.joye.health.rest.emergency.HeEventContingencyRecordRest;
import com.joye.health.rest.emergency.HeEventEndReportRest;
import com.joye.health.rest.emergency.HeEventFirstReportRest;
import com.joye.health.rest.emergency.HeEventLocalePictureRest;
import com.joye.health.rest.emergency.HeEventMavinRecordRest;
import com.joye.health.rest.emergency.HeEventPersonReportRest;
import com.joye.health.rest.emergency.HeEventProcessReportRest;
import com.joye.health.rest.emergency.HeEventTroopCollectRest;
import com.joye.health.rest.emergency.HeResourceRecordRest;
import com.joye.health.rest.emergency.HeTroopMemberRecordRest;
import com.joye.health.rest.emergency.HeUnitVehicleRecordRest;
import com.joye.health.rest.emergency.HeUnitsLocationRest;
import com.joye.health.rest.epidemic.EaNetDataRest;
import com.joye.health.rest.epidemic.MssIndexBasicRest;
import com.joye.health.rest.epidemic.MssIndexDiagnoseRest;
import com.joye.health.rest.epidemic.MssIndexOperationRest;
import com.joye.health.rest.epidemic.MssIndexTransfusionRest;
import com.joye.health.rest.epidemic.MssOutDiagnosisRest;
import com.joye.health.rest.epidemic.MssOutVisitRest;

public class MyApplication extends ResourceConfig{
	
	public MyApplication() {
		// register application resources
		register(HospitalBasicRest.class);
		register(HealthOfficerRest.class);
		register(CvAreaDictRest.class);
		register(MssOutVisitRest.class);
		register(EaNetDataRest.class);
		register(MssIndexBasicRest.class);
		register(MssIndexDiagnoseRest.class);
		register(MssIndexOperationRest.class);
		register(MssIndexTransfusionRest.class);
		register(MssOutDiagnosisRest.class);
		register(CvEventClassDictRest.class);
		register(HeEventContingencyRecordRest.class);
		register(HeEventEndReportRest.class);
		register(HeEventFirstReportRest.class);
		register(HeEventLocalePictureRest.class);
		register(HeEventMavinRecordRest.class);
		register(HeEventPersonReportRest.class);
		register(HeEventProcessReportRest.class);
		register(HeEventTroopCollectRest.class);
		register(HeResourceRecordRest.class);
		register(HeTroopMemberRecordRest.class);
		register(HeUnitsLocationRest.class);
		register(HeUnitVehicleRecordRest.class);
		// register filters
		register(RequestContextFilter.class);
		register(LoggingResponseFilter.class);
		// exception mapper
		register(NotFoundExceptionMapper.class);
		register(GenericExceptionMapper.class);
		register(AppExceptionMapper.class);
		// register features
		register(JacksonFeature.class);	
	}

}

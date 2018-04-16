package com.ncepulcy.battery_monitor.controller;

import com.ncepulcy.battery_monitor.entity.BatterySingleTest;
import com.ncepulcy.battery_monitor.service.BatterySingleTestService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("batterysingletest")
public class BatterySingleTestAction {

    @Autowired
    private BatterySingleTestService batterySingleTestService;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<BatterySingleTest> findAll(){
        return batterySingleTestService.findAll();
    }

    @GET
    @Path("{groupid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<BatterySingleTest> listSecMenu(@PathParam("groupid") String gid){
        return batterySingleTestService.findByGroupID(gid);
    }
}

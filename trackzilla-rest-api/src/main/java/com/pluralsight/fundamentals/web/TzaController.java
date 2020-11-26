package com.pluralsight.fundamentals.web;

import com.pluralsight.fundamentals.entity.Application;
import com.pluralsight.fundamentals.entity.Release;
import com.pluralsight.fundamentals.entity.Ticket;
import com.pluralsight.fundamentals.exception.ApplicationNotFoundException;
import com.pluralsight.fundamentals.services.ApplicationService;
import com.pluralsight.fundamentals.services.ReleaseService;
import com.pluralsight.fundamentals.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tza")
public class TzaController {
    private ApplicationService applicationService;
    private TicketService ticketService;
    private ReleaseService releaseService;

    @Autowired
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Autowired
    public void setReleaseService(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }


    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getAllApplications(){
        List<Application> list = applicationService.listApplications();
        return new ResponseEntity<List<Application>>(list, HttpStatus.OK);
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable("id") long id){
        try{
            return new ResponseEntity<Application>(applicationService.findApplication(id), HttpStatus.OK);
        }catch (ApplicationNotFoundException anfe){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found");
        }
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        List<Ticket> list = ticketService.listTickets();
        return new ResponseEntity<List<Ticket>>(list, HttpStatus.OK);
    }

    @GetMapping("/releases")
    public ResponseEntity<List<Release>> getAllReleases(){
        List<Release> list = releaseService.listReleases();
        return new ResponseEntity<List<Release>>(list, HttpStatus.OK);
    }
}
package com.pluralsight.fundamentals.services;

import com.pluralsight.fundamentals.entity.Ticket;

public interface TicketService {
    Iterable<Ticket> listTickets();
}



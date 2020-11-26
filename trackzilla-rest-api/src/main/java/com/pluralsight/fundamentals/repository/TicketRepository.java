package com.pluralsight.fundamentals.repository;

import com.pluralsight.fundamentals.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}

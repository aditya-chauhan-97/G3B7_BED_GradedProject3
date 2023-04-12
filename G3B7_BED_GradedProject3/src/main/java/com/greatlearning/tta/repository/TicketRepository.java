package com.greatlearning.tta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.tta.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

	@Query("FROM Ticket p WHERE p.title LIKE %?1%"
            + " OR p.shortDescription LIKE %?1%"
            )
    public List<Ticket> search(String keyword);
}

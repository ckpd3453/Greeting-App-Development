package com.bridgelabz.greetingMessage.repository;

import com.bridgelabz.greetingMessage.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface extending the interface JpaRepository to perform services that are fired from the GreetingService class to the H2 Database,
 * by using one of the ORM Tool that is Hibernate.
 */
@Repository
public interface IGreetingRepository extends JpaRepository<Greeting, Long> {

}

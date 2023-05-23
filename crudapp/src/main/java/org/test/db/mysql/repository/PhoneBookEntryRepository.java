package org.test.db.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.db.mysql.entity.PhoneBookEntry;

@Repository
public interface PhoneBookEntryRepository extends JpaRepository<PhoneBookEntry, Long> {
}

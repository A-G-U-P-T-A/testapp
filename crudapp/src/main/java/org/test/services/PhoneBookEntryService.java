package org.test.services;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.db.mysql.entity.PhoneBookEntry;
import org.test.db.mysql.repository.PhoneBookEntryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneBookEntryService {
    private final PhoneBookEntryRepository phoneBookEntryRepository;

    @Autowired
    public PhoneBookEntryService(PhoneBookEntryRepository phoneBookEntryRepository) {
        this.phoneBookEntryRepository = phoneBookEntryRepository;
    }

    public List<PhoneBookEntry> getAllEntries() {
        return phoneBookEntryRepository.findAll();
    }

    public Optional<PhoneBookEntry> getEntryById(Long id) {
        return phoneBookEntryRepository.findById(id);
    }

    public PhoneBookEntry createEntry(PhoneBookEntry entry) {
        return phoneBookEntryRepository.save(entry);
    }

    public PhoneBookEntry updateEntry(Long id, PhoneBookEntry entry) {
        Optional<PhoneBookEntry> existingEntry = phoneBookEntryRepository.findById(id);
        if (existingEntry.isPresent()) {
            PhoneBookEntry updatedEntry = existingEntry.get();
            updatedEntry.setFirstName(entry.getFirstName());
            updatedEntry.setLastName(entry.getLastName());
            updatedEntry.setPhoneNumber(entry.getPhoneNumber());
            return phoneBookEntryRepository.save(updatedEntry);
        }
        return null;
    }

    public void deleteEntry(Long id) {
        phoneBookEntryRepository.deleteById(id);
    }
}

package org.test.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.test.db.mysql.entity.PhoneBookEntry;
import org.test.services.PhoneBookEntryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phonebook")
@Validated
public class PhoneBookEntryController {
    private final PhoneBookEntryService phoneBookEntryService;

    @Autowired
    public PhoneBookEntryController(PhoneBookEntryService phoneBookEntryService) {
        this.phoneBookEntryService = phoneBookEntryService;
    }

    @GetMapping
    public ResponseEntity<List<PhoneBookEntry>> getAllEntries() {
        List<PhoneBookEntry> entries = phoneBookEntryService.getAllEntries();
        return ResponseEntity.ok(entries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneBookEntry> getEntryById(@PathVariable("id") Long id) {
        Optional<PhoneBookEntry> entry = phoneBookEntryService.getEntryById(id);
        return entry.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PhoneBookEntry> createEntry(@Valid @RequestBody PhoneBookEntry entry) {
        PhoneBookEntry createdEntry = phoneBookEntryService.createEntry(entry);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhoneBookEntry> updateEntry(
            @PathVariable("id") Long id,
            @Valid @RequestBody PhoneBookEntry entry
    ) {
        PhoneBookEntry updatedEntry = phoneBookEntryService.updateEntry(id, entry);
        if (updatedEntry != null) {
            return ResponseEntity.ok(updatedEntry);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable("id") Long id) {
        phoneBookEntryService.deleteEntry(id);
        return ResponseEntity.noContent().build();
    }
}

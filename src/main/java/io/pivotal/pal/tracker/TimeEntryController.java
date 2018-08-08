package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.Time;
import java.util.List;

@RestController()
@RequestMapping("/time-entries")
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
      this.timeEntryRepository=timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry timeEntryCreated=timeEntryRepository.create(timeEntryToCreate);
        return ResponseEntity.created(URI.create("/create")).header("MyResponseHeader", "MyValue").body(timeEntryCreated);
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long id) {
        TimeEntry timeEntryToFind=timeEntryRepository.find(id);
        if (timeEntryToFind!=null) return ResponseEntity.ok().body(timeEntryToFind);
        else return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> list=timeEntryRepository.list();
        return ResponseEntity.ok().body(list);
        //return new ResponseEntity<>()
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry timeEntry) {
        TimeEntry timeEntryUpdated=timeEntryRepository.update(id, timeEntry);
        if (timeEntryUpdated!=null) return ResponseEntity.ok().body(timeEntryUpdated);
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {
        //if (timeEntryRepository.find(id)!=null) {
            timeEntryRepository.delete(id);
            return ResponseEntity.noContent().build();
        //}
        //else return ResponseEntity.notFound().build();
    }
}

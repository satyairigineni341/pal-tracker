package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository()
public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    List<TimeEntry> timeEntries=new ArrayList<>();
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(timeEntries.size()+1);
        //timeEntry.setId(Long.getLong(String.valueOf(timeEntries.size()+1)));
        timeEntries.add(timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long id) {
        TimeEntry timeEntry=null;
        for (TimeEntry timeEntryFound:timeEntries) {
            if(timeEntryFound.getId().equals(id)) timeEntry=timeEntryFound;
        }
        return timeEntry;
    }


    public List<TimeEntry> list() {
        return timeEntries;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry timeEntryFound=null;
        for(TimeEntry timeEntrySearch:timeEntries) {
            if (timeEntrySearch.getId().equals(id)) timeEntryFound = timeEntrySearch;
        }
        if (timeEntryFound!=null) {
            timeEntryFound.setProjectId(timeEntry.getProjectId());
            timeEntryFound.setUserId(timeEntry.getUserId());
            timeEntryFound.setDate(timeEntry.getDate());
            timeEntryFound.setHours(timeEntry.getHours());
        }
        return timeEntryFound;
    }

    public void delete(long id) {
        TimeEntry timeEntryFound=null;
        for(TimeEntry timeEntrySearch:timeEntries) {
            if(timeEntrySearch.getId().equals(id)) timeEntryFound=timeEntrySearch;
        }
        timeEntries.remove(timeEntryFound);
    }


}

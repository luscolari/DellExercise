package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Register  {

    private final List<Team> collection;

    public Register() {
        collection = new ArrayList<Team>();
    }

    public void removeTeams(Team t) {
        collection.remove(t);
    }

    public void addTeams(Team t) {
        collection.add(t);
    }

    public List<Team> getTeams() {
        return collection;
    }

        @Override
        public String toString () {
            String total = "\n";
            Iterator<Team> i = collection.iterator();
            while (i.hasNext()) {
                Team t = (Team) i.next();
                total = total + t.toString();
            }
            return total;
        }
    }


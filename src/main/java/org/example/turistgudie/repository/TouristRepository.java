package org.example.turistgudie.repository;

import org.example.turistgudie.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> data = new ArrayList<>();

    public TouristRepository() {
        populateAttractions();
    }

    private void populateAttractions() {
        data.add(new TouristAttraction("Tivoli", "Rutjebaner og såen"));
        data.add(new TouristAttraction("Bibliotek", "Man kan blive rundtosset"));
        data.add(new TouristAttraction("FCKstadion", "Nordens største"));
        data.add(new TouristAttraction("EK", "tidligere kendt som KEA"));
    }

    public List<TouristAttraction> getAll() {
        return data;
    }

    public TouristAttraction addAttraction(TouristAttraction attraction) {
        TouristAttraction newTouristAttraction = new TouristAttraction(attraction.getName(), attraction.getDescription());
        data.add(newTouristAttraction);
        return newTouristAttraction;
    }

    public TouristAttraction deleteAttraction(TouristAttraction attraction) {
        for (int i = 0; i < data.size(); i++) {
            TouristAttraction t = data.get(i);
            if (attraction.getName().equals(t.getName())) {
                return data.remove(i);
            }
        }
        return null;
    }

    public TouristAttraction findAttractionByName(String name) {
        for (TouristAttraction attraction : data) {
            if (attraction.getName().equals(name)) {
                return attraction;
            }
        }
        return null;
    }

    public TouristAttraction updateAttraction(String name, TouristAttraction updatedAttraction) {
        for (TouristAttraction t : data) {
            if (t.getName().equals(name)) {
                t.setName(updatedAttraction.getName());
                t.setDescription(updatedAttraction.getDescription());
                return t;
            }
        }
        return null;
    }
}
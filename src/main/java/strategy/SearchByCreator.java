package strategy;

import java.util.ArrayList;
import java.util.List;
import model.Item;

/**
 * Search strategy: match by creator (author/director).
 */
public class SearchByCreator implements SearchStrategy {

    @Override
    public List<Item> search(List<Item> items, String query) {
        List<Item> results = new ArrayList<>();
        for (Item item : items) {
            if (item.getCreator().equalsIgnoreCase(query)) {
                results.add(item);
            }
        }
        return results;
    }
}

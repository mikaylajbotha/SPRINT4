package strategy;

import java.util.List;
import model.Item;

/**
 * Strategy interface for catalog searching.
 */
public interface SearchStrategy {
    List<Item> search(List<Item> items, String query);
}

package bradforj287.SimpleTextSearch;

import com.bradforj287.SimpleTextSearch.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brad on 6/7/15.
 */

public class SimpleTextSearchTest {


    @Test
    public void testSearchIndex() {

        String doc1 = "Index is test";

       // String doc2 = "Index test";

        //String doc3 = "test is good";

        //String doc4 = "inverted index";

        List<Document> documents = new ArrayList<>();
        documents.add(new Document(doc1, new Integer(1)));
       // documents.add(new Document(doc2, new Integer(2)));
       // documents.add(new Document(doc3, new Integer(3)));
        //documents.add(new Document(doc4, new Integer(4)));

        TextSearchIndex index = SearchIndexFactory.buildIndex(documents);

        String searchTerm = "test";

        SearchResultBatch batch = index.search(searchTerm, 1);
        List<SearchResult> results = batch.getSearchResults();

        // verify correct top result
        assert(results.get(0).getUniqueIdentifier().equals(4));

        boolean outOfOrder = false;
        for (int i = 0; i < results.size(); i++) {
            int next = i + 1;
            boolean hasNext = next < results.size();
            if (hasNext && ( results.get(next).getRelevanceScore() > results.get(i).getRelevanceScore() )) {
                outOfOrder = true;
            }
        }

        assert(outOfOrder == false);

        for (SearchResult result : results) {
            System.out.println(result.getUniqueIdentifier() + " " + result.getRelevanceScore());
        }
    }
}

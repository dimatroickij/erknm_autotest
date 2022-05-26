package testCases.news;

import java.util.UUID;

public class NewsERKNMTest extends NewsTest {
    // Раздел Новости в режиме ЕРКНМ
    public NewsERKNMTest() throws Exception {
        super();
        prefixNews = UUID.randomUUID().toString();
        mode = true;
    }
}

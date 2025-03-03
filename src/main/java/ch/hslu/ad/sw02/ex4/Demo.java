package ch.hslu.ad.sw02.ex4;

import ch.hslu.ad.sw01.Ackermann;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {

    private static final Logger LOG = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        Queue q = new Queue();
        LOG.info("Head is currently at '{}' of full queue: {}", q.checkNextItem(), q.toString());
        q.enqueue('a');
        q.enqueue('b');
        q.enqueue('c');
        LOG.info("Head is currently at '{}' of full queue: {}", q.checkNextItem(), q.toString());
        LOG.info("Dequeueing item: '{}'", q.dequeue());
        q.enqueue('d');
        LOG.info("Head is currently at '{}' of full queue: {}", q.checkNextItem(), q.toString());
    }
}

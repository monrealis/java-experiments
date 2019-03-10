package eu.vytenis.asyncsockets;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class AsyncSocketsTest {
    private Selector selector;
    private ByteBuffer buffer = ByteBuffer.allocate(50);

    @Before
    public void before() throws IOException {
        selector = Selector.open();
    }

    @Test
    public void run() throws Exception {
        makeHttpRequest("lrytas.lt");
        makeHttpRequest("delfi.lt");
        //Thread.sleep(1);
        int n = selector.selectNow();
        System.out.println("Number of ready channels: " + n + "\n");

        Iterator<SelectionKey> it = selector.selectedKeys().iterator();

        while (it.hasNext())
            read(it.next());
    }

    private void makeHttpRequest(String host) throws IOException {
        SocketChannel c = SocketChannel.open(new InetSocketAddress(host, 80));
        c.configureBlocking(false);
        String s = String.format("GET / HTTP/1.0\nHost: %s\n\n", host);
        c.write(ByteBuffer.wrap(s.getBytes()));
        c.register(selector, SelectionKey.OP_READ);
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel ss = (SocketChannel) key.channel();
        for (int i = 0; i < 100; ++i) {
            buffer.clear();
            int count = ss.read(buffer);
            if (count < 0) {
                break;
            }
            System.out.print(new String(buffer.array(), 0, count));
        }
        System.out.println();
    }
}

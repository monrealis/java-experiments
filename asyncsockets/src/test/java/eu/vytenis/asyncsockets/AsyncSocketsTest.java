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
    private ByteBuffer buffer = ByteBuffer.allocate(5);

    @Before
    public void before() throws IOException {
        selector = Selector.open();
    }

    @Test
    public void run() throws Exception {
        makeHttpRequest("lrytas.lt", 80);
        makeHttpRequest("delfi.lt", 80);
        int n = selector.selectNow();
        System.out.println("Number of ready channels: " + n + "\n");

        readAll();
    }

    // Start server with "nc -l 8080"
    @Test
    public void local() throws Exception {
        makeHttpRequest("localhost", 8080);
        while (true) {
            selector.select();
            readAll();
        }
    }

    private void makeHttpRequest(String host, int port) throws IOException {
        SocketChannel c = SocketChannel.open(new InetSocketAddress(host, port));
        c.configureBlocking(false);
        String s = String.format("GET / HTTP/1.0\nHost: %s\n\n", host);
        c.write(ByteBuffer.wrap(s.getBytes()));
        c.register(selector, SelectionKey.OP_READ);
    }

    private void readAll() throws IOException {
        Iterator<SelectionKey> it = selector.selectedKeys().iterator();
        while (it.hasNext()) {
            read(it.next());
            it.remove();
        }
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel c = (SocketChannel) key.channel();
        for (int i = 0; i < 100; ++i) {
            buffer.clear();
            int count = c.read(buffer);
            if (count < 0) {
                break;
            }
            System.out.print(new String(buffer.array(), 0, count));
        }
        System.out.println();
    }
}

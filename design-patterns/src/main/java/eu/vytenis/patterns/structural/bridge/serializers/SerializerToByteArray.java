package eu.vytenis.patterns.structural.bridge.serializers;

import eu.vytenis.patterns.structural.bridge.api.Serializer;

import java.io.*;

public class SerializerToByteArray implements Serializer<byte[]> {
    @Override
    public Object load(byte[] from) {
        try {
            return tryLoad(from);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Object tryLoad(byte[] from) throws IOException, ClassNotFoundException {
        return new ObjectInputStream(new ByteArrayInputStream(from)).readObject();
    }

    @Override
    public byte[] save(Object o) {
        try {
            return trySave(o);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] trySave(Object o) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        new ObjectOutputStream(bos).writeObject(o);
        return bos.toByteArray();
    }
}

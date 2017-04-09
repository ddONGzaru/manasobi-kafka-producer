package tv.anypoint.domain;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.ByteBufferOutput;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * Created by tw.jang on 2017-04-09.
 */
public class ImpressionLogSerializer implements Serializer<ImpressionLog> {

    private ThreadLocal<Kryo> kryos = new ThreadLocal<Kryo>() {
        protected Kryo initialValue() {
            Kryo kryo = new Kryo();
            kryo.addDefaultSerializer(ImpressionLog.class, new KryoInternalSerializer());
            return kryo;
        };
    };

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, ImpressionLog data) {

        ByteBufferOutput output = new ByteBufferOutput(100);
        kryos.get().writeObject(output, data);
        return output.toBytes();
    }

    @Override
    public void close() {

    }

    private static class KryoInternalSerializer extends com.esotericsoftware.kryo.Serializer<ImpressionLog> {
        @Override
        public void write(Kryo kryo, Output output, ImpressionLog impressionLog) {
            output.writeString(impressionLog.getId());
            output.writeLong(impressionLog.getAsset());
            output.writeLong(impressionLog.getCampaign());
            output.writeInt(impressionLog.getZipCode());
        }

        @Override
        public ImpressionLog read(Kryo kryo, Input input, Class<ImpressionLog> aClass) {
            String id = input.readString();
            //Sensor.Type type = Sensor.Type.valueOf(input.readString());

            return new ImpressionLog();
        }
    }
}

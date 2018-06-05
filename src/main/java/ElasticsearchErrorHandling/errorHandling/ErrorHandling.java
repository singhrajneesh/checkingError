package ElasticsearchErrorHandling.errorHandling;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class ErrorHandling {
	public void writeOperations(String errorMessage) {
		
		TransportClient client = null;
        try {
			client = new PreBuiltTransportClient(Settings.EMPTY)
			        .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
			IndexResponse response = client.prepareIndex("error", "type")
			        .setSource(jsonBuilder()
			                .startObject()
			                .field("errorMessage", errorMessage)
			                .field("@timestamp","1528197792")
			                .endObject()
			        )
			        .get();
		} catch (IOException e) {
			e.printStackTrace();
		}
        client.close();
	}
}

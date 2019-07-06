package io.vasilenko.remedy.spring.soap.client.sample.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.tempuri.Add;
import org.tempuri.AddResponse;

@Service
public class WsClient {

    private final WebServiceTemplate webServiceTemplate;

    @Autowired
    public WsClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public int sum(int a, int b) {
        Add operation = new Add();
        operation.setIntA(a);
        operation.setIntB(b);
        AddResponse response = (AddResponse) webServiceTemplate.marshalSendAndReceive(operation);
        return response.getAddResult();
    }
}

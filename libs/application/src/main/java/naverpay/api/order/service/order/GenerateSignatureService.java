package naverpay.api.order.service.order;

import com.nhncorp.psinfra.toolkit.SimpleCryptLib;
import naverpay.api.order.port.in.order.GenerateUseCase;
import org.springframework.stereotype.Service;

import java.security.SignatureException;

@Service
public class GenerateSignatureService implements GenerateUseCase {

    private static final String providerName = "Checkout";
    private static final String serviceName = "MallService5";
    private static final String operationName = "GetChangedProductOrderList";

    private static final String accessLicense = "accessLicense";
    private static final String secretKey = "secretKey";

    private static String timeStamp;
    private static String signature;
    @Override
    public void generateSignature() {
        timeStamp = SimpleCryptLib.getTimestamp();
        String data = timeStamp + serviceName + operationName;

        try {
            signature = SimpleCryptLib.generateSign(data, secretKey);
        } catch (SignatureException e) {
            throw new RuntimeException(e);
        }
    }
}



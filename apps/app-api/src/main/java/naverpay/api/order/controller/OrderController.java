package naverpay.api.order.controller;

import naverpay.api.order.port.in.order.GenerateUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final GenerateUseCase generateUseCase;

    public OrderController(GenerateUseCase generateUseCase) {
        this.generateUseCase = generateUseCase;
    }

    @GetMapping("/v1/order/getChangedProductOrderList")
    public String requestGetChangedProductOrderList() {
        generateUseCase.generateSignature();
        return null;
    }
}

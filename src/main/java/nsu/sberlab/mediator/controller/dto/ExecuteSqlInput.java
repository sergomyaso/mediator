package nsu.sberlab.mediator.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExecuteSqlInput {
    private String serviceName;
    private String transactionID;
    private String query;
}

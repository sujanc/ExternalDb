package com.stackroute.pie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;



@Document(collection="insurancelist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Insurer {

    private long insurerId;
    private String insurerName;
    private String insurerLicense;
    private String insurerEmail;
    private String insurerAddress;
    private long  policyId;
//    private List<Policy> policies;

}

package com.stackroute.pie.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="insurancelist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {

    private long policyId;
    private String insurerName;
    private String policyName;
    //private String policyType;
    private long minSumInsured;
    private long maxSumInsured;
    private int noOfCashLessHospitals;
    //private List<String> cashLessHospitals;
//    private long monthlyPremium;
//    private long yearlyPremium;
    //private List<String> diseasesCovered;
    //  private String age;
    private int minAge;
    private int maxAge;
    private int waitingPeriod;
    // private Timestamp createdAt;
    //  private Timestamp updatedAt;
    //  private String createdBy;
    //  private String updatedBy;
}

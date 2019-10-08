package com.intuit.domain;

import lombok.Data;

@Data
public class Bids {
    private String bidId;
    private String projectId;
    private String sellerId;
    private String buyerId;
    private Double bidValue;
    private BidStatus bidStatus;
}

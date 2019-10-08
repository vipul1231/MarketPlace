package com.intuit.repository;

import com.intuit.domain.Bids;
import com.intuit.domain.Buyer;
import com.intuit.domain.Project;
import com.intuit.domain.Seller;

import java.util.List;

public interface IMarketPlaceRepository {

    void addSeller(Seller seller);

    void addBuyer(Buyer buyer);

    void addProject(Project project);

    Seller getSeller(String sellerId);

    Buyer getBuyer(String buyerId);

    List<Project> getProjects(Integer limit, Integer start, Integer offset);

    void addBidToTheProject(Bids bids);

    Bids showLowestBidForProject(String projectId);
}

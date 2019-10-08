package com.intuit.repository.impl;

import com.intuit.domain.Bids;
import com.intuit.domain.Buyer;
import com.intuit.domain.Project;
import com.intuit.domain.Seller;
import com.intuit.repository.IMarketPlaceRepository;

import java.util.*;

public class MarketPlaceRepositoryImpl implements IMarketPlaceRepository {

    private Map<String, Seller> sellerDB = new HashMap<>();

    private Map<String, Buyer> buyerDB = new HashMap<>();

    /**
     * Key : seller Id
     * Value : Project
     */
    private Map<String, Project> sellerProjectMap = new HashMap<>();

    /**
     * Total active projects
     */
    private List<Project> totalProjectList = new ArrayList<>();

    /**
     * Key: project Id
     * Value : Bids
     */
    private Map<String, List<Bids>> projectBidMap = new HashMap<>();

    MarketPlaceRepositoryImpl() {
        totalProjectList.sort(returnComparator());
    }

    public void addSeller(Seller seller) {
        sellerDB.put(seller.getSellerId(),seller);
    }

    public void addBuyer(Buyer buyer) {
        buyerDB.put(buyer.getBuyerId(),buyer);
    }

    public void addProject(Project project) {
        sellerProjectMap.put(project.getSellerId(), project);
        totalProjectList.add(project);
    }

    @Override
    public Seller getSeller(String sellerId) {
        return sellerDB.get(sellerId);
    }

    @Override
    public Buyer getBuyer(String buyerId) {
        return buyerDB.get(buyerId);
    }

    public List<Project> getProjects(Integer limit, Integer start, Integer offset) {
        if(limit == null || limit == 0){
                if (totalProjectList.size() > 100){
                    return totalProjectList.subList(0, 100);
                }
        }

        int totalSize = totalProjectList.size();
        int end = start + offset;
        if(end > totalSize){
            end = totalSize-1;
        }

        return totalProjectList.subList(start, end);
    }

    @Override
    public void addBidToTheProject(Bids bid) {

        List<Bids> bidsList = projectBidMap.get(bid.getProjectId());
        Project project = sellerProjectMap.get(bid.getProjectId());
        if(bidsList == null || bidsList.size() == 0){
            List<Bids> newBidList = new ArrayList<>();
            newBidList.add(bid);
            projectBidMap.put(bid.getProjectId(), newBidList);

            project.setLowestBidPrice(bid.getBidValue());
        }
        else {
            bidsList.add(bid);
            bidsList.sort(returnBidsComparator());
            project.setLowestBidPrice(bidsList.get(0).getBidValue());
        }
    }

    @Override
    public Bids showLowestBidForProject(String projectId) {
        return null;
    }

    private Comparator<Project> returnComparator(){
            Comparator<Project> comparator = new Comparator<Project>() {
                @Override
                public int compare(Project o1, Project o2) {
                    return o1.getPostedDate().compareTo(o2.getPostedDate());
                }
            };
            return comparator;
    }

    private Comparator<Bids> returnBidsComparator() {
        Comparator<Bids> comparator = new Comparator<Bids>() {
            @Override
            public int compare(Bids o1, Bids o2) {
                if(o1.getBidValue() > o2.getBidValue()){
                    return 1;
                }
                else if(o1.getBidValue() == o2.getBidValue()){
                    return 0;
                }
                else {
                    return -1;
                }

            }
        };
        return comparator;
    }
}

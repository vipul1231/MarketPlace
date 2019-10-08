package com.intuit.service;

import com.intuit.domain.Buyer;
import com.intuit.domain.Project;
import com.intuit.domain.Seller;

import java.util.List;

public interface IMarketPlace {

    void addSeller(Seller seller);

    void addBuyer(Buyer buyer);

    void addProject(Project project);

    List<Project> getProjects(int limit);
}
